package com.mana.spring.dao.impl;

import com.mana.spring.dao.JewelryTypeDAO;
import com.mana.spring.domain.JewelryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class JewelryTypeDAOImpl implements JewelryTypeDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveJewelryType(JewelryType jewelryType) {
        hibernateTemplate.save(jewelryType);
    }

    public void updateJewelryType(JewelryType jewelryType) {
        hibernateTemplate.update(jewelryType);
    }

    public void deleteJewelryType(JewelryType jewelryType) {
        hibernateTemplate.delete(jewelryType);
    }

    public List listJewelryType() {
        System.out.println("STATUS: All jewelry type DAO");
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.JewelryType jt ORDER BY jt.createdDate").list();
    }


}
