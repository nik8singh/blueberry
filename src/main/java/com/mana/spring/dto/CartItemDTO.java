package com.mana.spring.dto;

public class CartItemDTO {

    private long cartItemId;

    private int productQuantity;

    private UserDTO userDTO;

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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
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
                "\n user=" + userDTO +
                "\n product=" + productDTO +
                '}';
    }
}
