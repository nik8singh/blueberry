package com.mana.spring.dao.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.domain.Gemstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class GemstoneDAOImpl implements GemstoneDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void createGemstone(Gemstone gemstone) {
        hibernateTemplate.saveOrUpdate(gemstone);

    }

    public void updateGemstone(Gemstone gemstone) {

    }

    public void deleteGemstone(Gemstone gemstone) {
        hibernateTemplate.delete(gemstone);
    }

    public List<Gemstone> listGemstone() {
        return (List<Gemstone>)hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem ORDER BY gem.createdDate").list();
    }
}
