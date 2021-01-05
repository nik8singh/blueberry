package com.mana.spring.dto;

import java.util.ArrayList;

public class CartItemListDTO {

    private ArrayList<CartItemDTO> cartItemDTOS;

    private double cartCost;

    public CartItemListDTO() {
    }

    public ArrayList<CartItemDTO> getCartItemDTOS() {
        return cartItemDTOS;
    }

    public void setCartItemDTOS(ArrayList<CartItemDTO> cartItemDTOS) {
        this.cartItemDTOS = cartItemDTOS;
        cartCost = 0;
        for (CartItemDTO cartItemDTO : cartItemDTOS)
            cartCost += cartItemDTO.getProductPrice() * cartItemDTO.getItemQuantity();
    }

    @Override
    public String toString() {
        return "CartItemListDTO{" +
                "\n\tcartItemDTOS=" + cartItemDTOS +
                "\n\tcartCost=" + cartCost +
                '}';
    }
}
