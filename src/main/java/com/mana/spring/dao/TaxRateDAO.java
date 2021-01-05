package com.mana.spring.dao;

import com.mana.spring.domain.TaxRate;

import java.util.List;

public interface TaxRateDAO {

    TaxRate saveTaxRate(TaxRate taxRate);

    TaxRate updateTaxRate(TaxRate taxRate);

    TaxRate getById(long taxRateId);

    TaxRate getByTaxRateByLocation(String location);

    long count(boolean active);

    List getAll(int start, int end);

}