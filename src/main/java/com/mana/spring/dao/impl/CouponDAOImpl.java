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

    public Coupon updateCoupon(Coupon coupon) {
        hibernateTemplate.update(coupon);
        return coupon;
    }

    public List listCoupon() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon").list();
    }

    public List listActiveCoupon(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.active = :ac").setParameter("ac", true).setFirstResult(start).setMaxResults(end).list();
    }

    public List listInactiveCoupon(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.active = :ac").setParameter("ac", false).list();
    }

    public Coupon getCoupon(String couponName) {
        return (Coupon) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.couponName = :name").setParameter("name", couponName).uniqueResult();
    }

    public Coupon getCouponById(long couponId) {
        return (Coupon) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.couponId = :name").setParameter("name", couponId).uniqueResult();
    }

    public void deactivateCoupon(long id) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Coupon c set c.active = false where c.couponId = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void activateCoupon(long id) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Coupon c set c.active = true where c.couponId = :id").setParameter("id", id).executeUpdate();
    }

    public long count(boolean active) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Coupon c where c.active = :ac").setParameter("ac", active).uniqueResult();
    }

    @Override
    public List listPartialSearch(String searchWord) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon coup where coup.couponName LIKE concat('%',:searchWord,'%')").setParameter("searchWord", searchWord).list();
    }
}
