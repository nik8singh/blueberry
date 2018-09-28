package com.mana.spring.web;

import com.mana.spring.domain.Gemstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mana.spring.service.GemstoneService;

import java.util.ArrayList;

@Controller
@RequestMapping("/gemstone")
public class GemstoneController {

    @Autowired
    public GemstoneService gemstoneService;

    @RequestMapping(value = "all",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ArrayList<Gemstone> getAllGemstones() {


        return gemstoneService.getGemstones();

    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponseEntity<Gemstone> addANewGemstone(@RequestBody Gemstone gemstone) {

        gemstoneService.addGemstone(gemstone);

        return new ResponseEntity<Gemstone>(gemstone, HttpStatus.OK);

    }

}
