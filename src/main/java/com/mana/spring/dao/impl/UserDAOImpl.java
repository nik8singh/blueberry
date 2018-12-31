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

    public List listUser(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.User").setFirstResult(start).setMaxResults(end).list();
    }

    public User getUserByEmail(String email) {
        return (User) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.User us where us.userEmail= :email").setParameter("email", email).uniqueResult();
    }

    public User getUserCart(String email) {
        User user = getUserByEmail(email);
        hibernateTemplate.initialize(user.getCartItems());
        return user;
    }

    public User getUserInvoices(String email) {
        User user = getUserByEmail(email);
        hibernateTemplate.initialize(user.getInvoices());
        return user;
    }

    public void saveUser(User user) {
        hibernateTemplate.save(user);
    }

    public void deleteUser(String email) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.User met SET met.deleted = true where met.userEmail= :email").setParameter("email", email).executeUpdate();
    }

    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    public void updatePassword(User user) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.User us SET us.userPassword = :newPassword WHERE us.userEmail= :email").setParameter("email", user.getUserEmail()).setParameter("newPassword", user.getUserPassword()).executeUpdate();
    }

}
