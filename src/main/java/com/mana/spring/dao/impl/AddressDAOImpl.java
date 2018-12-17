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

        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.Address met SET met.active = :active where met.addressId= :id").setParameter("id", address.getAddressId()).setParameter("active", false).executeUpdate();
    }

    public List listAddress() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Address met ORDER BY met.createdDate").list();
    }

    public List getAddressByEmail(String email) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Address met where met.user.userEmail= :email").setParameter("email", email).list();
    }

    public Address getAddress(long addressId) {
        return (Address) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Address met where met.addressId= :id").setParameter("id", addressId).list().get(0);

    }


}
