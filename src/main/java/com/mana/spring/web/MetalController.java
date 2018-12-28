package com.mana.spring.web;

import com.mana.spring.domain.Metal;
import com.mana.spring.dto.MetalListDTO;
import com.mana.spring.service.MetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metal")
public class MetalController {

    @Autowired
    public MetalService metalService;

    @RequestMapping(value = "cus/list/active/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    MetalListDTO getAllActiveMetals(@PathVariable int pageNumber) {

        return metalService.getActiveMetals(pageNumber);
    }

    @RequestMapping(value = "cus/list/inactive/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    MetalListDTO getAllInactiveMetals(@PathVariable int pageNumber) {

        return metalService.getInactiveMetals(pageNumber);
    }


    @RequestMapping(value = "cus/metal/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Metal getMetal(@PathVariable String name) {

        return metalService.getMetal(name);
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public ResponseEntity saveMetal(@RequestBody Metal metal) {

        metalService.addMetal(metal);
        return new ResponseEntity(metal, HttpStatus.OK);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public ResponseEntity updateMetal(@RequestBody Metal metal) {

        metalService.updateMetal(metal);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/deactivate/{name}", method = RequestMethod.DELETE)
    public ResponseEntity deactivateMetal(@PathVariable String name) {

        metalService.deactivateMetal(name);
        return new ResponseEntity(HttpStatus.OK);
    }

}
