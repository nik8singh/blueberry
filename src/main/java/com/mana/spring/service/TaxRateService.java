package com.mana.spring.service;

import com.mana.spring.domain.TaxRate;

import java.util.ArrayList;

public interface TaxRateService {

    TaxRate addTaxRate(TaxRate taxRate);

    TaxRate updateTaxRate(TaxRate taxRate);

    ArrayList<TaxRate> getAll(int pageNumber);

}
