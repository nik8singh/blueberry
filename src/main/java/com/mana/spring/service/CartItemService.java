package com.mana.spring.service;

import com.mana.spring.domain.CartItem;

import java.util.ArrayList;

public interface CartItemService {

    void addToCart(CartItem cartItem);

    void removeFromCart(CartItem cartItem);

    void updateCartItem(CartItem cartItem);

    ArrayList<CartItem> getUserCart(String email);
}
