package com.mana.spring.service.impl;

import com.mana.spring.dao.CartItemDAO;
import com.mana.spring.domain.CartItem;
import com.mana.spring.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDAO cartItemDAO;

    public void addToCart(CartItem cartItem) {
        cartItemDAO.save(cartItem);
    }

    public void removeFromCart(CartItem cartItem) {
        cartItemDAO.delete(cartItem);
    }

    public void updateCartItem(CartItem cartItem) {
        CartItem cartItemFromDb = cartItemDAO.cartItemByProductAndUser(cartItem);
        cartItemFromDb.setProductQuantity(cartItem.getProductQuantity());
        cartItemFromDb.setCreatedDate(null);
        cartItemFromDb.setUpdatedDate(null);
        cartItemDAO.update(cartItemFromDb);
    }

    public ArrayList<CartItem> getUserCart(String email) {
        ArrayList<CartItem> cartItems = (ArrayList<CartItem>) cartItemDAO.listUserCartItems(email);
        return cartItems;
    }
}
