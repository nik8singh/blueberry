package com.mana.spring.dto;


import com.mana.spring.domain.Address;

public class AddressDTOConverter {

    public static AddressDTO convertToDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(address.getAddressId());
        addressDTO.setAddressFullname(address.getAddressFullname());
        addressDTO.setAddressLineOne(address.getAddressLineOne());
        addressDTO.setAddressLineTwo(address.getAddressLineTwo() == null ? "" : address.getAddressLineTwo());
        addressDTO.setAddressCity(address.getAddressCity());
        addressDTO.setAddressState(address.getAddressState());
        addressDTO.setAddressZipcode(address.getAddressZipcode());
        addressDTO.setAddressCountry(address.getAddressCountry());
        addressDTO.setActive(address.isActive());
        return addressDTO;
    }
}
