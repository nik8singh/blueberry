package com.mana.spring.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private long couponId;

    @Column(name = "coupon_name", nullable = false)
    private String couponName;

    @Column(name = "coupon_discount_percent", nullable = false)
    private double couponDiscountPercent;

    @Column(name = "coupon_start_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date couponStartDate;

    @Column(name = "coupon_end_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date couponEndDate;

    @Column(name = "active")
    private boolean active;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    public Coupon() {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "\nCoupon{" +
                "\ncouponId=" + couponId +
                "\n couponName='" + couponName + '\'' +
                "\n couponDiscountPercent=" + couponDiscountPercent +
                "\n couponStartDate=" + couponStartDate +
                "\n couponEndDate=" + couponEndDate +
                "\n active=" + active +
                "\n createdDate=" + createdDate +
                "\n updatedDate=" + updatedDate +
                '}';
    }
}
