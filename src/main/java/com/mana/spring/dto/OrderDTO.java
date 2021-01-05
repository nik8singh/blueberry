package com.mana.spring.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO {

    private long orderId;

    private String paymentId;

    private double taxPercent;

    private double taxAmount;

    private String couponName;

    private double couponPercent;

    private double couponAmount;

    private String shippingAddressName;

    private String shippingAddressLine;

    private String shippingAddressCity;

    private String shippingAddressState;

    private String shippingAddressZipCode;

    private String shippingAddressCountry;

    private String noteForCustomer;

    private String privateNote;

    private String shippingType;

    private String invoice;

    private double shippingAmount;

    private double subTotal;

    private double finalTotal;

    private String trackingNumber;

    private String message;

    private String orderStatus;

    private boolean paymentStatus;

    private String confirmationNumber;

    private Date orderPlacedDate;

    private UserDTO userDTO;

    private Set<PurchaseDTO> purchaseDTOS = new HashSet<>(0);

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public double getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(double couponPercent) {
        this.couponPercent = couponPercent;
    }

    public double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public double getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(double shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public void setOrderPlacedDate(Date orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Set<PurchaseDTO> getPurchaseDTOS() {
        return purchaseDTOS;
    }

    public void setPurchaseDTOS(Set<PurchaseDTO> purchaseDTOS) {
        this.purchaseDTOS = purchaseDTOS;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getShippingAddressName() {
        return shippingAddressName;
    }

    public void setShippingAddressName(String shippingAddressName) {
        this.shippingAddressName = shippingAddressName;
    }

    public String getShippingAddressLine() {
        return shippingAddressLine;
    }

    public void setShippingAddressLine(String shippingAddressLine) {
        this.shippingAddressLine = shippingAddressLine;
    }

    public String getShippingAddressCity() {
        return shippingAddressCity;
    }

    public void setShippingAddressCity(String shippingAddressCity) {
        this.shippingAddressCity = shippingAddressCity;
    }

    public String getShippingAddressState() {
        return shippingAddressState;
    }

    public void setShippingAddressState(String shippingAddressState) {
        this.shippingAddressState = shippingAddressState;
    }

    public String getShippingAddressZipCode() {
        return shippingAddressZipCode;
    }

    public void setShippingAddressZipCode(String shippingAddressZipCode) {
        this.shippingAddressZipCode = shippingAddressZipCode;
    }

    public String getShippingAddressCountry() {
        return shippingAddressCountry;
    }

    public void setShippingAddressCountry(String shippingAddressCountry) {
        this.shippingAddressCountry = shippingAddressCountry;
    }

    public String getNoteForCustomer() {
        return noteForCustomer;
    }

    public void setNoteForCustomer(String noteForCustomer) {
        this.noteForCustomer = noteForCustomer;
    }

    public String getPrivateNote() {
        return privateNote;
    }

    public void setPrivateNote(String privateNote) {
        this.privateNote = privateNote;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "\norderId=" + orderId +
                "\n paymentId=" + paymentId +
                "\n taxPercent=" + taxPercent +
                "\n taxAmount=" + taxAmount +
                "\n couponName='" + couponName + '\'' +
                "\n couponPercent=" + couponPercent +
                "\n couponAmount=" + couponAmount +
                "\n shippingAddressName='" + shippingAddressName + '\'' +
                "\n shippingAddressLine='" + shippingAddressLine + '\'' +
                "\n shippingAddressCity='" + shippingAddressCity + '\'' +
                "\n shippingAddressState='" + shippingAddressState + '\'' +
                "\n shippingAddressZipCode='" + shippingAddressZipCode + '\'' +
                "\n shippingAddressCountry='" + shippingAddressCountry + '\'' +
                "\n noteForCustomer='" + noteForCustomer + '\'' +
                "\n privateNote='" + privateNote + '\'' +
                "\n shippingType='" + shippingType + '\'' +
                "\n shippingAmount=" + shippingAmount +
                "\n subTotal=" + subTotal +
                "\n finalTotal=" + finalTotal +
                "\n trackingNumber=" + trackingNumber +
                "\n message='" + message + '\'' +
                "\n orderStatus='" + orderStatus + '\'' +
                "\n paymentStatus=" + paymentStatus +
                "\n confirmationNumber='" + confirmationNumber + '\'' +
                "\n orderPlacedDate=" + orderPlacedDate +
                "\n userDTO=" + userDTO +
                "\n purchaseDTOS=" + purchaseDTOS +
                '}';
    }
}
