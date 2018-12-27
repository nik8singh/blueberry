package com.mana.spring.dto;

import com.mana.spring.domain.Coupon;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class CouponListDTO extends Pagination {

    private ArrayList<Coupon> coupons;

    public CouponListDTO() {
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "\nCouponListDTO{" +
                "\n\tcoupons=" + coupons +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}
