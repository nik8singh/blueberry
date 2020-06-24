package com.mana.spring.dao.impl;

import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List listUser(int start, int end) {
        List users = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.User").setFirstResult(start).setMaxResults(end).list();
        makeItEager(users);
        return users;
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

    public User saveUser(User user) {
        hibernateTemplate.save(user);
        return user;
    }

    public void deactivateUser(String email) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.User us SET us.deleted = true where us.userEmail= :email").setParameter("email", email).executeUpdate();
    }

    public void activateUser(String email) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.User us SET us.deleted = false where us.userEmail= :email").setParameter("email", email).executeUpdate();
    }

    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    public void updatePassword(User user) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.User us SET us.userPassword = :newPassword WHERE us.userEmail= :email").setParameter("email", user.getUserEmail()).setParameter("newPassword", user.getUserPassword()).executeUpdate();
    }

    @Override
    public List listAdminUser() {
//        List auth = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.UserAuthority auth  where auth.role =:auth").setParameter("auth","ROLE_ADMIN").list();
        List users = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select user from com.mana.spring.domain.User user left join user.userAuthorities auth where auth.role =:auth").setParameter("auth", "ROLE_ADMIN").list();

        makeItEager(users);
        return users;
    }

    private void makeItEager(User user) {
        hibernateTemplate.initialize(user.getInvoices());
        hibernateTemplate.initialize(user.getCartItems());
        hibernateTemplate.initialize(user.getAddresses());
        hibernateTemplate.initialize(user.getUserAuthorities());
    }

    private void makeItEager(List<User> user) {
        for (User p : user)
            makeItEager(p);
    }


}
