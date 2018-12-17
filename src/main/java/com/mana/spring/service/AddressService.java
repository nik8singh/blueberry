package com.mana.spring.service;

import com.mana.spring.dto.AddressDTO;

import java.util.ArrayList;

public interface AddressService {

    ArrayList<AddressDTO> getAddresses();

    void addAddress(AddressDTO addressDTO);

    void updateAddress(AddressDTO addressDTO);

    void deleteAddress(AddressDTO addressDTO);

    ArrayList<AddressDTO> getAddressByUserEmail(String userEmail);

}
