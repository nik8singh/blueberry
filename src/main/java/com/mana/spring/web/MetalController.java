package com.mana.spring.web;

import com.mana.spring.domain.Metal;
import com.mana.spring.dto.MetalListDTO;
import com.mana.spring.service.MetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/metal")
public class MetalController {

    @Autowired
    public MetalService metalService;

    @RequestMapping(value = "vis/list/active/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    MetalListDTO getAllActiveMetals(@PathVariable int pageNumber) {

        return metalService.getActiveMetals(pageNumber);
    }

    @RequestMapping(value = "adm/list/inactive/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    MetalListDTO getAllInactiveMetals(@PathVariable int pageNumber) {

        return metalService.getInactiveMetals(pageNumber);
    }


    @RequestMapping(value = "vis/metal/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Metal getMetal(@PathVariable String name) {

        return metalService.getMetal(name);
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public Metal saveMetal(@Valid @RequestBody Metal metal) {

        return metalService.addMetal(metal);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public Metal updateMetal(@Valid @RequestBody Metal metal) {

        return  metalService.updateMetal(metal);
    }

    @RequestMapping(value = "adm/deactivate/{name}", method = RequestMethod.POST)
    public ResponseEntity deactivateMetal(@PathVariable String name) {

        metalService.deactivateMetal(name);
        return new ResponseEntity(HttpStatus.OK);
    }

}
