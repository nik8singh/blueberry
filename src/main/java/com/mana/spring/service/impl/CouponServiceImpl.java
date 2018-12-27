package com.mana.spring.service.impl;

import com.mana.spring.dao.CouponDAO;
import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponListDTO;
import com.mana.spring.service.CouponService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;

@Transactional
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDAO couponDAO;

    public ArrayList<Coupon> getAllCoupons() {
        return (ArrayList<Coupon>) couponDAO.listCoupon();
    }

    public CouponListDTO getActiveCoupons(int pageNumber) {
        int size  = Pagination.getPageSize();
        CouponListDTO couponListDTO = createListDTO(pageNumber, true);
        couponListDTO.setCoupons((ArrayList<Coupon>) couponDAO.listActiveCoupon((pageNumber - 1) * size, pageNumber * size));
        return couponListDTO;
    }

    public CouponListDTO getInactiveCoupons(int pageNumber) {
        int size  = Pagination.getPageSize();
        CouponListDTO couponListDTO = createListDTO(pageNumber, false);
        couponListDTO.setCoupons((ArrayList<Coupon>) couponDAO.listInactiveCoupon((pageNumber - 1) * size, pageNumber * size));
        return couponListDTO;
    }


    public Coupon getCoupon(String couponName) {
        return couponDAO.getCoupon(couponName);
    }

    public void addCoupon(Coupon coupon) {

        coupon.setActive(updateActiveStatus(coupon));
        couponDAO.saveCoupon(coupon);
    }

    public void updateCoupon(Coupon coupon) {
        Coupon couponFromDb = couponDAO.getCouponById(coupon.getCouponId());

        couponFromDb.setCouponName(coupon.getCouponName());
        couponFromDb.setCouponStartDate(coupon.getCouponStartDate());
        couponFromDb.setCouponEndDate(coupon.getCouponEndDate());
        couponFromDb.setCouponDiscountPercent(coupon.getCouponDiscountPercent());
        couponFromDb.setCreatedDate(null);
        couponFromDb.setUpdatedDate(null);
        couponDAO.updateCoupon(couponFromDb);
    }


    public void deleteCoupon(String couponName) {
        couponDAO.deleteCoupon(couponName);
    }

    private boolean updateActiveStatus(Coupon coupon) {
        Date today = new Date();
        if (coupon.getCouponEndDate().compareTo(today) < 0) // end is before today
            return false;
        else if (coupon.getCouponStartDate().compareTo(today) > 0) // start is after today
            return false;
        else if (coupon.getCouponStartDate().compareTo(today) < 0 && coupon.getCouponEndDate().compareTo(today) > 0)
            return true;

        return false;
    }

    private CouponListDTO createListDTO(int pageNumber, boolean active) {
        long count = couponDAO.count(active);

        CouponListDTO couponListDTO = new CouponListDTO();
        couponListDTO.setCount(count);
        couponListDTO.setCurrentPageNumber(pageNumber);
        couponListDTO.setTotalPages((int) Math.ceil((double) count / 4));

        return couponListDTO;
    }
}
