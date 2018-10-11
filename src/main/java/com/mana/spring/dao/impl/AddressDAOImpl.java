package com.mana.spring.dao.impl;

import com.mana.spring.dao.AddressDAO;
import com.mana.spring.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    public void saveAddress(Address address) {
        hibernateTemplate.save(address);
    }

    public void updateAddress(Address address) {

        hibernateTemplate.update(address);
    }

    public void deleteAddress(Address address) {

        hibernateTemplate.delete(address);
    }

    public List listAddress() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Address met ORDER BY met.createdDate").list();
    }
}
