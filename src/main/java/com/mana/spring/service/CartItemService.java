package com.mana.spring.service;

import com.mana.spring.dto.CartItemDTO;
import com.mana.spring.dto.CartItemListDTO;

public interface CartItemService {

    void addToCart(CartItemDTO cartItemDTO);

    void removeFromCart(CartItemDTO cartItemDTO);

    void emptyUserCart(long userId);

    void updateCartItem(CartItemDTO cartItemDTO);

    CartItemListDTO getUserCart(long userId);

    void addListToCart(CartItemListDTO cartItemListDTO);
}
