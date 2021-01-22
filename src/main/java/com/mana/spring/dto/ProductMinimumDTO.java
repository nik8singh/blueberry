package com.mana.spring.dto;

public class ProductMinimumDTO {
    private long productId;
    private long jewelryTypeId;
    private String productName;
    private String image_secure_url;
    private double productPrice;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(long jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage_secure_url() {
        return image_secure_url;
    }

    public void setImage_secure_url(String image_secure_url) {
        this.image_secure_url = image_secure_url;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "\n\nProductMinimumDTO{" +
                "\nproductId=" + productId +
                "\njewelryTypeId=" + jewelryTypeId +
                "\nproductPrice='" + productPrice + '\'' +
                "\nproductName='" + productName + '\'' +
                "\nimage_secure_url='" + image_secure_url + '\'' +
                '}';
    }
}
