package com.mana.spring.service;

import com.mana.spring.domain.Address;

import java.util.ArrayList;

public interface AddressService {

    void addAddress(Address address);

    void updateAddress(Address address);

    void deactivateAddress(long id);

    Address getAddress(long addressId);

    ArrayList<Address> getAddressByUserEmail(String userEmail);

}
