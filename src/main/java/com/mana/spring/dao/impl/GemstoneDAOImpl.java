package com.mana.spring.dao.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.domain.Gemstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GemstoneDAOImpl implements GemstoneDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveGemstone(Gemstone gemstone) {
        hibernateTemplate.save(gemstone);
    }

    public void updateGemstone(Gemstone gemstone) {
        hibernateTemplate.update(gemstone);
    }

    public void deleteGemstone(Gemstone gemstone) {
        hibernateTemplate.delete(gemstone);
    }

    public List listGemstones() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem ORDER BY gem.createdDate").list();
    }

    public List listActiveGemstones() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneActive= :active ORDER BY gem.createdDate").setParameter("active", true).list();
    }

    public Gemstone getGemstone(String gemstoneName) {

        return (Gemstone)hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneName= :name ").setParameter("name", gemstoneName).list().get(0);

    }
}
