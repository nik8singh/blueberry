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

    public void addAddress(Address address) {
        address.setActive(true);
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

    public void deactivateAddress(long id) {
        addressDAO.deactivateAddress(id);
    }

    public Address getAddress(long addressId) {
        return addressDAO.getAddress(addressId);
    }

    public ArrayList<Address> getAddressByUserEmail(String userEmail) {
        return (ArrayList<Address>) addressDAO.getAddressByEmail(userEmail);
    }


}
