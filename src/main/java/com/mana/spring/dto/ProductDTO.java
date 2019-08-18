package com.mana.spring.dto;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.Image;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.domain.Metal;

import java.util.ArrayList;

public class ProductDTO {

    private long productId;

    private String productName;

    private String productDescription;

    private double productWeight;

    private String weightUnit;

    private double productPrice;

    private String productSku;

    private String productCurrency;

    private boolean productOnFeatured;

    private boolean productPublished;

    private boolean active;

    private JewelryType jewelryType;

    private ArrayList<Gemstone> gemstones;

    private ArrayList<Metal> metals;

    private ArrayList<Image> images;

    public ProductDTO() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
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

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
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

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductCurrency() {
        return productCurrency;
    }

    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }

    public boolean isProductOnFeatured() {
        return productOnFeatured;
    }

    public void setProductOnFeatured(boolean productOnFeatured) {
        this.productOnFeatured = productOnFeatured;
    }

    public boolean isProductPublished() {
        return productPublished;
    }

    public void setProductPublished(boolean productPublished) {
        this.productPublished = productPublished;
    }

    public JewelryType getJewelryType() {
        return jewelryType;
    }

    public void setJewelryType(JewelryType jewelryType) {
        this.jewelryType = jewelryType;
    }

    public ArrayList<Gemstone> getGemstones() {
        return gemstones;
    }

    public void setGemstones(ArrayList<Gemstone> gemstones) {
        this.gemstones = gemstones;
    }

    public ArrayList<Metal> getMetals() {
        return metals;
    }

    public void setMetals(ArrayList<Metal> metals) {
        this.metals = metals;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "\nProductDTO{" +
                "\nproductId=" + productId +
                "\nproductName='" + productName + '\'' +
                "\nproductDescription='" + productDescription + '\'' +
                "\nproductWeight=" + productWeight +
                "\nweightUnit='" + weightUnit + '\'' +
                "\nproductPrice=" + productPrice +
                "\nproductSku='" + productSku + '\'' +
                "\nproductCurrency='" + productCurrency + '\'' +
                "\nproductOnFeatured=" + productOnFeatured +
                "\nproductPublished=" + productPublished +
                "\nactive=" + active +
                "\njewelryType=" + jewelryType +
                "\ngemstones=" + gemstones +
                "\nmetals=" + metals +
                "\nimages=" + images +
                '}';
    }
}
