package com.mana.spring.web;

import com.mana.spring.domain.Metal;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.MetalDTO;
import com.mana.spring.service.MetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/metal")
public class MetalController {

    @Autowired
    public MetalService metalService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<MetalDTO> getAllMetals() {
        return metalService.getMetals();
    }

    @RequestMapping(value = "allactive", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<MetalDTO> getAllActiveMetals() {
        return metalService.getActiveMetals();
    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveMetal(@RequestBody MetalDTO metalDTO) {
        metalService.addMetal(metalDTO);
        return new ResponseEntity(metalDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateMetal(@RequestBody MetalDTO metalDTO) {
        metalService.updateMetal(metalDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
//    public ResponseEntity deleteMetal(@RequestBody Metal metal) {
//        metalService.deleteMetal(metal);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @RequestMapping(value = "metal", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Set<Product> getMetalProducts(MetalDTO metalDTO) {

        return metalService.getMetalProducts(metalDTO).getProducts();
    }



}
