package com.mana.spring.dto;

public class CartItemDTO {

    private long cartItemId;

    private int itemQuantity;

    private long productId;

    private String productName;

    private double productPrice;

    private String productSku;

    private String productCurrency;

    private String image_secure_url;

    private long userId;

    public CartItemDTO() {
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
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

    public String getImage_secure_url() {
        return image_secure_url;
    }

    public void setImage_secure_url(String image_secure_url) {
        this.image_secure_url = image_secure_url;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "cartItemId=" + cartItemId +
                ", itemQuantity=" + itemQuantity +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productSku='" + productSku + '\'' +
                ", productCurrency='" + productCurrency + '\'' +
                ", image_secure_url=" + image_secure_url +
                ", userId=" + userId +
                '}';
    }
}
