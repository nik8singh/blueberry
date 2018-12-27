package com.mana.spring.web;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.dto.GemstoneListDTO;
import com.mana.spring.service.GemstoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gemstone")
public class GemstoneController {

    @Autowired
    public GemstoneService gemstoneService;

    @RequestMapping(value = "cus/list/active/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    GemstoneListDTO getAllActiveGemstones(@PathVariable int pageNumber) {

        return gemstoneService.getActiveGemstones(pageNumber);
    }

    @RequestMapping(value = "cus/list/inactive/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    GemstoneListDTO getAllInactiveGemstones(@PathVariable int pageNumber) {

        return gemstoneService.getInactiveGemstones(pageNumber);
    }


    @RequestMapping(value = "cus/gemstone/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Gemstone getGemstone(@PathVariable String name) {

        return gemstoneService.getGemstone(name);
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public ResponseEntity saveGemstone(@RequestBody Gemstone gemstone) {

        gemstoneService.addGemstone(gemstone);
        return new ResponseEntity(gemstone, HttpStatus.OK);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public ResponseEntity updateGemstone(@RequestBody Gemstone gemstone) {

        gemstoneService.updateGemstone(gemstone);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/deactivate/{name}", method = RequestMethod.DELETE)
    public ResponseEntity deactivateGemstone(@PathVariable String name) {

        gemstoneService.deactivateGemstone(name);
        return new ResponseEntity(HttpStatus.OK);
    }


}
