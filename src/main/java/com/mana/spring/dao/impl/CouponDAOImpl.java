package com.mana.spring.dao.impl;

import com.mana.spring.dao.CouponDAO;
import com.mana.spring.domain.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

    public List listActiveCoupon(int start, int end) {

        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.active = :ac").setParameter("ac", true).setFirstResult(start).setMaxResults(end).list();

    }

    public List listInactiveCoupon(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.active = :ac").setParameter("ac", false).list();
    }

    public Coupon getCoupon(String couponName) {
        return (Coupon) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.couponName = :name").setParameter("name", couponName).list().get(0);
    }

    public Coupon getCouponById(long couponId) {
        return (Coupon) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Coupon c where c.couponId = :name").setParameter("name", couponId).list().get(0);
    }

    public void deleteCoupon(String couponName) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("delete com.mana.spring.domain.Coupon c where c.couponName = :name").setParameter("name", couponName).executeUpdate();
    }

    public long count(boolean active){

        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Coupon c where c.active = :ac").setParameter("ac", active).uniqueResult();
    }
}
