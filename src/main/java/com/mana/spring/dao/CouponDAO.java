package com.mana.spring.dao;

import com.mana.spring.domain.Coupon;

import java.util.List;

public interface CouponDAO {

    void saveCoupon(Coupon coupon);

    void updateCoupon(Coupon coupon);

    void deleteCoupon(Coupon coupon);

    List listCoupon();
}
