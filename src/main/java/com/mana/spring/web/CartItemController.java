package com.mana.spring.web;

import com.mana.spring.dto.CartItemDTO;
import com.mana.spring.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    public CartItemService cartItemService;

//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public ResponseEntity addToCart(@RequestBody CartItemDTO cartItemDTO) {
//
//        cartItemService.addToCart(cartItemDTO);
//        return new ResponseEntity(cartItemDTO, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "remove", method = RequestMethod.POST)
//    public ResponseEntity removeFromCart(@RequestBody CartItemDTO cartItemDTO) {
//
//        cartItemService.removeFromCart(cartItemDTO);
//        return new ResponseEntity(cartItemDTO, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    public ResponseEntity updateCartItem(@RequestBody CartItemDTO cartItemDTO) {
//        cartItemService.updateCartItem(cartItemDTO);
//        return new ResponseEntity(cartItemDTO, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "get", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    ArrayList<CartItemDTO> getUserCart(@RequestBody String email) {
//
//        return cartItemService.getUserCart(email);
//    }

}
