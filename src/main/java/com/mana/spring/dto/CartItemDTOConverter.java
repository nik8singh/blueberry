package com.mana.spring.dto;


import com.mana.spring.domain.CartItem;

public class CartItemDTOConverter {

    public static CartItemDTO convertToDTO(CartItem cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setCartItemId(cartItem.getCartItemId());
        cartItemDTO.setProductQuantity(cartItem.getProductQuantity());
        cartItemDTO.setProductDTO(ProductDTOConverter.convertToDTO(cartItem.getProduct()));

        return cartItemDTO;
    }
}
