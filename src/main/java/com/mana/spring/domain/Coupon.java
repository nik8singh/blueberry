package com.mana.spring.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue
    @Column(name = "coupon_id")
    private long couponId;

    @Column(name = "coupon_name")
    private String couponName;

    @Column(name = "coupon_discount_percent")
    private double couponDiscountPercent;

    @Column(name = "coupon_start_date")
    private Date couponStartDate;

    @Column(name = "coupon_end_date")
    private Date couponEndDate;

    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    public Coupon() {
    }

    public Coupon(String couponName, double couponDiscountPercent, Date couponStartDate, Date couponEndDate) {
        this.couponName = couponName;
        this.couponDiscountPercent = couponDiscountPercent;
        this.couponStartDate = couponStartDate;
        this.couponEndDate = couponEndDate;
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
    }

    public Date getCouponEndDate() {
        return couponEndDate;
    }

    public void setCouponEndDate(Date couponEndDate) {
        this.couponEndDate = couponEndDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId=" + couponId +
                ", couponName='" + couponName + '\'' +
                ", couponDiscountPercent=" + couponDiscountPercent +
                ", couponStartDate=" + couponStartDate +
                ", couponEndDate=" + couponEndDate +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
