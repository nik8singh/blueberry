package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "jewelry_type")
public class JewelryType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "jewelry_type_id")
    private long jewelryTypeId;

    @Column(name = "jewelry_type_name", nullable = false)
    private String jewelryTypeName;

    @Column(name = "jewelry_type_description")
    private String jewelryTypeDescription;

    @Column(name = "active", nullable = false)
    private boolean jewelryTypeActive;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productJewelryType", fetch = FetchType.EAGER)//, orphanRemoval = true)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "productId")
    private Set<Product> products = new HashSet<Product>(0);

    public JewelryType() {
    }

    public JewelryType(String jewelryTypeName, String jewelryTypeDescription, boolean jewelryTypeActive, Date createdDate, Date updatedDate, Set<Product> products) {
        this.jewelryTypeName = jewelryTypeName;
        this.jewelryTypeDescription = jewelryTypeDescription;
        this.jewelryTypeActive = jewelryTypeActive;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.products = products;
    }

    public long getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(long jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
    }

    public String getJewelryTypeName() {
        return jewelryTypeName;
    }

    public void setJewelryTypeName(String jewelryTypeName) {
        this.jewelryTypeName = jewelryTypeName;
    }

    public String getJewelryTypeDescription() {
        return jewelryTypeDescription;
    }

    public void setJewelryTypeDescription(String jewelryTypeDescription) {
        this.jewelryTypeDescription = jewelryTypeDescription;
    }

    public boolean isJewelryTypeActive() {
        return jewelryTypeActive;
    }

    public void setJewelryTypeActive(boolean jewelryTypeActive) {
        this.jewelryTypeActive = jewelryTypeActive;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> product) {
        this.products = product;
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

    @Override
    public String toString() {
        return "\nJewelryType{" +
                "\n\tjewelryTypeId= " + jewelryTypeId +
                "\n\tjewelryTypeName= '" + jewelryTypeName + '\'' +
                "\n\tjewelryTypeDescription= '" + jewelryTypeDescription + '\'' +
                "\n\tjewelryTypeActive= " + jewelryTypeActive +
                "\n\tcreatedDate= " + createdDate +
                "\n\tupdatedDate= " + updatedDate +
//                "\n\tproduct=" + product +
                '}';
    }
}
