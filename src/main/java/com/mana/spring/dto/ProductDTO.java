package com.mana.spring.dto;

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

    private int productQuantity;

    private String productQuantityType;

    private boolean productOnFeatured;

    private boolean productPublished;

    private double productExpense;

    private long jewelryTypeId;

    private String jewelryTypeName;

    private String jewelryTypeDescription;

    private boolean productAcceptCoupon;

    private ArrayList<GemstoneDTO> gemstones;

    private ArrayList<MetalDTO> metals;

    private ArrayList<ImageDTO> images;

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

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public boolean isProductAcceptCoupon() {
        return productAcceptCoupon;
    }

    public void setProductAcceptCoupon(boolean productAcceptCoupon) {
        this.productAcceptCoupon = productAcceptCoupon;
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

    public ArrayList<GemstoneDTO> getGemstones() {
        return gemstones;
    }

    public void setGemstones(ArrayList<GemstoneDTO> gemstones) {
        this.gemstones = gemstones;
    }

    public ArrayList<MetalDTO> getMetals() {
        return metals;
    }

    public void setMetals(ArrayList<MetalDTO> metals) {
        this.metals = metals;
    }

    public ArrayList<ImageDTO> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageDTO> images) {
        this.images = images;
    }

    public boolean isProductPublished() {
        return productPublished;
    }

    public void setProductPublished(boolean productPublished) {
        this.productPublished = productPublished;
    }

    public long getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(long jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
    }

    @Override
    public String toString() {
        return "\n\tProductDTO{" +
                "\n\tproductId=" + productId +
                "\n\tproductName='" + productName + '\'' +
                "\n\tproductDescription='" + productDescription + '\'' +
                "\n\tproductWeight=" + productWeight +
                "\n\tweightUnit='" + weightUnit + '\'' +
                "\n\tproductPrice=" + productPrice +
                "\n\tproductSku='" + productSku + '\'' +
                "\n\tproductCurrency='" + productCurrency + '\'' +
                "\n\tproductQuantity=" + productQuantity +
                "\n\tproductQuantityType='" + productQuantityType + '\'' +
                "\n\tproductOnFeatured=" + productOnFeatured +
                "\n\tproductPublished='" + productPublished + '\'' +
                "\n\tproductExpense='" + productExpense + '\'' +
                "\n\tproductAcceptCoupon=" + productAcceptCoupon +
                "\n\tjewelryTypeName='" + jewelryTypeName + '\'' +
                "\n\tjewelryTypeDescription='" + jewelryTypeDescription + '\'' +
                "\n\tgemstones=" + gemstones +
                "\n\tmetals=" + metals +
                "\n\timages=" + images +
                "\n\t}";
    }
}
