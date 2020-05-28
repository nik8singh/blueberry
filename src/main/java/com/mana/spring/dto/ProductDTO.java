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

    private double productExpense;

    private boolean productAcceptCoupon;

    private boolean productOnFeatured;

    private boolean productPublished;

    private boolean active;

    private JewelryTypeDTO jewelryType;

    private ArrayList<GemstoneDTO> gemstones;

    private ArrayList<MetalDTO> metals;

    private ArrayList<ImageDTO> images;
    private ImageListDTO imageListDTO;

    public ProductDTO() {
    }

    public ImageListDTO getImageListDTO() {
        return imageListDTO;
    }

    public void setImageListDTO(ImageListDTO imageListDTO) {
        this.imageListDTO = imageListDTO;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public JewelryTypeDTO getJewelryType() {
        return jewelryType;
    }

    public void setJewelryType(JewelryTypeDTO jewelryType) {
        this.jewelryType = jewelryType;
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
                "\njewelryTypeDTO=" + jewelryType +
                "\ngemstonesDtos=" + gemstones +
                "\nmetalsDtos=" + metals +
                "\nimagesDtos=" + images +
                '}';
    }
}
