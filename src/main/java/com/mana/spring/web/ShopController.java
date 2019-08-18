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

    @RequestMapping(value = "vis/list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ArrayList<Shop> getAllShops() {
        return shopService.getShops();
    }

    @RequestMapping(value = "vis/list/upcoming", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ArrayList<Shop> getUpcomingAndOngoingShops() {
        return shopService.getUpcomingAndOngoingShops();
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public ResponseEntity saveShop(@RequestBody Shop shop) {
        shopService.addShop(shop);
        return new ResponseEntity(shop, HttpStatus.OK);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public ResponseEntity updateShop(@RequestBody Shop shop) {
        shopService.updateShop(shop);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/delete/{shopName}", method = RequestMethod.DELETE)
    public ResponseEntity deleteShop(@PathVariable String shopName) {
        shopService.deleteShop(shopName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "vis/shop/{shopName}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Shop getShop(@PathVariable String shopName) {
        return shopService.getShop(shopName);
    }

}
