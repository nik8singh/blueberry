package com.mana.spring.service.impl;

import com.mana.spring.dao.TaxRateDAO;
import com.mana.spring.domain.TaxRate;
import com.mana.spring.service.TaxRateService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class TaxRateServiceImpl implements TaxRateService {

    @Autowired
    private TaxRateDAO taxRateDAO;

    @Override
    public TaxRate addTaxRate(TaxRate taxRate) {
        return taxRateDAO.saveTaxRate(taxRate);
    }

    @Override
    public TaxRate updateTaxRate(TaxRate taxRate) {
        return taxRateDAO.updateTaxRate(taxRate);
    }

    @Override
    public ArrayList<TaxRate> getAll(int pageNumber) {
        int size = Pagination.getPageSize();
        return (ArrayList<TaxRate>) taxRateDAO.getAll((pageNumber - 1) * size, size);
    }
}
