package com.mana.spring.dao;

import com.mana.spring.domain.Coupon;

import java.util.List;

public interface CouponDAO {


    void saveCoupon(Coupon coupon);

    Coupon updateCoupon(Coupon coupon);

    void deactivateCoupon(long id);

    void activateCoupon(long id);

    List listCoupon();

    List listActiveCoupon(int start, int end);

    List listInactiveCoupon(int start, int end);

    Coupon getCoupon(String couponName);

    Coupon getCouponById(long couponId);

    long count(boolean active);

    List listPartialSearch(String searchWord);

}
