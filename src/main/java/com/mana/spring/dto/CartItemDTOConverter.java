package com.mana.spring.dto;


import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.Image;
import com.mana.spring.domain.Product;
import com.mana.spring.domain.User;

public class CartItemDTOConverter {

    public static CartItemDTO convertToDTO(CartItem cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setCartItemId(cartItem.getCartItemId());
        cartItemDTO.setItemQuantity(cartItem.getItemQuantity());

        for (Image image : cartItem.getProduct().getImages())
            if (image.getImagePriority() == 1)
                cartItemDTO.setImage_secure_url(image.getImage_secure_url());

        cartItemDTO.setProductId(cartItem.getProduct().getProductId());
        cartItemDTO.setProductCurrency(cartItem.getProduct().getProductCurrency());
        cartItemDTO.setProductName(cartItem.getProduct().getProductName());
        cartItemDTO.setProductPrice(cartItem.getProduct().getProductPrice());
        cartItemDTO.setProductSku(cartItem.getProduct().getProductSku());

        cartItemDTO.setUserId(cartItem.getUser().getUserId());

        return cartItemDTO;
    }

    public static CartItem convertToDomain(CartItemDTO cartItemDTO) {
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(cartItemDTO.getCartItemId());
        cartItem.setItemQuantity(cartItemDTO.getItemQuantity());
        Product product = new Product();
        product.setProductId(cartItemDTO.getProductId());
        cartItem.setProduct(product);
        User user = new User();
        user.setUserId(cartItemDTO.getUserId());
        cartItem.setUser(user);

        return cartItem;
    }
}
