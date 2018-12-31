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

    @RequestMapping(value = "cus/save", method = RequestMethod.POST)
    public ResponseEntity saveAddress(@RequestBody Address address) {
        addressService.addAddress(address);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @RequestMapping(value = "cus/update", method = RequestMethod.POST)
    public ResponseEntity updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "cus/deactivate/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deactivateAddress(@PathVariable long id) {
        addressService.deactivateAddress(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "cus/list/{email}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<Address> getAddressByUserEmail(@PathVariable String email) {
        return addressService.getAddressByUserEmail(email);
    }

}
