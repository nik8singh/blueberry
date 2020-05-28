package com.mana.spring.web;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.dto.GemstoneListDTO;
import com.mana.spring.service.GemstoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/gemstone")
public class GemstoneController {

    @Autowired
    public GemstoneService gemstoneService;

    @RequestMapping(value = "vis/list/active/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    GemstoneListDTO getAllActiveGemstones(@PathVariable int pageNumber) {

        return gemstoneService.getActiveGemstones(pageNumber);
    }

    @RequestMapping(value = "adm/list/inactive/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    GemstoneListDTO getAllInactiveGemstones(@PathVariable int pageNumber) {

        return gemstoneService.getInactiveGemstones(pageNumber);
    }

    @RequestMapping(value = "adm/list/search/{searchWord}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    GemstoneListDTO getPartialSearch(@PathVariable String searchWord) {
        return gemstoneService.partialSearch(searchWord);
    }


    @RequestMapping(value = "vis/gemstone/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Gemstone getGemstone(@PathVariable String name) {

        return gemstoneService.getGemstone(name);
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public Gemstone saveGemstone(@Valid @RequestBody Gemstone gemstone) {

        return gemstoneService.addGemstone(gemstone);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public Gemstone updateGemstone(@Valid @RequestBody Gemstone gemstone) {

        return gemstoneService.updateGemstone(gemstone);
    }

    @RequestMapping(value = "adm/deactivate/{id}", method = RequestMethod.POST)
    public ResponseEntity deactivateGemstone(@PathVariable long id) {
        gemstoneService.deactivateGemstone(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/activate/{id}", method = RequestMethod.POST)
    public ResponseEntity activateGemstone(@PathVariable long id) {
        gemstoneService.activateGemstone(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
