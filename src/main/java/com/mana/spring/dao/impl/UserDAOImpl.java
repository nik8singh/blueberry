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

    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    public void deleteUser(String email) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.User met SET met.deleted = :del where met.userEmail= :email").setParameter("email", email).setParameter("del", true).executeUpdate();
    }

    public List listUser() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.User met ORDER BY met.createdDate").list();
    }

    public User getUserByEmail(String email) {
        return (User) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.User met where met.userEmail= :email").setParameter("email", email).list().get(0);
    }

    public void updatePassword(User user) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.User met SET met.userPassword = :newPassword WHERE met.userEmail= :email").setParameter("email", user.getUserEmail()).setParameter("newPassword", user.getUserPassword()).executeUpdate();
    }
}
