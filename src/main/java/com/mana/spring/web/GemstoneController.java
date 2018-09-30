package com.mana.spring.web;

import com.mana.spring.domain.Gemstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.mana.spring.service.GemstoneService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gemstone")
public class GemstoneController {

    @Autowired
    public GemstoneService gemstoneService;

    @RequestMapping(value = "all",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ArrayList<Gemstone> getAllGemstones() {

        System.out.println(gemstoneService.getGemstones());
        return gemstoneService.getGemstones();

    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ResponseEntity saveGemstone(@RequestBody Gemstone gemstone) {

        gemstoneService.addUpdateGemstone(gemstone);

        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResponseEntity deleteGemstone(@RequestBody Gemstone gemstone) {

        gemstoneService.deleteGemstone(gemstone);

        return new ResponseEntity(HttpStatus.OK);

    }



}
