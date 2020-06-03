package com.mana.spring.dao.impl;

import com.mana.spring.dao.AdminTokenDAO;
import com.mana.spring.domain.AdminToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class AdminTokenDAOImpl implements AdminTokenDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void generate(AdminToken adminToken) {
        hibernateTemplate.save(adminToken);
    }

    @Override
    public List listActiveTokens() {
        Date today = new Date();

        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.AdminToken token where token.expiration >:today").setParameter("today", today).list();
    }
}
