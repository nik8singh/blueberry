package com.mana.spring.dto;

import java.util.Date;

public class CouponDTO {
    private long couponId;

    private String couponName;

    private double couponDiscountPercent;

    private Date couponStartDate;

    private Date couponEndDate;

    private boolean active;

    private boolean status;

    public CouponDTO() {
    }

    private void updateStatus() {
        Date today = new Date();

        if (couponStartDate.after(today))
            status = false;
        else {
            status = !couponEndDate.before(today);
        }

    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public double getCouponDiscountPercent() {
        return couponDiscountPercent;
    }

    public void setCouponDiscountPercent(double couponDiscountPercent) {
        this.couponDiscountPercent = couponDiscountPercent;
    }

    public Date getCouponStartDate() {
        return couponStartDate;
    }

    public void setCouponStartDate(Date couponStartDate) {
        this.couponStartDate = couponStartDate;
        if (couponEndDate != null)
            updateStatus();
    }

    public Date getCouponEndDate() {
        return couponEndDate;
    }

    public void setCouponEndDate(Date couponEndDate) {
        this.couponEndDate = couponEndDate;
        if (couponStartDate != null)
            updateStatus();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "\n\nCoupon{" +
                "\n\tcouponId= " + couponId +
                "\n\tcouponName= '" + couponName + '\'' +
                "\n\tcouponDiscountPercent= " + couponDiscountPercent +
                "\n\tcouponStartDate= " + couponStartDate +
                "\n\tcouponEndDate= " + couponEndDate +
                "\n\tactive= " + active +
                "\n\tstatus= " + status +
                "\n}";
    }

}
