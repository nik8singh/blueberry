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
    private AddressDAO addressDAO;

    public ArrayList<Address> getAddresses() {
        return null;
    }

    public void addAddress(Address address) {

        addressDAO.saveAddress(address);

    }

    public void updateAddress(Address address) {

        Address addressFromDb = addressDAO.getAddress(address.getAddressId());
        addressFromDb.setAddressFullname(address.getAddressFullname());
        addressFromDb.setAddressLineOne(address.getAddressLineOne());
        addressFromDb.setAddressLineTwo(address.getAddressLineTwo());
        addressFromDb.setAddressCity(address.getAddressCity());
        addressFromDb.setAddressState(address.getAddressState());
        addressFromDb.setAddressCountry(address.getAddressCountry());
        addressFromDb.setAddressZipcode(address.getAddressZipcode());
        addressFromDb.setCreatedDate(null);
        addressFromDb.setUpdatedDate(null);
        addressDAO.updateAddress(addressFromDb);

    }

    public void deleteAddress(Address address) {
        addressDAO.deleteAddress(address);
    }

    public Address getAddress(long addressId) {
        Address address = addressDAO.getAddress(addressId);
        return address;
    }

    public ArrayList<Address> getAddressByUserEmail(String userEmail) {
        ArrayList<Address> addresses = (ArrayList<Address>) addressDAO.getAddressByEmail(userEmail);
        return addresses;
    }


}
