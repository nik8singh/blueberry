package com.mana.spring.service;

import com.mana.spring.domain.Coupon;

import java.util.ArrayList;

public interface CouponService {

    ArrayList<Coupon> getCoupons();

    ArrayList<Coupon> getActiveCoupons();

    ArrayList<Coupon> getInactiveCoupons();

    void addCoupon(Coupon coupon);

    void updateCoupon(Coupon coupon);

    void deleteCoupon(Coupon coupon);

    Coupon getCoupon(long couponId);
}
