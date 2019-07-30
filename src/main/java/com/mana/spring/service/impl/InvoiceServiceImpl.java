package com.mana.spring.service.impl;

import com.mana.spring.dao.InvoiceDAO;
import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.Purchase;
import com.mana.spring.dto.InvoiceListDTO;
import com.mana.spring.service.CartItemService;
import com.mana.spring.service.CouponService;
import com.mana.spring.service.InvoiceService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CouponService couponService;


    public InvoiceListDTO getCompletedInvoices(int pageNumber) {
        return createListDTO(pageNumber, true, false, false, null);
    }

    public InvoiceListDTO getRefundedInvoices(int pageNumber) {
        return createListDTO(pageNumber, false, false, true, null);
    }

    public InvoiceListDTO getRefundRequestedInvoices(int pageNumber) {
        return createListDTO(pageNumber, false, true, false, null);
    }

    public InvoiceListDTO getPendingInvoices(int pageNumber) {
        return createListDTO(pageNumber, false, false, false, null);
    }

    public InvoiceListDTO getInvoices(String email, int pageNumber) {
        return createListDTO(pageNumber, false, false, false, email);
    }

    public Invoice getInvoice(long InvoiceNumber) {
        return invoiceDAO.getByInvoiceNumber(InvoiceNumber);
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceDAO.saveInvoice(createTempInvoice(invoice));
    }

    public Invoice confirmOrder(Invoice invoice) {
        return createTempInvoice(invoice);
    }

    public void completeInvoice(Invoice invoice) {

        Invoice invoiceDb = invoiceDAO.getById(invoice);
        invoiceDb.setCompleted(true);
        invoiceDb.setTrackingNumber(invoice.getTrackingNumber());

        invoiceDAO.updateInvoice(invoiceDb);
    }

    public Invoice makePayment(Invoice invoice) {

        // make payment using third party API

        Invoice invoiceDb = invoiceDAO.getById(invoice);
        invoiceDb.setPaymentMade(true);
        invoiceDb.setSquareInvoiceId(invoice.getSquareInvoiceId());

        return invoiceDAO.updateInvoice(invoiceDb);

    }

    public void refundInvoice(Invoice invoice) {
        Invoice invoiceDb = invoiceDAO.getById(invoice);
        invoiceDb.setRefunded(true);
        invoiceDb.setSquareInvoiceId(invoice.getSquareInvoiceId());

        invoiceDAO.updateInvoice(invoiceDb);
    }

    public void requestRefund(Invoice invoice) {
        Invoice invoiceDb = invoiceDAO.getById(invoice);
        invoiceDb.setRefundRequested(true);

        invoiceDAO.updateInvoice(invoiceDb);
    }

    private InvoiceListDTO createListDTO(int pageNumber, boolean complete, boolean refundRequested, boolean refunded, String email) {
        long count;
        if (email != null)
            count = invoiceDAO.count(email);
        else
            count = invoiceDAO.count(complete, refundRequested, refunded);

        InvoiceListDTO invoiceListDTO = new InvoiceListDTO();
        invoiceListDTO.setCount(count);
        invoiceListDTO.setCurrentPageNumber(pageNumber);
        invoiceListDTO.calculateAndSetTotalPages();
        int size = Pagination.getPageSize();

        if (email != null)
            invoiceListDTO.setInvoices((ArrayList<Invoice>) invoiceDAO.getByEmail(email, (pageNumber - 1) * size, size));
        else
            invoiceListDTO.setInvoices((ArrayList<Invoice>) invoiceDAO.getInvoices(complete, refundRequested, refunded, (pageNumber - 1) * size, size));

        return invoiceListDTO;
    }


    private Invoice createTempInvoice(Invoice invoice) {
        double totalAmount = 0;
        Set<Purchase> purchases = new HashSet<Purchase>();
        ArrayList<CartItem> cartItems = cartItemService.getUserCart(invoice.getUser().getUserEmail());

        for (CartItem item : cartItems) {
            Purchase purchase = new Purchase();
            purchase.setProduct(item.getProduct());
            purchase.setProductQuantity(item.getProductQuantity());
            totalAmount += (item.getProduct().getProductPrice() * item.getProductQuantity());
            purchase.setProductAmount(item.getProduct().getProductPrice());
            purchase.setInvoice(invoice);
            purchases.add(purchase);
        }
        invoice.setPurchases(purchases);

        // add tax?
        // add shipping amount ?

        //  coupon amount ?
        double couponPercent = couponService.getCoupon(invoice.getCouponName()).getCouponDiscountPercent();
        double couponAmount = couponPercent / 100;
        couponAmount *= totalAmount;
        totalAmount -= couponAmount;

        invoice.setInvoiceAmount(totalAmount);
        invoice.setCouponAmount(couponAmount);
        invoice.setCouponPercent(couponPercent);

        return invoice;
    }

}
