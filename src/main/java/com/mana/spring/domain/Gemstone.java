package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gemstone")
public class Gemstone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gemstone_id")
    private long gemstoneId;

    @Column(name = "gemstone_name", nullable = false)
    private String gemstoneName;

    @Column(name = "gemstone_description")
    private String gemstoneDescription;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "gemstone_product",
            joinColumns = {@JoinColumn(name = "gemstone_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "productId")
    private Set<Product> products = new HashSet<Product>(0);


    public Gemstone() {
    }

    public Gemstone(String gemstoneName, String gemstoneDescription) {
        this.gemstoneName = gemstoneName;
        this.gemstoneDescription = gemstoneDescription;

    }

    public Gemstone(String gemstoneName, String gemstoneDescription, Date createdDate, Date updatedDate) {
        this.gemstoneName = gemstoneName;
        this.gemstoneDescription = gemstoneDescription;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public long getGemstoneId() {
        return gemstoneId;
    }

    public String getGemstoneName() {
        return gemstoneName;
    }

    public String getGemstoneDescription() {
        return gemstoneDescription;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setGemstoneId(long gemstoneId) {
        this.gemstoneId = gemstoneId;
    }

    public void setGemstoneName(String gemstoneName) {
        this.gemstoneName = gemstoneName;
    }

    public void setGemstoneDescription(String gemstoneDescription) {
        this.gemstoneDescription = gemstoneDescription;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Gemstone{" +
                "gemstoneId=" + gemstoneId +
                ", gemstoneName='" + gemstoneName + '\'' +
                ", gemstoneDescription='" + gemstoneDescription + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", products=" + products +
                '}';
    }
}
