package com.mana.spring.dao.impl;

import com.mana.spring.dao.MetalDAO;
import com.mana.spring.domain.Metal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MetalDAOImpl implements MetalDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveMetal(Metal metal) {
        hibernateTemplate.save(metal);
    }

    public void updateMetal(Metal metal) {
        hibernateTemplate.update(metal);
    }

    public void deactivateMetal(String metalName) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Metal met set met.metalActive = false where met.metalName= :name ").setParameter("name", metalName).executeUpdate();

    }

    public List listActiveMetals(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal met where met.metalActive= true ORDER BY met.createdDate").setFirstResult(start).setMaxResults(end).list();

    }

    public List listInactiveMetals(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal met where met.metalActive= false ORDER BY met.createdDate").setFirstResult(start).setMaxResults(end).list();

    }

    public Metal getMetal(String metalName, boolean requireProducts) {
        Metal metal = (Metal) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal gem where gem.metalName= :name ").setParameter("name", metalName).uniqueResult();

        if (requireProducts)
            hibernateTemplate.initialize(metal.getProducts());

        return metal;
    }

    public Metal getMetalById(long metalId) {
        return null;
    }

    public long count(boolean active) {
        return 0;
    }

}
