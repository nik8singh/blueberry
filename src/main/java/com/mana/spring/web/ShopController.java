package com.mana.spring.web;

import com.mana.spring.domain.Shop;
import com.mana.spring.dto.ShopDTO;
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
    public @ResponseBody
    ArrayList<ShopDTO> getAllShops() {
        return shopService.getShops();
    }

    @RequestMapping(value = "vis/list/upcoming", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ArrayList<Shop> getUpcomingAndOngoingShops() {
        return shopService.getUpcomingAndOngoingShops();
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public ResponseEntity saveShop(@RequestBody ShopDTO shopDTO) {
        shopService.addShop(shopDTO);
        return new ResponseEntity(shopDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public ResponseEntity updateShop(@RequestBody ShopDTO shopDTO) {
        System.out.println(shopDTO);
        shopService.updateShop(shopDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteShop(@PathVariable long id) {
        shopService.deleteShop(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "vis/shop/{shopName}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Shop getShop(@PathVariable String shopName) {
        return shopService.getShop(shopName);
    }

}
