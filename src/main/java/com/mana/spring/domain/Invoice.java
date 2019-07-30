package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private long invoiceId;

    @Column(name = "square_invoice_id")
    private long squareInvoiceId;

    @Column(name = "tax_percent")
    private double taxPercent;

    @Column(name = "tax_amount")
    private double taxAmount;

    @Column(name = "coupon_name")
    private String couponName;

    @Column(name = "coupon_percent")
    @JsonIgnore
    private double couponPercent;

    @Column(name = "coupon_amount")
    private double couponAmount;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "shipping_amount")
    private double shippingAmount;

    @Column(name = "invoice_amount")
    private double invoiceAmount;

    @Column(name = "tracking_number")
    private long trackingNumber;

    @Column(name = "message")
    private String message;

    @Column(name = "refunded")
    private boolean refunded;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "refund_requested")
    private boolean refundRequested;

    @Column(name = "payment_made")
    private boolean paymentMade;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice", fetch = FetchType.LAZY)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "purchaseId")
    private Set<Purchase> purchases = new HashSet<Purchase>(0);

    public Invoice() {
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public long getSquareInvoiceId() {
        return squareInvoiceId;
    }

    public void setSquareInvoiceId(long squareInvoiceId) {
        this.squareInvoiceId = squareInvoiceId;
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

    public double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public double getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(double shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public long getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(long trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isRefundRequested() {
        return refundRequested;
    }

    public void setRefundRequested(boolean refundRequested) {
        this.refundRequested = refundRequested;
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

    public double getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(double couponPercent) {
        this.couponPercent = couponPercent;
    }

    public boolean isPaymentMade() {
        return paymentMade;
    }

    public void setPaymentMade(boolean paymentMade) {
        this.paymentMade = paymentMade;
    }

    @Override
    public String toString() {
        return "\nInvoice{" +
                "\ninvoiceId=" + invoiceId +
                "\nsquareInvoiceId=" + squareInvoiceId +
                "\ntaxPercent=" + taxPercent +
                "\ntaxAmount=" + taxAmount +
                "\ncouponName='" + couponName + '\'' +
                "\ncouponPercent=" + couponPercent +
                "\ncouponAmount=" + couponAmount +
                "\nshippingAddress='" + shippingAddress + '\'' +
                "\nshippingAmount=" + shippingAmount +
                "\ninvoiceAmount=" + invoiceAmount +
                "\ntrackingNumber=" + trackingNumber +
                "\nmessage='" + message + '\'' +
                "\nrefunded=" + refunded +
                "\ncompleted=" + completed +
                "\nrefundRequested=" + refundRequested +
                "\ncreatedDate=" + createdDate +
                "\nupdatedDate=" + updatedDate +
                "\nuser=" + user +
                "\npurchases=" + purchases +
                "\npaymentMade=" + paymentMade +
                '}';
    }
}
