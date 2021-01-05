package com.mana.spring.dto;


import com.mana.spring.domain.Order;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class OrderListDTO extends Pagination {

    private ArrayList<OrderDTO> orderDTOS;

    private String statusFilter;

    private long totalNew;

    private long totalPendingShipment;

    private long totalReturnRequested;

    public OrderListDTO() {
        orderDTOS = new ArrayList<>();
    }

    public ArrayList<OrderDTO> getOrderDTOS() {
        return orderDTOS;
    }

    public void setOrderDTOS(ArrayList<OrderDTO> orderDTOS) {
        this.orderDTOS = orderDTOS;
    }

    public void convertAndSetOrderDTOS(ArrayList<Order> orders) {
        for (Order order : orders) {
            this.orderDTOS.add(OrderDTOConverter.convertToDTO(order));
        }
    }

    public String getStatusFilter() {
        return statusFilter;
    }

    public void setStatusFilter(String statusFilter) {
        this.statusFilter = statusFilter;
    }

    public long getTotalNew() {
        return totalNew;
    }

    public void setTotalNew(long totalNew) {
        this.totalNew = totalNew;
    }

    public long getTotalPendingShipment() {
        return totalPendingShipment;
    }

    public void setTotalPendingShipment(long totalPendingShipment) {
        this.totalPendingShipment = totalPendingShipment;
    }

    public long getTotalReturnRequested() {
        return totalReturnRequested;
    }

    public void setTotalReturnRequested(long totalReturnRequested) {
        this.totalReturnRequested = totalReturnRequested;
    }
}