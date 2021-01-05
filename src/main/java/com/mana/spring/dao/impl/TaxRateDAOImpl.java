package com.mana.spring.dao.impl;

import com.mana.spring.dao.TaxRateDAO;
import com.mana.spring.domain.TaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxRateDAOImpl implements TaxRateDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public TaxRate saveTaxRate(TaxRate taxRate) {
        hibernateTemplate.save(taxRate);
        return taxRate;
    }

    @Override
    public TaxRate updateTaxRate(TaxRate taxRate) {
        hibernateTemplate.update(taxRate);
        return taxRate;
    }

    @Override
    public TaxRate getById(long taxRateId) {
        return (TaxRate) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.TaxRate tax where tax.taxRateId= :id").setParameter("id", taxRateId).uniqueResult();
    }

    @Override
    public TaxRate getByTaxRateByLocation(String location) {
        return (TaxRate) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.TaxRate tax where tax.taxRateLocation= :loc").setParameter("loc", location).uniqueResult();
    }

    @Override
    public long count(boolean active) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.TaxRate tax").uniqueResult();
    }

    @Override
    public List getAll(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.TaxRate").setFirstResult(start).setMaxResults(end).list();
    }
}
