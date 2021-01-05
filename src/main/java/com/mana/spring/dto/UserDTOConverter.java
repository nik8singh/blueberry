package com.mana.spring.dto;

import com.mana.spring.domain.*;

import java.util.HashSet;
import java.util.Set;

public class UserDTOConverter {

    public static UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        System.out.println(user);
        userDTO.setUserId(user.getUserId());
        userDTO.setUserFirstName(user.getUserFirstName());
        userDTO.setUserLastName(user.getUserLastName());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setDeleted(user.isDeleted());
        userDTO.setNote(user.getNote());

        Set<UserAuthority> userAuthorities = user.getUserAuthorities();
        Set<UserAuthorityDTO> userAuthorityDTOS = new HashSet<>();
        for (UserAuthority userAuthority : userAuthorities)
            userAuthorityDTOS.add(UserAuthorityDTOConverter.convertToDTO(userAuthority));
        userDTO.setUserAuthorityDTO(userAuthorityDTOS);

        Set<Address> addresses = user.getAddresses();
        Set<AddressDTO> addressDTOS = new HashSet<>();
        for (Address address : addresses)
            addressDTOS.add(AddressDTOConverter.convertToDTO(address));
        userDTO.setAddressesDto(addressDTOS);

        Set<CartItem> cartItems = user.getCartItems();
        Set<CartItemDTO> cartItemDTOS = new HashSet<>();
        for (CartItem cartItem : cartItems)
            cartItemDTOS.add(CartItemDTOConverter.convertToDTO(cartItem));
        userDTO.setCartItemDTOS(cartItemDTOS);

        Set<Order> orders = user.getOrders();
        Set<OrderDTO> orderDTOS = new HashSet<>();
        for (Order or : orders)
            orderDTOS.add(OrderDTOConverter.convertToDTO(or));
        userDTO.setOrderDTOS(orderDTOS);

        return userDTO;
    }


}
