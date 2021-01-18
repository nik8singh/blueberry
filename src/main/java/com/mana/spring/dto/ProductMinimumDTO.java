package com.mana.spring.dto;

public class ProductMinimumDTO {
    private long productId;
    private long jewelryTypeId;
    private String productName;
    private String image_public_id;

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

    public String getImage_public_id() {
        return image_public_id;
    }

    public void setImage_public_id(String image_public_id) {
        this.image_public_id = image_public_id;
    }

    @Override
    public String toString() {
        return "\n\nProductMinimumDTO{" +
                "\nproductId=" + productId +
                "\njewelryTypeId=" + jewelryTypeId +
                "\nproductName='" + productName + '\'' +
                "\nimage_public_id='" + image_public_id + '\'' +
                '}';
    }
}
