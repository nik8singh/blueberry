package com.mana.spring.dao.impl;

import com.mana.spring.dao.ShopDAO;
import com.mana.spring.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    public void deleteShop(String shopName) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("delete com.mana.spring.domain.Shop sh where sh.shopName = :name").setParameter("name", shopName).executeUpdate();


    }

    public Shop getById(long shopId) {
        return (Shop) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Shop sh where sh.shopId = :id").setParameter("id", shopId).uniqueResult();

    }

    public List listUpcomingShop() {

        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Shop shop where shop.shopEndDate <=:todayDate ORDER BY shop.shopStartDate").setParameter("todayDate", new Date()).list();
    }

    public List listShop() {

        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Shop shop ORDER BY shop.createdDate").list();

    }

    public Shop getShop(String shopName) {
        return (Shop) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Shop shop where shop.shopName= :name ").setParameter("name", shopName).list().get(0);

    }


}
