package com.mana.spring.dao;

import com.mana.spring.domain.CartItem;

import java.util.List;

public interface CartItemDAO {

    void save(CartItem cartItem);

    void delete(CartItem cartItem);

    void update(CartItem cartItem);

    List listUserCartItems(String email);

    CartItem cartItemByProductAndUser(CartItem cartItem);

}
