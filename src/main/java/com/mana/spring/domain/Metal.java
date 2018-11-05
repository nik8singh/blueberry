package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "metal")
public class Metal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "metal_id")
    private long metalId;

    @Column(name = "metal_name", nullable = false)
    private String metalName;

    @Column(name = "metal_description")
    private String metalDescription;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "metal_product",
            joinColumns = {@JoinColumn(name = "metal_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "productId")
    private Set<Product> products = new HashSet<Product>(0);

    public Metal() {
    }

    public Metal(String metalName, String metalDescription, Date createdDate, Date updatedDate, Set<Product> products) {
        this.metalName = metalName;
        this.metalDescription = metalDescription;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.products = products;
    }

    public long getMetalId() {
        return metalId;
    }

    public void setMetalId(long metalId) {
        this.metalId = metalId;
    }

    public String getMetalName() {
        return metalName;
    }

    public void setMetalName(String metalName) {
        this.metalName = metalName;
    }

    public String getMetalDescription() {
        return metalDescription;
    }

    public void setMetalDescription(String metalDescription) {
        this.metalDescription = metalDescription;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "\nmetal{" +
                "\n\tmetalId= " + metalId +
                "\n\tmetalName= '" + metalName + '\'' +
                "\n\tmetalDescription= '" + metalDescription + '\'' +
                "\n\tcreatedDate= " + createdDate +
                "\n\tupdatedDate= " + updatedDate +
                '}';
    }
}
