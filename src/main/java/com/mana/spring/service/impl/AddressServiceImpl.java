package com.mana.spring.service.impl;

import com.mana.spring.dao.AddressDAO;
import com.mana.spring.domain.Address;
import com.mana.spring.dto.AddressDTO;
import com.mana.spring.service.AddressService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO addressDAO;

    public ArrayList<AddressDTO> getAddresses() {
        return null;
    }

    public void addAddress(AddressDTO addressDTO) {

        addressDAO.saveAddress(ConverterDTOtoDAO.addressDtoToDao(addressDTO));

    }

    public void updateAddress(AddressDTO addressDTO) {

        addressDAO.updateAddress(ConverterDTOtoDAO.addressDtoToDao(addressDTO));

    }

    public void deleteAddress(AddressDTO addressDTO) {
        Address address = ConverterDTOtoDAO.addressDtoToDao(addressDTO);
        addressDAO.deleteAddress(address);
    }

    public AddressDTO getAddress(long addressId) {
        AddressDTO addressDTO = ConverterDAOtoDTO.addressDaoToDto(addressDAO.getAddress(addressId));
        return addressDTO;
    }

    public ArrayList<AddressDTO> getAddressByUserEmail(String userEmail) {
        ArrayList<Address> addresses = (ArrayList<Address>) addressDAO.getAddressByEmail(userEmail);
        ArrayList<AddressDTO> addressDTOS = new ArrayList<AddressDTO>();

        for (Address address : addresses) {
            addressDTOS.add(ConverterDAOtoDTO.addressDaoToDto(address));
        }

        return addressDTOS;
    }


}
