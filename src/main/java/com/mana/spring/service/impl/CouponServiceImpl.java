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
    private CouponDAO CouponDAO;

    public ArrayList<Coupon> getCoupons() {
        return (ArrayList<Coupon>) CouponDAO.listCoupon();
    }

    public void addCoupon(Coupon coupon) {
        CouponDAO.saveCoupon(coupon);
    }

    public void updateCoupon(Coupon coupon) {
        CouponDAO.updateCoupon(coupon);
    }

    public void deleteCoupon(Coupon coupon) {
        CouponDAO.deleteCoupon(coupon);
    }

}
