package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

    @Column(name = "tax_percent")
    private double taxPercent;

    @Column(name = "tax_amount")
    private double taxAmount;

    @Column(name = "invoice_amount")
    private double invoiceAmount;

    @Column(name = "created_date", columnDefinition = "TIMESTAMP", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date", columnDefinition = "TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address")
    private Address shippingAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "userId")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice", fetch = FetchType.EAGER)
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

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
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

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
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

    @Override
    public String toString() {
        return "\nInvoice{" +
                "\ninvoiceId=" + invoiceId +
                "\n taxPercent=" + taxPercent +
                "\n taxAmount=" + taxAmount +
                "\n invoiceAmount=" + invoiceAmount +
                "\n createdDate=" + createdDate +
                "\n updatedDate=" + updatedDate +
                "\n shippingAddress=" + shippingAddress +
                "\n user=" + user +
                "\n purchases=" + purchases +
                '}';
    }
}
