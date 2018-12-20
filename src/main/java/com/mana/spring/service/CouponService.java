package com.mana.spring.service;

import com.mana.spring.dto.CouponDTO;

import java.util.ArrayList;

public interface CouponService {

    ArrayList<CouponDTO> getCoupons();

    void addCoupon(CouponDTO coupon);

    void updateCoupon(CouponDTO coupon);

    void deleteCoupon(CouponDTO coupon);

    CouponDTO getCoupon(long couponId);
}
