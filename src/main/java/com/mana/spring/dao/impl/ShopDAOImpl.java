package com.mana.spring.dao.impl;

import com.mana.spring.dao.ShopDAO;
import com.mana.spring.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShopDAOImpl implements ShopDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveShop(Shop shop) {
        hibernateTemplate.save(shop);
    }

    public void updateShop(Shop shop) {
        hibernateTemplate.update(shop);
    }

    public void deleteShop(Shop shop) {
        hibernateTemplate.delete(shop);
    }

    public List listShop() {

        List result = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Shop").list();
        hibernateTemplate.initialize(result);

        return result;
    }

}
