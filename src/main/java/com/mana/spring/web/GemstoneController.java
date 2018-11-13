package com.mana.spring.web;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.service.GemstoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/gemstone")
public class GemstoneController {

    @Autowired
    public GemstoneService gemstoneService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<GemstoneDTO> getAllGemstones() {

        return gemstoneService.getGemstones();
    }

    @RequestMapping(value = "allactive", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<GemstoneDTO> getAllActiveGemstones() {

        return gemstoneService.getActiveGemstones();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveGemstone(@RequestBody GemstoneDTO gemstoneDTO) {

        gemstoneService.addGemstone(gemstoneDTO);
        return new ResponseEntity(gemstoneDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateGemstone(@RequestBody GemstoneDTO gemstoneDTO) {

        gemstoneService.updateGemstone(gemstoneDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
//    public ResponseEntity deleteGemstone(@RequestBody GemstoneDTO gemstoneDTO) {
//
//        gemstoneService.deleteGemstone(gemstoneDTO);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @RequestMapping(value = "gemstone", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Set<Product> getGemstoneProducts(@RequestBody GemstoneDTO gemstoneDTO) {

        return gemstoneService.getGemstoneProducts(gemstoneDTO).getProducts();
    }


}
