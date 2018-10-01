package com.mana.spring.web;

import com.mana.spring.domain.JewelryType;
import com.mana.spring.service.JewelryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/jewelryType")
public class JewelryTypeController {

    @Autowired
    public JewelryTypeService jewelryTypeService;

    @RequestMapping(value = "all",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<JewelryType> getAllJewelryType() {
        System.out.println("STATUS: All jewelry type requested");
        return jewelryTypeService.getJewelryTypes();
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ResponseEntity saveJewelryType(@RequestBody JewelryType jewelryType) {

        jewelryTypeService.addJewelryType(jewelryType);
        return new ResponseEntity(jewelryType, HttpStatus.OK);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResponseEntity updateJewelryType(@RequestBody JewelryType jewelryType) {

        jewelryTypeService.updateJewelryType(jewelryType);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResponseEntity deleteJewelryType(@RequestBody JewelryType jewelryType) {

        jewelryTypeService.deleteJewelryType(jewelryType);
        return new ResponseEntity(HttpStatus.OK);
    }
}
