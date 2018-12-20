package com.mana.spring.service.impl;

import com.mana.spring.dao.CouponDAO;
import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponDTO;
import com.mana.spring.service.CouponService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDAO couponDAO;

    public ArrayList<CouponDTO> getCoupons() {


        ArrayList<Coupon> coupons = (ArrayList<Coupon>) couponDAO.listCoupon();

        ArrayList<CouponDTO> couponDTOs = new ArrayList<CouponDTO>();

        for (Coupon source : coupons) {
            couponDTOs.add(ConverterDAOtoDTO.couponDaoToDto(source));
        }

        return couponDTOs;
    }

    public void addCoupon(CouponDTO couponDTO) {
        couponDAO.saveCoupon(ConverterDTOtoDAO.couponDtoToDao(couponDTO));
    }

    public void updateCoupon(CouponDTO couponDTO) {
        couponDAO.updateCoupon(ConverterDTOtoDAO.couponDtoToDao(couponDTO));
    }

    public CouponDTO getCoupon(long couponId) {
        return ConverterDAOtoDTO.couponDaoToDto(couponDAO.getCoupon(couponId));
    }

    public void deleteCoupon(CouponDTO couponDTO) {
        Coupon coupon = ConverterDTOtoDAO.couponDtoToDao(couponDTO);
        coupon.setActive(false);
        couponDAO.updateCoupon(coupon);
    }

}
