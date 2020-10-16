package com.mana.spring.service;

import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponListDTO;

import java.util.ArrayList;

public interface CouponService {

    ArrayList<Coupon> getAllCoupons();

    CouponListDTO getActiveCoupons(int pageNumber);

    CouponListDTO getInactiveCoupons(int pageNumber);

    Coupon getCoupon(String couponName);

    void addCoupon(Coupon coupon);

    Coupon updateCoupon(Coupon coupon);

    void deactivateCoupon(long id);

    void activateCoupon(long id);

    CouponListDTO partialSearch(String searchWord);

}
