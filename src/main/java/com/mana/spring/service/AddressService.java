package com.mana.spring.service;

import com.mana.spring.domain.Address;

import java.util.ArrayList;

public interface AddressService {

    ArrayList<Address> getAddresses();

    void addAddress(Address address);

    void updateAddress(Address address);

    void deleteAddress(Address address);

    ArrayList<Address> getAddressByUserEmail(String userEmail);

}
