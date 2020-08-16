package com.mana.spring.dto;

import com.mana.spring.domain.*;

import java.util.HashSet;
import java.util.Set;

public class UserDTOConverter {

    public static UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserFirstName(user.getUserFirstName());
        userDTO.setUserLastName(user.getUserLastName());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setDeleted(user.isDeleted());

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

        Set<Invoice> invoices = user.getInvoices();
        Set<InvoiceDTO> invoiceDTOS = new HashSet<>();
        for (Invoice invoice : invoices)
            invoiceDTOS.add(InvoiceDTOConverter.convertToDTO(invoice));
        userDTO.setInvoiceDTOS(invoiceDTOS);

        Set<CartItem> cartItems = user.getCartItems();
        Set<CartItemDTO> cartItemDTOS = new HashSet<>();
        for (CartItem cartItem : cartItems)
            cartItemDTOS.add(CartItemDTOConverter.convertToDTO(cartItem));
        userDTO.setCartItemDTOS(cartItemDTOS);

        return userDTO;
    }
}
