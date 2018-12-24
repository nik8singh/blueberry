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

    public Coupon getCoupon(long couponId) {
        return (Coupon) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.couponId = :id").setParameter("id", couponId).list().get(0);
    }
}
