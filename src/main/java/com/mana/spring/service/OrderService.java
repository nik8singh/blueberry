package com.mana.spring.service;

import com.mana.spring.domain.NonceForm;
import com.mana.spring.domain.Order;
import com.mana.spring.dto.OrderDTO;
import com.mana.spring.dto.OrderListDTO;

public interface OrderService {

    Order calculateOrder(Order order, long userId);

    Order addCoupon(String couponName, long orderId);

    Order processNewOrder(long orderId, NonceForm nonceForm);

    Order generateShippingLabelAndInvoice(long orderId);

    void orderShipped(Order order);

    void orderReturnRequested(Order order);

    void orderCancelRequested(Order order);

    OrderListDTO getListByStatus(String statusFilter, int pageNumber);

    OrderDTO getOrderById(long id);

    OrderListDTO listPartialSearch(String searchWord);

    void updatePrivateNote(String message, long orderId);

    void updatePublicNote(String message, long orderId);

    void updateTrackingNumber(String trackingNumber, long orderId);

    Order updateOrder(Order order);

}