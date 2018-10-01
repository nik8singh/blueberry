package com.mana.spring.web;

import com.mana.spring.domain.Metal;
import com.mana.spring.service.MetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/metal")
public class MetalController {

    @Autowired
    public MetalService metalService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<Metal> getAllGemstones() {
        return metalService.getMetals();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveMetal(@RequestBody Metal metal) {
        metalService.addMetal(metal);
        return new ResponseEntity(metal, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateMetal(@RequestBody Metal metal) {
        metalService.updateMetal(metal);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteMetal(@RequestBody Metal metal) {
        metalService.deleteMetal(metal);
        return new ResponseEntity(HttpStatus.OK);
    }


}
