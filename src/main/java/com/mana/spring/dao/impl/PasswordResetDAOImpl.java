package com.mana.spring.dao.impl;

import com.mana.spring.dao.PasswordResetDAO;
import com.mana.spring.domain.PasswordReset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PasswordResetDAOImpl implements PasswordResetDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public long savePasswordReset(PasswordReset passwordReset) {
        return (long) hibernateTemplate.save(passwordReset);
    }

    @Override
    public PasswordReset getPasswordReset(String token) {
        PasswordReset passwordReset = (PasswordReset) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.PasswordReset pwr where pwr.token= :token ").setParameter("token", token).uniqueResult();
        hibernateTemplate.initialize(passwordReset.getPasswordResetUser());
        return passwordReset;
    }

    @Override
    public void deleteToken(String token) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("delete com.mana.spring.domain.PasswordReset pwr where pwr.token= :token ").setParameter("token", token).executeUpdate();
    }
}
