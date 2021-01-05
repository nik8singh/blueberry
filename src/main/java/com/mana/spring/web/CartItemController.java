package com.mana.spring.web;

import com.mana.spring.dto.CartItemDTO;
import com.mana.spring.dto.CartItemListDTO;
import com.mana.spring.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    public CartItemService cartItemService;

    @RequestMapping(value = "cus/save", method = RequestMethod.POST)
    public ResponseEntity addToCart(@RequestBody CartItemDTO cartItemDTO) {

        cartItemService.addToCart(cartItemDTO);
        return new ResponseEntity(cartItemDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "cus/list/save", method = RequestMethod.POST)
    public ResponseEntity syncCart(@RequestBody CartItemListDTO cartItemListDTO) {

        cartItemService.addListToCart(cartItemListDTO);
        return new ResponseEntity(cartItemListDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "cus/delete", method = RequestMethod.POST)
    public ResponseEntity removeFromCart(@RequestBody CartItemDTO cartItemDTO) {

        cartItemService.removeFromCart(cartItemDTO);
        return new ResponseEntity(cartItemDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "cus/update", method = RequestMethod.POST)
    public ResponseEntity updateCartItem(@RequestBody CartItemDTO cartItemDTO) {
        cartItemService.updateCartItem(cartItemDTO);
        return new ResponseEntity(cartItemDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "cus/list/{userId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    CartItemListDTO getUserCart(@PathVariable long userId) {

        return cartItemService.getUserCart(userId);
    }

}
