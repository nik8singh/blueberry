package com.mana.spring.dao.impl;

import com.mana.spring.dao.ShopDAO;
import com.mana.spring.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDAOImpl implements ShopDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveShop(Shop shop) {
        try {
            hibernateTemplate.save(shop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateShop(Shop shop) {
        try {
            hibernateTemplate.update(shop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteShop(Shop shop) {
        try {
            hibernateTemplate.delete(shop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List listShop() {

        List result = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Shop").list();
        hibernateTemplate.initialize(result);

        return result;
    }

}
