package com.mana.spring.web;

import com.mana.spring.domain.Product;
import com.mana.spring.dto.JewelryTypeDTO;
import com.mana.spring.service.JewelryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/jewelryType")
public class JewelryTypeController {

    @Autowired
    public JewelryTypeService jewelryTypeService;

    @RequestMapping(value = "all",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<JewelryTypeDTO> getAllJewelryType() {
        return jewelryTypeService.getJewelryTypes();
    }

    @RequestMapping(value = "allactive", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<JewelryTypeDTO> getAllActiveJewelryTypes() {

        return jewelryTypeService.getActiveJewelryTypes();
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ResponseEntity saveJewelryType(@RequestBody JewelryTypeDTO jewelryTypeDTO) {

        jewelryTypeService.addJewelryType(jewelryTypeDTO);
        return new ResponseEntity(jewelryTypeDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResponseEntity updateJewelryType(@RequestBody JewelryTypeDTO jewelryTypeDTO) {

        jewelryTypeService.updateJewelryType(jewelryTypeDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
//    public ResponseEntity deleteJewelryType(@RequestBody JewelryTypeDTO jewelryTypeDTO) {
//
//        jewelryTypeService.deleteJewelryType(jewelryTypeDTO);
//        return new ResponseEntity(HttpStatus.OK);
//    }

//    @RequestMapping(value = "jewelryType", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody Set<Product> getJewelryTypeProducts(JewelryTypeDTO jewelryTypeDTO) {
//        return jewelryTypeService.getJewelryTypeProducts(jewelryTypeDTO).getProducts();
//    }
}
