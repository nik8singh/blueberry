package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jewelry_type")
public class JewelryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jewelry_type_id")
    private long jewelryTypeId;

    @Column(name = "jewelry_type_name", nullable = false)
    @NotBlank(message = "Please provide a name")
    private String jewelryTypeName;

    @Column(name = "jewelry_type_description")
    private String jewelryTypeDescription;

    @Column(name = "active", nullable = false)
    private boolean jewelryTypeActive;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productJewelryType", fetch = FetchType.LAZY)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "productId")
    @JsonIgnore
    private Set<Product> products = new HashSet<Product>(0);

    public JewelryType() {
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
