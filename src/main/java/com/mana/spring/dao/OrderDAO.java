package com.mana.spring.dao;

import com.mana.spring.domain.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderDAO {

    Order saveOrder(Order order);

    Order updateOrder(Order order);

    Order getByPaymentId(long paymentId);

    Order getByOrderId(long orderId);

    List getAllByUserEmail(String email, int start, int end);

    long count(String statusFilter);

    long countyMultipleStatus(ArrayList<String> filters);

    List getOrdersByStatus(String status, int start, int end);

    List getOrdersByMultipleStatus(ArrayList<String> filters, int start, int end);

    List listPartialSearch(String searchWord);

    void updatePrivateNote(String message, long orderId);

    void updatePublicNote(String message, long orderId);

    void updateTrackingNumber(String trackingNumber, long orderId);

}