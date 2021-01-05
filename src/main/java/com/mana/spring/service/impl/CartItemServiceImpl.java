package com.mana.spring.service.impl;

import com.mana.spring.dao.CartItemDAO;
import com.mana.spring.domain.CartItem;
import com.mana.spring.dto.CartItemDTO;
import com.mana.spring.dto.CartItemDTOConverter;
import com.mana.spring.dto.CartItemListDTO;
import com.mana.spring.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDAO cartItemDAO;

    public void addToCart(CartItemDTO cartItemDTO) {
        cartItemDAO.save(CartItemDTOConverter.convertToDomain(cartItemDTO));
    }

    public void removeFromCart(CartItemDTO cartItemDTO) {
        cartItemDAO.delete(CartItemDTOConverter.convertToDomain(cartItemDTO));
    }

    @Override
    public void emptyUserCart(long userId) {
        cartItemDAO.deleteUserCart(userId);
    }

    public void updateCartItem(CartItemDTO cartItemDTO) {
        CartItem cartItemFromDb = cartItemDAO.cartItemByProductAndUser(cartItemDTO.getUserId(), cartItemDTO.getProductId());
        cartItemFromDb.setItemQuantity(cartItemDTO.getItemQuantity());
        cartItemFromDb.setCreatedDate(null);
        cartItemFromDb.setUpdatedDate(null);
        cartItemDAO.update(cartItemFromDb);
    }

    public CartItemListDTO getUserCart(long userId) {
        ArrayList<CartItem> listOfItems = (ArrayList<CartItem>) cartItemDAO.listUserCartItems(userId);
        CartItemListDTO cartItemListDTO = new CartItemListDTO();
        ArrayList<CartItemDTO> cartItemDTOS = null;
        for (CartItem cartItem : listOfItems)
            cartItemDTOS.add(CartItemDTOConverter.convertToDTO(cartItem));
        cartItemListDTO.setCartItemDTOS(cartItemDTOS);
        return cartItemListDTO;
    }

    @Override
    public void addListToCart(CartItemListDTO cartItemListDTO) {
        for (CartItemDTO cartItemDTO : cartItemListDTO.getCartItemDTOS()) {
            addToCart(cartItemDTO);
        }
    }
}
