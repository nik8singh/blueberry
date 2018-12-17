package com.mana.spring.web;

import com.mana.spring.domain.Address;
import com.mana.spring.dto.AddressDTO;
import com.mana.spring.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    public AddressService addressService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<AddressDTO> getAllAddresss() {
        return addressService.getAddresses();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveAddress(@RequestBody AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return new ResponseEntity(addressDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateAddress(@RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteAddress(@RequestBody AddressDTO addressDTO) {
        addressService.deleteAddress(addressDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<AddressDTO> getAddressByUserEmail(@RequestBody String email) {
        return addressService.getAddressByUserEmail(email);
    }






}
