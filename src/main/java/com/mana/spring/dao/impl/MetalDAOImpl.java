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

    public Metal saveMetal(Metal metal) {
        hibernateTemplate.save(metal);
        return metal;
    }

    public Metal updateMetal(Metal metal) {
        hibernateTemplate.update(metal);
        return metal;
    }

    public void deactivateMetal(long id) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Metal met set met.metalActive = false where met.metalId= :id ").setParameter("id", id).executeUpdate();
    }

    public void activateMetal(long id) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Metal met set met.metalActive = true where met.metalId= :id ").setParameter("id", id).executeUpdate();
    }

    public List listActiveMetals(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal met where met.metalActive= true").setFirstResult(start).setMaxResults(end).list();

    }

    public List listActiveMetals() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal met where met.metalActive= true").list();

    }

    public List listInactiveMetals(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal met where met.metalActive= false").setFirstResult(start).setMaxResults(end).list();

    }

    public Metal getMetal(String metalName, boolean requireProducts) {
        Metal metal = (Metal) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal met where met.metalName= :name ").setParameter("name", metalName).uniqueResult();

        if (requireProducts)
            hibernateTemplate.initialize(metal.getProducts());

        return metal;
    }

    public Metal getMetalById(long metalId) {
        Metal metal = (Metal) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal met where met.metalId= :id ").setParameter("id", metalId).uniqueResult();
        hibernateTemplate.initialize(metal.getProducts());
        return metal;
    }

    public long count(boolean active) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Metal met where met.metalActive = :ac").setParameter("ac", active).uniqueResult();
    }

    @Override
    public List listPartialSearch(String searchWord) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal met where met.metalName LIKE concat('%',:searchWord,'%') or met.metalDescription LIKE concat('%',:searchWord,'%')").setParameter("searchWord", searchWord).list();
    }

}
