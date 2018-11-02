package com.mana.spring.service.impl;

import com.mana.spring.dao.AddressDAO;
import com.mana.spring.domain.Address;
import com.mana.spring.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO AddressDAO;

    public ArrayList<Address> getAddresses() {
        return (ArrayList<Address>) AddressDAO.listAddress();
    }

    public void addAddress(Address address) {
        AddressDAO.saveAddress(address);
    }

    public void updateAddress(Address address) {
        AddressDAO.updateAddress(address);
    }

    public void deleteAddress(Address address) {
        AddressDAO.deleteAddress(address);
    }

}
