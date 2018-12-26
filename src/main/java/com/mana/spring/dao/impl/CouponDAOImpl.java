package com.mana.spring.dao.impl;

import com.mana.spring.dao.CouponDAO;
import com.mana.spring.domain.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponDAOImpl implements CouponDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveCoupon(Coupon coupon) {
        hibernateTemplate.save(coupon);
    }

    public void updateCoupon(Coupon coupon) {
        hibernateTemplate.update(coupon);
    }

    public List listCoupon() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon").list();
    }

    public List listActiveCoupon() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.active = :ac").setParameter("ac", true).list();
    }

    public List listInactiveCoupon() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.active = :ac").setParameter("ac", false).list();
    }

    public Coupon getCoupon(String couponName) {
        return (Coupon) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.couponName = :name").setParameter("name", couponName).list().get(0);
    }
}
