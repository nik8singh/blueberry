package com.mana.spring.web;

import com.mana.spring.domain.CartItem;
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

    @RequestMapping(value = "cus/save", method = RequestMethod.POST)
    public ResponseEntity addToCart(@RequestBody CartItem cartItem) {

        cartItemService.addToCart(cartItem);
        return new ResponseEntity(cartItem, HttpStatus.OK);
    }

    @RequestMapping(value = "cus/delete", method = RequestMethod.POST)
    public ResponseEntity removeFromCart(@RequestBody CartItem cartItem) {

        cartItemService.removeFromCart(cartItem);
        return new ResponseEntity(cartItem, HttpStatus.OK);
    }

    @RequestMapping(value = "cus/update", method = RequestMethod.POST)
    public ResponseEntity updateCartItem(@RequestBody CartItem cartItem) {
        cartItemService.updateCartItem(cartItem);
        return new ResponseEntity(cartItem, HttpStatus.OK);
    }

    @RequestMapping(value = "cus/list/{email}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<CartItem> getUserCart(@PathVariable String email) {

        return cartItemService.getUserCart(email);
    }

}
