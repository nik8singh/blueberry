package com.mana.spring.web;

import com.mana.spring.domain.Address;
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
    ArrayList<Address> getAllAddresss() {
        return addressService.getAddresses();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveAddress(@RequestBody Address address) {
        addressService.addAddress(address);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteAddress(@RequestBody Address address) {
        System.out.println("delete requested for " + address.getAddressId());
        addressService.deleteAddress(address);
        return new ResponseEntity(HttpStatus.OK);
    }


}
