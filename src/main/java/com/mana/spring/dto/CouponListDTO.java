package com.mana.spring.dto;

import com.mana.spring.domain.Coupon;

import java.util.ArrayList;

public class CouponListDTO {

    private ArrayList<Coupon> coupons;
    private long count;
    private int totalPages;
    private int currentPageNumber;

    public CouponListDTO() {
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
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
