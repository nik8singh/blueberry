package com.mana.spring.dao;

import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponDTO;

import java.util.List;

public interface CouponDAO {

    void saveCoupon(Coupon coupon);

    void updateCoupon(Coupon coupon);

    List listCoupon();

    List listActiveCoupon();

    List listInactiveCoupon();

    Coupon getCoupon(long couponId);
}
