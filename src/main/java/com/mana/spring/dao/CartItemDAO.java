package com.mana.spring.dao;

import com.mana.spring.domain.CartItem;

import java.util.List;

public interface CartItemDAO {

    void save(CartItem cartItem);

    void delete(CartItem cartItem);

    void deleteUserCart(long userId);

    void update(CartItem cartItem);

    List listUserCartItems(long userId);

    CartItem cartItemByProductAndUser(long userId, long productId);

}
