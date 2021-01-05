package com.mana.spring.service.impl;

import com.mana.spring.dao.*;
import com.mana.spring.domain.*;
import com.mana.spring.dto.OrderDTO;
import com.mana.spring.dto.OrderDTOConverter;
import com.mana.spring.dto.OrderListDTO;
import com.mana.spring.service.EmailService;
import com.mana.spring.service.OrderService;
import com.mana.spring.util.Pagination;
import com.squareup.square.Environment;
import com.squareup.square.SquareClient;
import com.squareup.square.api.PaymentsApi;
import com.squareup.square.models.CreatePaymentRequest;
import com.squareup.square.models.CreatePaymentResponse;
import com.squareup.square.models.Money;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    public EmailService emailService;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private CartItemDAO cartItemDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CouponDAO couponDAO;
    @Autowired
    private ProductDAO productDAO;

    /**
     * Calculate items total, calculate tax and shipping rate
     * Set statuses and connect user.
     * Save Order in db
     */
    @Override
    public Order calculateOrder(Order order, long userId) {

        ArrayList<CartItem> cartItems = (ArrayList<CartItem>) cartItemDAO.listUserCartItems(userId);

        System.out.println(order.getOrderId());

        double itemsTotal = 0, shippingAmount = 0, taxAmount = 0;
        User user = new User();
        user.setUserId(userId);
        order.setUser(user);

        for (CartItem ct : cartItems) {
            itemsTotal += (ct.getItemQuantity() * ct.getProduct().getProductPrice());
        }
        order.setSubTotal(itemsTotal);

        // Calculate tax rate and percentage based on shipping info.
        order.setShippingAmount(0);
        order.setShippingType("Standard Shipping");
        order.setTaxAmount(0);
        order.setTaxPercent(0);
        order.setFinalTotal(Double.parseDouble(new DecimalFormat("#0.00").format(itemsTotal + shippingAmount + taxAmount)));

        ///set statuses
        order.setOrderStatus("not executed");
        order.setPaymentStatus(false);

        //Save to database
        if (order.getOrderId() < 1)
            return orderDAO.saveOrder(order);
        else
            return orderDAO.updateOrder(order);

    }


    // Add a method to update cart and order subtotal when quantity changes during review step

    @Override
    public Order addCoupon(String couponName, long orderId) {
        Coupon coupon = couponDAO.getCoupon(couponName);
        Order order = orderDAO.getByOrderId(orderId);

        if (coupon != null && coupon.isActive() && order.getCouponName() == null) {

            double finalTotal = order.getFinalTotal();
            double subTotal = order.getSubTotal();
            double couponAmount = (coupon.getCouponDiscountPercent() / 100) * subTotal;
            order.setCouponName(coupon.getCouponName());
            order.setCouponPercent(coupon.getCouponDiscountPercent());
            order.setCouponAmount(couponAmount);

            finalTotal -= subTotal;
            subTotal -= couponAmount;
            finalTotal += subTotal;

            order.setFinalTotal(finalTotal);

            //Save to database
            orderDAO.saveOrder(order);

            System.out.println(order);

            return order;
        }
        return null;
    }

    @Override
    public Order processNewOrder(long orderId, NonceForm nonceForm) {

        Order orderFromDb = orderDAO.getByOrderId(orderId);

        if (!orderFromDb.getOrderStatus().equals("not executed"))
            return null;

        orderFromDb.setOrderPlacedDate(new Date()); //get from

        // Process and verify payment
        //make payment with api (finalTotal from order obj)

        squareInfo squareInfo = new squareInfo();
        Money money = new Money.Builder()
                .amount((long) (orderFromDb.getFinalTotal() * 100))
                .currency("USD")
                .build();

        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest.Builder(
                nonceForm.getNonce(),
                UUID.randomUUID().toString(),
                money)
                .autocomplete(true)
                .note("From a TEST Blueberry")
                .build();

        PaymentsApi paymentsApi = squareInfo.squareClient.getPaymentsApi();

        try {
            System.out.println("createPaymentResponse");
            CreatePaymentResponse createPaymentResponse = paymentsApi.createPayment(createPaymentRequest);
            System.out.println("Response.getPayment() : " + createPaymentResponse.getPayment());
            orderFromDb.setPaymentId(createPaymentResponse.getPayment().getId());
            orderFromDb.setPaymentVendor("square");
            orderFromDb.setPaymentStatus(true); // on payment success


            ArrayList<CartItem> cartItems = (ArrayList<CartItem>) cartItemDAO.listUserCartItems(orderFromDb.getUser().getUserId());
            HashSet<Purchase> purchases = new HashSet<>();

            //order priority (Need business logic)
            orderFromDb.setPriority(1);

            ///set statuses
            orderFromDb.setOrderStatus("new");
            orderFromDb.setConfirmationNumber("X" + orderFromDb.getOrderId() + "P" + orderFromDb.getPaymentId() + "U" + orderFromDb.getUser().getUserId());

            for (CartItem ct : cartItems) {
                Purchase purchase = new Purchase();
                purchase.setOrder(orderFromDb);
                productDAO.allocateFromInventory(ct.getProduct().getProductId());
                purchase.setProduct(ct.getProduct());
                purchase.setProductAmount(ct.getProduct().getProductPrice());
                purchase.setProductQuantity(ct.getItemQuantity());
                purchases.add(purchase);
            }

            orderFromDb.setPurchases(purchases);

            //Save to database
            orderFromDb = orderDAO.updateOrder(orderFromDb);

            //Empty cart
//        cartItemDAO.deleteUserCart(orderFromDb.getUser().getUserId());

            String emailHtml = generateOrderConfirmationEmail(orderFromDb);
            emailService.sendSimpleMessage(orderFromDb.getUser().getUserEmail(), "Your DZI Creations order #" + orderFromDb.getConfirmationNumber(), emailHtml);

            return orderFromDb;

        } catch (com.squareup.square.exceptions.ApiException | IOException e) {
            System.out.println("Payment response exception");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Order generateShippingLabelAndInvoice(long orderId) {
        // Research and implement shipping label API
        // Research and Generate Invoice

        //set statuses
        Order orderfromDb = orderDAO.getByOrderId(orderId);
        orderfromDb.setOrderStatus("pending shipment");

        //Save to database
        return orderDAO.updateOrder(orderfromDb);
    }

    @Override
    public void orderShipped(Order order) {

    }

    @Override
    public void orderReturnRequested(Order order) {

    }

    @Override
    public void orderCancelRequested(Order order) {

    }

    @Override
    public OrderListDTO getListByStatus(String statusFilter, int pageNumber) {
        OrderListDTO orderListDTO = new OrderListDTO();
        int size = Pagination.getPageSize();
        int start = (pageNumber - 1) * size, end = size;
        ArrayList<String> filters;

        switch (statusFilter) {
            case "voided":
            case "shipped":
            case "delivered and under return period":
            case "closed":
            case "refunded":
                filters = new ArrayList<>(Collections.singletonList(statusFilter));
                break;
            case "allOthers":
                filters = new ArrayList<>(Arrays.asList("voided", "shipped", "delivered and under return period", "closed", "refunded"));
                break;
            default:
                start = 0;
                end = 100;
                filters = new ArrayList<>(Collections.singletonList(statusFilter));
        }

        orderListDTO.convertAndSetOrderDTOS((ArrayList<Order>) orderDAO.getOrdersByMultipleStatus(filters, start, end));
        orderListDTO.setCount(orderDAO.countyMultipleStatus(filters));
        orderListDTO.setCurrentPageNumber(pageNumber);
        orderListDTO.calculateAndSetTotalPages();

        orderListDTO.setTotalNew(orderDAO.count("new"));
        orderListDTO.setTotalPendingShipment(orderDAO.count("pending shipment"));
        orderListDTO.setTotalReturnRequested(orderDAO.count("return requested"));
        orderListDTO.setStatusFilter(statusFilter);
        return orderListDTO;
    }

    @Override
    public OrderDTO getOrderById(long id) {
        return OrderDTOConverter.convertToDTO(orderDAO.getByOrderId(id));
    }

    @Override
    public OrderListDTO listPartialSearch(String searchWord) {
        OrderListDTO orderListDTO = new OrderListDTO();
        orderListDTO.convertAndSetOrderDTOS((ArrayList<Order>) orderDAO.listPartialSearch(searchWord));
        return orderListDTO;
    }

    @Override
    public void updatePrivateNote(String message, long orderId) {
        orderDAO.updatePrivateNote(message, orderId);
    }

    @Override
    public void updatePublicNote(String message, long orderId) {
        orderDAO.updatePublicNote(message, orderId);
    }

    @Override
    public void updateTrackingNumber(String trackingNumber, long orderId) {
        orderDAO.updateTrackingNumber(trackingNumber, orderId);

    }

    @Override
    public Order updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    private String generateOrderConfirmationEmail(Order order) {
        String products = "";
        for (Purchase purchase : order.getPurchases()) {
            String imageURL = "";
            for (Image image : purchase.getProduct().getImages()) {
                if (image.getImagePriority() == 1) {
                    imageURL = image.getImage_secure_url();
                    break;
                }
            }
            products += "<div style=\"border-bottom: rgba(255,191,0,0.69) solid thin; padding-bottom: 10px; margin-bottom: 10px; overflow: auto;\">" +
                    "       <img src=\"" + imageURL + "\" width=\"150\" alt=\"\" style=\"margin: 10px\">" +
                    "       <div style=\"margin: 10px;  float: right\">" +
                    "           <div style=\"margin-bottom: 5px\">" + purchase.getProduct().getProductName() + "</div>" +
                    "           <div style=\"margin-bottom: 5px; font-family: 'Arial Black', sans-serif\">$" + purchase.getProduct().getProductPrice() + "</div>" +
                    "           <div style=\"margin-bottom: 5px\">Quantity: " + purchase.getProductQuantity() + "</div>" +
                    "       </div>" +
                    " </div>";
        }

        return "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<body style=\"background: #393939; max-width: 1000px\">" +
                "    <div style=\"background-color: #1B1B1B; min-height: 80px; color: white; text-align: center\">" +
                "        <h1 style=\"padding-top: 15px; font-family: 'Arial Black', sans-serif\">DZI Creations</h1>" +
                "    </div>" +
                "" +
                "    <div style=\"color: white; text-align: center; font-family: 'Verdana',serif\">" +
                "        <h2>ORDER CONFIRMATION</h2>" +
                "        <div style=\"margin-bottom: 10px; border-bottom: rgba(123,123,123,0.62) solid thin; padding-bottom: 20px\">" +
                "            <span> " + order.getUser().getUserFirstName() + ", thank you for your order!</span><br><br>" +
                "            <span>We've received your order and will contact you as soon as your package is shipped. You can find your purchase information below.</span>" +
                "        </div>" +
                "" +
                "        <div style=\"margin-bottom: 5px;  color: #10fc00\">Confirmation No.: X78d097d</div>" +
                "        <div style=\"margin-bottom: 5px\">Order Date: 19 Mar 2020</div>" +
                "        <div style=\"margin: 50px 100px; text-align: left\">" +
                products +
                "        </div>" +
                "        <h3>ORDER TOTAL</h3>" +
                "        <div style=\"border-top: rgba(123,123,123,0.62) solid thin; text-align: left; padding: 20px\">" +
                "            <div style=\"margin-bottom: 5px; \"><div style=\"float: left\" >Subtotal price </div> <div style=\"float: right\">$" + order.getSubTotal() + "</div></div><br>" +
                "            <div style=\"margin-bottom: 5px; \"><div style=\"float: left\">Discount </div> <div style=\"float: right\">$" + order.getCouponAmount() + "</div></div><br>" +
                "            <div style=\"margin-bottom: 5px; \"><div style=\"float: left\">Shipping price </div> <div style=\"float: right\">$" + order.getShippingAmount() + "</div></div><br>" +
                "            <div style=\"margin-bottom: 5px; \"><div style=\"float: left\">Taxes </div> <div style=\"float: right\">$" + order.getTaxAmount() + "</div></div><br>" +
                "        </div>" +
                "        <div style=\"border-top: rgba(123,123,123,0.62) solid thin; text-align: left; padding: 20px\">" +
                "            <div style=\"margin-bottom: 5px;\"><div style=\"font-weight: bolder; float: left\">Total price </div> <div style=\"border-bottom: red thin solid; padding-bottom: 5px; font-weight: bold; float: right\">$" + order.getFinalTotal() + "</div></div>" +
                "        </div>" +
                "        <h3>BILLING AND SHIPPING</h3>" +
                "        <div style=\"text-align: left\">" +
                "            <div style=\"background-color: #002f30; padding: 15px\">" +
                "                <h3>Billing</h3>" +
                "                <hr>" +
                "                <div style=\"margin-bottom: 5px\">First and Last Name</div>" +
                "                <div style=\"margin-bottom: 5px\">Address Line, City, State, Zip code, Country</div>" +
                "                <div style=\"margin-top: 20px\">" +
                "                    <h4>Payment Method</h4>" +
                "                    <div style=\"margin-bottom: 5px\">Visa **** **** ****</div>" +
                "                </div>" +
                "            </div>" +
                "            <div style=\"background-color: #002f30; padding: 15px\">" +
                "                <h3>Shipping</h3>" +
                "                <hr>" +
                "                <div style=\"margin-bottom: 5px\">" + order.getShippingAddressName() + "</div>" +
                "                <div style=\"margin-bottom: 5px\">" + order.getShippingAddressLine() + ", " + order.getShippingAddressCity() +
                ", " + order.getShippingAddressState() + ", " + order.getShippingAddressZipCode() + ", " + order.getShippingAddressCountry() + "</div>" +
                "                <div style=\"margin-top: 20px\">" +
                "                    <h4>Shipping Method</h4>" +
                "                    <div style=\"margin-bottom: 5px\">" + order.getShippingType() + "</div>" +
                "                </div>" +
                "            </div>" +
                "        </div>" +
                "        <div style=\"border-top: rgba(123,123,123,0.62) solid thin; text-align: left; padding: 20px; margin-top: 20px; background-color: #001840\">" +
                "            <h3>Changed your mind?</h3>" +
                "            <div  style=\"margin-bottom: 20px\">" +
                "                <h4>Cancelling an order</h4>" +
                "                We're not able to make changes to your order, but you do have the option to cancel it <span style=\"text-decoration: underline; color: #59bdff!important;\">within 12 hours.</span>" +
                "            </div>" +
                "            <div>" +
                "                <h4>Returning an order</h4>" +
                "                Due to hygiene reasons we are unable to accept returns. You can contact us for any product maintenance tips or meet and greet us in our next exhibition show" +
                "                <br>" +
                "            </div>" +
                "        </div>" +
                "    </div>" +
                "" +
                "</body>" +
                "</html>";
    }

    private static class squareInfo {
        // The environment variable containing a Square Personal Access Token.
        // This must be set in order for the application to start.
        private static final String SQUARE_ACCESS_TOKEN_ENV_VAR = "EAAAEAiC0BN1iF72IfVx4XFZ0cJqwHcRWr8cFXT3fHvoEoOdv4n7392d3lLmA1Xk";

        // The environment variable containing a Square application ID.
        // This must be set in order for the application to start.
        private static final String SQUARE_APP_ID_ENV_VAR = "sandbox-sq0idb-CyPkJ2otv3yMaHkEhm1apQ";

        // The environment variable containing a Square location ID.
        // This must be set in order for the application to start.
        private static final String SQUARE_LOCATION_ID_ENV_VAR = "LR1BDD08QQN1E";

        // The environment variable indicate the square environment - sandbox or
        // production.
        // This must be set in order for the application to start.
        private static final String SQUARE_ENV_ENV_VAR = "sandbox";

        private final SquareClient squareClient;

        squareInfo() {

//            String squareEnvironment = mustLoadEnvironmentVariable(SQUARE_ENV_ENV_VAR);

            squareClient = new SquareClient.Builder()
                    .environment(Environment.fromString(SQUARE_ENV_ENV_VAR))
                    .accessToken(SQUARE_ACCESS_TOKEN_ENV_VAR).build();
        }

        private String mustLoadEnvironmentVariable(String name) {
            String value = System.getenv(name);
            if (value == null || value.length() == 0) {
                throw new IllegalStateException(String.format("The %s environment variable must be set", name));
            }

            return value;
        }
    }


}
