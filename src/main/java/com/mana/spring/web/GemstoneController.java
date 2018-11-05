package com.mana.spring.web;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.Product;
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
    ArrayList<Gemstone> getAllGemstones() {

        return gemstoneService.getGemstones();
    }

    @RequestMapping(value = "allactive", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<Gemstone> getAllActiveGemstones() {

        return gemstoneService.getActiveGemstones();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveGemstone(@RequestBody Gemstone gemstone) {

        gemstoneService.addGemstone(gemstone);
        return new ResponseEntity(gemstone, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateGemstone(@RequestBody Gemstone gemstone) {

        gemstoneService.updateGemstone(gemstone);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteGemstone(@RequestBody Gemstone gemstone) {

        gemstoneService.deleteGemstone(gemstone);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "gemstone", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Set<Product> getGemstone(String gemstoneName) {

        return gemstoneService.getGemstone(gemstoneName).getProducts();
    }


}
