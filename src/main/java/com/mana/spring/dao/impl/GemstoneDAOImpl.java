package com.mana.spring.dao.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.domain.Gemstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class GemstoneDAOImpl implements GemstoneDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveGemstone(Gemstone gemstone){
        hibernateTemplate.save(gemstone);
    }

    public void updateGemstone(Gemstone gemstone) {
        hibernateTemplate.update(gemstone);
    }

    public void deleteGemstone(Gemstone gemstone) {
        hibernateTemplate.delete(gemstone);
    }

    public List listGemstone() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem ORDER BY gem.createdDate").list();
    }
}
