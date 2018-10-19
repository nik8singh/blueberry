package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_weight")
    private double productWeight;

    @Column(name = "weight_unit")
    private String weightUnit;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "price_currency")
    private String productCurrency;

    @Column(name = "product_sku")
    private String productSku;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "product_quantity_type")
    private String productQuantityType;

    @Column(name = "product_onfeatured")
    private boolean productOnFeatured;

    @Column(name = "product_published")
    private String productPublished;

    @Column(name = "product_expense")
    private String productExpense;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_jewelry_type")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "jewelryTypeId")
    private JewelryType productJewelryType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "gemstone_product",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "gemstone_id")}
    )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "gemstoneId")
    private Set<Gemstone> gemstones = new HashSet<Gemstone>(0);


    public Product() {
    }

    public Product(String productName, String productDescription, double productWeight, String weightUnit, double productPrice, String productCurrency, String productSku, int productQuantity, String productQuantityType, boolean productOnFeatured, String productPublished, String productExpense, Date createdDate, Date updatedDate) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productWeight = productWeight;
        this.weightUnit = weightUnit;
        this.productPrice = productPrice;
        this.productCurrency = productCurrency;
        this.productSku = productSku;
        this.productQuantity = productQuantity;
        this.productQuantityType = productQuantityType;
        this.productOnFeatured = productOnFeatured;
        this.productPublished = productPublished;
        this.productExpense = productExpense;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productweight) {
        this.productWeight = productweight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCurrency() {
        return productCurrency;
    }

    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductQuantityType() {
        return productQuantityType;
    }

    public void setProductQuantityType(String productQuantityType) {
        this.productQuantityType = productQuantityType;
    }

    public boolean isProductOnFeatured() {
        return productOnFeatured;
    }

    public void setProductOnFeatured(boolean productOnFeatured) {
        this.productOnFeatured = productOnFeatured;
    }

    public String getProductPublished() {
        return productPublished;
    }

    public void setProductPublished(String productPublished) {
        this.productPublished = productPublished;
    }

    public String getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(String productExpense) {
        this.productExpense = productExpense;
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

    public JewelryType getProductJewelryType() {
        return productJewelryType;
    }

    public void setProductJewelryType(JewelryType productJewelryType) {
        this.productJewelryType = productJewelryType;
    }

    public Set<Gemstone> getGemstones() {
        return gemstones;
    }

    public void setGemstones(Set<Gemstone> gemstones) {
        this.gemstones = gemstones;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productWeight=" + productWeight +
                ", weightUnit='" + weightUnit + '\'' +
                ", productPrice=" + productPrice +
                ", productCurrency='" + productCurrency + '\'' +
                ", productSku='" + productSku + '\'' +
                ", productQuantity=" + productQuantity +
                ", productQuantityType='" + productQuantityType + '\'' +
                ", productOnFeatured=" + productOnFeatured +
                ", productPublished='" + productPublished + '\'' +
                ", productExpense='" + productExpense + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", productJewelryType=" + productJewelryType +
                ", gemstones=" + gemstones +
                '}';
    }
}
