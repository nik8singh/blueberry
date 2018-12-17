package com.mana.spring.service;

import com.mana.spring.dto.CartItemDTO;

import java.util.ArrayList;

public interface CartItemService {

    void addToCart(CartItemDTO cartItemDTO);

    void removeFromCart(CartItemDTO cartItemDTO);

    void updateCartItem(CartItemDTO cartItemDTO);

    ArrayList<CartItemDTO> getUserCart(String email);
}
