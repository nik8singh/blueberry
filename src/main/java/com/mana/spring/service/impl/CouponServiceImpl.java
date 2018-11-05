package com.mana.spring.service.impl;

import com.mana.spring.dao.CouponDAO;
import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponDTO;
import com.mana.spring.service.CouponService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDAO CouponDAO;

    public ArrayList<CouponDTO> getCoupons() {


        ArrayList<Coupon> coupons = (ArrayList<Coupon>) CouponDAO.listCoupon();

        ArrayList<CouponDTO> couponDTOs = new ArrayList<CouponDTO>();

        for (Coupon source : coupons) {
            CouponDTO target = new CouponDTO();
            BeanUtils.copyProperties(source, target);
            couponDTOs.add(target);
        }

        return couponDTOs;
    }

    public void addCoupon(CouponDTO couponDTO) {
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(couponDTO, coupon);
        CouponDAO.saveCoupon(coupon);
    }

    public void updateCoupon(CouponDTO couponDTO) {
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(couponDTO, coupon);
        CouponDAO.updateCoupon(coupon);
    }

    public void deleteCoupon(CouponDTO couponDTO) {
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(couponDTO, coupon);
        CouponDAO.deleteCoupon(coupon);
    }

}
