package com.mana.spring.dto;

import com.mana.spring.domain.Order;
import com.mana.spring.domain.Purchase;

import java.util.HashSet;
import java.util.Set;

public class OrderDTOConverter {

    public static OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setTaxPercent(order.getTaxPercent());
        orderDTO.setTaxAmount(order.getTaxAmount());
        orderDTO.setCouponName(order.getCouponName());
        orderDTO.setCouponPercent(order.getCouponPercent());
        orderDTO.setCouponAmount(order.getCouponAmount());
        orderDTO.setShippingAddressName(order.getShippingAddressName());
        orderDTO.setShippingAddressLine(order.getShippingAddressLine());
        orderDTO.setShippingAddressCity(order.getShippingAddressCity());
        orderDTO.setShippingAddressState(order.getShippingAddressState());
        orderDTO.setShippingAddressZipCode(order.getShippingAddressZipCode());
        orderDTO.setShippingAddressCountry(order.getShippingAddressCountry());
        orderDTO.setNoteForCustomer(order.getNoteForCustomer());
        orderDTO.setPrivateNote(order.getPrivateNote());
        orderDTO.setInvoice(order.getInvoice());
        orderDTO.setShippingType(order.getShippingType());
        orderDTO.setShippingAmount(order.getShippingAmount());
        orderDTO.setSubTotal(order.getSubTotal());
        orderDTO.setFinalTotal(order.getFinalTotal());
        orderDTO.setTrackingNumber(order.getTrackingNumber());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setPaymentStatus(order.isPaymentStatus());
        orderDTO.setConfirmationNumber(order.getConfirmationNumber());
        orderDTO.setPaymentId(order.getPaymentId());
        orderDTO.setOrderPlacedDate(order.getOrderPlacedDate());
        orderDTO.setMessage(order.getMessage());

        Set<Purchase> purchases = order.getPurchases();
        Set<PurchaseDTO> purchaseDTOS = new HashSet<>();
        for (Purchase purchase : purchases)
            purchaseDTOS.add(PurchaseDTOConverter.convertToDTO(purchase));
        orderDTO.setPurchaseDTOS(purchaseDTOS);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserFirstName(order.getUser().getUserFirstName());
        userDTO.setUserLastName(order.getUser().getUserLastName());
        userDTO.setUserEmail(order.getUser().getUserEmail());

        orderDTO.setUserDTO(userDTO);

        return orderDTO;
    }


}
