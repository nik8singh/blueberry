package com.mana.spring.dao.impl;

import com.mana.spring.dao.ShowDAO;
import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.Show;
import com.mana.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShowDAOImpl implements ShowDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveShow(Show show) {
        hibernateTemplate.save(show);
    }

    public void updateShow(Show show) {
        hibernateTemplate.update(show);
    }

    public void deleteShow(Show show) {
        hibernateTemplate.delete(show);
    }

    public List listShow() {

        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Show").list();
    }

}
