package com.mana.spring.service.impl;

import com.mana.spring.dao.CartItemDAO;
import com.mana.spring.domain.CartItem;
import com.mana.spring.dto.CartItemDTO;
import com.mana.spring.service.CartItemService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDAO cartItemDAO;

    public void addToCart(CartItemDTO cartItemDTO) {

        CartItem cartItem = ConverterDTOtoDAO.cartItemDtoToDao(cartItemDTO);
        System.out.println(cartItem);

        cartItemDAO.save(cartItem);

    }

    public void removeFromCart(CartItemDTO cartItemDTO) {

        cartItemDAO.delete(ConverterDTOtoDAO.cartItemDtoToDao(cartItemDTO));
    }

    public void updateCartItem(CartItemDTO cartItemDTO) {
        CartItem cartItem = cartItemDAO.cartItemByProductAndUser(ConverterDTOtoDAO.cartItemDtoToDao(cartItemDTO));
        cartItem.setProductQuantity(cartItemDTO.getProductQuantity());
        cartItem.setCreatedDate(null);
        cartItem.setUpdatedDate(null);
        cartItemDAO.update(cartItem);
    }

    public ArrayList<CartItemDTO> getUserCart(String email) {
        ArrayList<CartItemDTO> cartItemDTOS = new ArrayList<CartItemDTO>();
        ArrayList<CartItem> cartItems = (ArrayList<CartItem>) cartItemDAO.listUserCartItems(email);

        for (CartItem cartItem : cartItems)
            cartItemDTOS.add(ConverterDAOtoDTO.cartItemDaoToDto(cartItem));

        return cartItemDTOS;
    }


}
