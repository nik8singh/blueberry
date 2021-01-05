package com.mana.spring.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_order_id")
    private long orderId;

    @Column(name = "payment_vendor")
    private String paymentVendor;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "tax_percent")
    private double taxPercent;

    @Column(name = "tax_amount")
    private double taxAmount;

    @Column(name = "coupon_name")
    private String couponName;

    @Column(name = "coupon_percent")
    private double couponPercent;

    @Column(name = "coupon_amount")
    private double couponAmount;

    @Column(name = "shipping_name")
    private String shippingAddressName;

    @Column(name = "shipping_address_line")
    private String shippingAddressLine;

    @Column(name = "shipping_address_city")
    private String shippingAddressCity;

    @Column(name = "shipping_address_State")
    private String shippingAddressState;

    @Column(name = "shipping_address_zipcode")
    private String shippingAddressZipCode;

    @Column(name = "shipping_address_Country")
    private String shippingAddressCountry;

    @Column(name = "shipping_type")
    private String shippingType;

    @Column(name = "shipping_amount")
    private double shippingAmount;

    @Column(name = "sub_total")
    private double subTotal;

    @Column(name = "final_total")
    private double finalTotal;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "message")
    private String message;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "payment_status")
    private boolean paymentStatus;

    @Column(name = "priority")
    private int priority;

    @Column(name = "confirmation_number")
    private String confirmationNumber;

    @Column(name = "customer_note")
    private String noteForCustomer;

    @Column(name = "private_note")
    private String privateNote;

    @Column(name = "invoice")
    private String invoice;

    @Column(name = "order_placed_Date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date orderPlacedDate;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "userId")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "purchaseId")
    private Set<Purchase> purchases = new HashSet<Purchase>(0);

    public Order() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentVendor() {
        return paymentVendor;
    }

    public void setPaymentVendor(String paymentVendor) {
        this.paymentVendor = paymentVendor;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Date getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public void setOrderPlacedDate(Date orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
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

    public String getShippingAddressCity() {
        return shippingAddressCity;
    }

    public void setShippingAddressCity(String shippingAddressCity) {
        this.shippingAddressCity = shippingAddressCity;
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
        return "Order{" +
                "\norderId=" + orderId +
                "\n paymentVendor='" + paymentVendor + '\'' +
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
                "\n shippingType='" + shippingType + '\'' +
                "\n shippingAmount=" + shippingAmount +
                "\n subTotal=" + subTotal +
                "\n finalTotal=" + finalTotal +
                "\n trackingNumber=" + trackingNumber +
                "\n message='" + message + '\'' +
                "\n orderStatus='" + orderStatus + '\'' +
                "\n paymentStatus=" + paymentStatus +
                "\n priority=" + priority +
                "\n confirmationNumber=" + confirmationNumber +
                "\n createdDate=" + createdDate +
                "\n updatedDate=" + updatedDate +
                "\n orderPlacedDate=" + orderPlacedDate +
                "\n noteForCustomer=" + noteForCustomer +
                "\n privateNote=" + privateNote +
                "\n purchases=" + purchases +
                '}';
    }
}
