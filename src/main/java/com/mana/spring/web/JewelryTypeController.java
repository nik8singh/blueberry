package com.mana.spring.web;

import com.mana.spring.domain.JewelryType;
import com.mana.spring.dto.JewelryTypeListDTO;
import com.mana.spring.service.JewelryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/jt")
public class JewelryTypeController {

    @Autowired
    public JewelryTypeService jewelryTypeService;

    @RequestMapping(value = "vis/list/active/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JewelryTypeListDTO getAllActiveJewelryTypes(@PathVariable int pageNumber) {

        return jewelryTypeService.getActiveJewelryTypes(pageNumber);
    }

    @RequestMapping(value = "adm/list/inactive/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JewelryTypeListDTO getAllInactiveJewelryTypes(@PathVariable int pageNumber) {

        return jewelryTypeService.getInactiveJewelryTypes(pageNumber);
    }


    @RequestMapping(value = "vis/jt/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JewelryType getJewelryType(@PathVariable String name) {

        return jewelryTypeService.getJewelryType(name);
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public JewelryType saveJewelryType(@Valid @RequestBody JewelryType metal) {


        return jewelryTypeService.addJewelryType(metal);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public JewelryType updateJewelryType(@Valid @RequestBody JewelryType metal) {


        return jewelryTypeService.updateJewelryType(metal);
    }

    @RequestMapping(value = "adm/deactivate/{name}", method = RequestMethod.POST)
    public ResponseEntity deactivateJewelryType(@PathVariable String name) {

        jewelryTypeService.deactivateJewelryType(name);
        return new ResponseEntity(HttpStatus.OK);
    }
}
