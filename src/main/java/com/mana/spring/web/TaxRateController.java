package com.mana.spring.web;

import com.mana.spring.domain.TaxRate;
import com.mana.spring.service.TaxRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/taxrate")
public class TaxRateController {

    @Autowired
    public TaxRateService taxRateService;

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public TaxRate saveTaxRate(@RequestBody TaxRate taxRate) {
        return taxRateService.addTaxRate(taxRate);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public TaxRate updateTaxRate(@Valid @RequestBody TaxRate taxRate) {
        return taxRateService.updateTaxRate(taxRate);
    }

    @RequestMapping(value = "adm/list/active/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<TaxRate> getTaxRates(@PathVariable int pageNumber) {
        return taxRateService.getAll(pageNumber);
    }

}
