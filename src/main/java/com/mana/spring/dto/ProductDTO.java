package com.mana.spring.dto;

import java.util.ArrayList;

public class ProductDTO {

    private Long productId;

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

    private String productPublished;

    private String productExpense;

    private String jewelryTypeName;

    private String jewelryTypeDescription;

    private boolean productAcceptCoupon;

    private ArrayList<GemstoneDTO> gemstones;

    private ArrayList<MetalDTO> metals;

    private ArrayList<ImageDTO> images;

    public ProductDTO() {
    }

    public ProductDTO(Long productId, String productName, String productDescription, double productWeight, String weightUnit, double productPrice, String productSku, String productCurrency, int productQuantity, String productQuantityType, boolean productOnFeatured, String productPublished, String productExpense, String jewelryTypeName, String jewelryTypeDescription, boolean productAcceptCoupon, ArrayList<GemstoneDTO> gemstones, ArrayList<MetalDTO> metals, ArrayList<ImageDTO> images) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productWeight = productWeight;
        this.weightUnit = weightUnit;
        this.productPrice = productPrice;
        this.productSku = productSku;
        this.productCurrency = productCurrency;
        this.productQuantity = productQuantity;
        this.productQuantityType = productQuantityType;
        this.productOnFeatured = productOnFeatured;
        this.productPublished = productPublished;
        this.productExpense = productExpense;
        this.jewelryTypeName = jewelryTypeName;
        this.jewelryTypeDescription = jewelryTypeDescription;
        this.productAcceptCoupon = productAcceptCoupon;
        this.gemstones = gemstones;
        this.metals = metals;
        this.images = images;
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
