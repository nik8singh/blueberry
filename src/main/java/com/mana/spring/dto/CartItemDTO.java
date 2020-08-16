package com.mana.spring.dto;

public class CartItemDTO {

    private long cartItemId;

    private int productQuantity;

    private ProductDTO productDTO;

    public CartItemDTO() {
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "\nCartItem{" +
                "\ncartItemId=" + cartItemId +
                "\n productQuantity='" + productQuantity + '\'' +
                "\n product=" + productDTO +
                '}';
    }
}
