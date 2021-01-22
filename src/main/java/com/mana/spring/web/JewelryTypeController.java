package com.mana.spring.web;

import com.mana.spring.domain.JewelryType;
import com.mana.spring.dto.JewelryTypeListDTO;
import com.mana.spring.service.JewelryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/jewelryType")
public class JewelryTypeController {

    @Autowired
    public JewelryTypeService jewelryTypeService;

    @RequestMapping(value = "vis/list/active/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JewelryTypeListDTO getAllActiveJewelryTypes(@PathVariable int pageNumber) {

        return jewelryTypeService.getActiveJewelryTypes(pageNumber);
    }

    @RequestMapping(value = "adm/list/inactive/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JewelryTypeListDTO getAllInactiveJewelryTypes(@PathVariable int pageNumber) {

        return jewelryTypeService.getInactiveJewelryTypes(pageNumber);
    }

    @RequestMapping(value = "adm/list/search/{searchWord}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JewelryTypeListDTO getPartialSearch(@PathVariable String searchWord) {
        return jewelryTypeService.partialSearch(searchWord);
    }

    @RequestMapping(value = "vis/jt/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JewelryType getJewelryType(@PathVariable String name) {

        return jewelryTypeService.getJewelryType(name);
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public JewelryType saveJewelryType(@Valid @RequestBody JewelryType jt) {

        return jewelryTypeService.addJewelryType(jt);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public JewelryType updateJewelryType(@Valid @RequestBody JewelryType jt) {

        return jewelryTypeService.updateJewelryType(jt);
    }

    @RequestMapping(value = "adm/deactivate/{id}", method = RequestMethod.POST)
    public ResponseEntity deactivateJewelryType(@PathVariable long id) {

        jewelryTypeService.deactivateJewelryType(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/activate/{id}", method = RequestMethod.POST)
    public ResponseEntity activateJewelryType(@PathVariable long id) {

        jewelryTypeService.activateJewelryType(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
