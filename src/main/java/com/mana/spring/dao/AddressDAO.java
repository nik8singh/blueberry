package com.mana.spring.dao;

import com.mana.spring.domain.Address;

import java.util.List;

public interface AddressDAO {

    void saveAddress(Address address);

    void updateAddress(Address address);

    void deleteAddress(Address address);

    List listAddress();
}
