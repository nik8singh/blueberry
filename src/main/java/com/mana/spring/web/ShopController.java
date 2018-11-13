package com.mana.spring.web;

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

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<ShopDTO> getAllShops() {
        return shopService.getShops();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveShop(@RequestBody ShopDTO shopDTO) {
        shopService.addShop(shopDTO);
        return new ResponseEntity(shopDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateShop(@RequestBody ShopDTO shopDTO) {
        shopService.updateShop(shopDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
//    public ResponseEntity deleteShop(@RequestBody ShopDTO shopDTO) {
//        shopService.deleteShop(shopDTO);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @RequestMapping(value = "shop", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ShopDTO getShop(@RequestBody ShopDTO shopDTO) {
        return shopService.getShop(shopDTO);
    }

}
