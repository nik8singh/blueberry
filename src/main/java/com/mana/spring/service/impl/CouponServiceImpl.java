package com.mana.spring.service.impl;

import com.mana.spring.dao.CouponDAO;
import com.mana.spring.domain.Coupon;
import com.mana.spring.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDAO couponDAO;

    public ArrayList<Coupon> getCoupons() {

        return (ArrayList<Coupon>) couponDAO.listCoupon();
    }

    public void addCoupon(Coupon coupon) {
        coupon.setActive(true);
        couponDAO.saveCoupon(coupon);
    }

    public void updateCoupon(Coupon coupon) {
        Coupon couponFromDb = couponDAO.getCoupon(coupon.getCouponId());
        couponFromDb.setCouponName(coupon.getCouponName());
        couponFromDb.setCouponStartDate(coupon.getCouponStartDate());
        couponFromDb.setCouponEndDate(coupon.getCouponEndDate());
        couponFromDb.setCouponDiscountPercent(coupon.getCouponDiscountPercent());
        couponFromDb.setCreatedDate(null);
        couponFromDb.setUpdatedDate(null);
        couponDAO.updateCoupon(couponFromDb);
    }

    public Coupon getCoupon(long couponId) {
        return couponDAO.getCoupon(couponId);
    }

    public void deleteCoupon(Coupon coupon) {
        coupon.setActive(false);
        couponDAO.updateCoupon(coupon);
    }

}
