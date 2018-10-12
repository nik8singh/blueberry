package com.mana.spring.web;

import com.mana.spring.domain.Shop;
import com.mana.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    public ShopService shopService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<Shop> getAllShops() {
        return shopService.getShops();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveShop(@RequestBody Shop shop) {
        System.out.println(shop);
//        shopService.addShop(shop);
        return new ResponseEntity(shop, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateShop(@RequestBody Shop shop) {
        shopService.updateShop(shop);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteShop(@RequestBody Shop shop) {
        shopService.deleteShop(shop);
        return new ResponseEntity(HttpStatus.OK);
    }


}
