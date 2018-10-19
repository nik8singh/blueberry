package com.mana.spring.dao.impl;

import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveUser(User user) {
        hibernateTemplate.save(user);
    }

    public void updateUser(User user) { hibernateTemplate.update(user); }

    public void deleteUser(User user) {
        hibernateTemplate.delete(user);
    }

    public List listUser() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.User met ORDER BY met.createdDate").list();
    }
}
