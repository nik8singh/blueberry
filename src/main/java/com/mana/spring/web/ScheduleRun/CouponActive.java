package com.mana.spring.web.ScheduleRun;

import com.mana.spring.domain.Coupon;
import com.mana.spring.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@EnableScheduling
@Service("couponActive")
public class CouponActive {

    @Autowired
    public CouponService couponService;

    @Scheduled(cron = "0 1 12 ? * *")
    public void calculate() {

        ArrayList<Coupon> coupons = couponService.getAllCoupons();

        Date today = new Date();

        for (Coupon coupon : coupons) {
            if (coupon.getCouponEndDate().compareTo(today) < 0) // end is before today
                coupon.setActive(false);
            else if (coupon.getCouponStartDate().compareTo(today) > 0) // start is after today
                coupon.setActive(false);
            else if (coupon.getCouponStartDate().compareTo(today) < 0 && coupon.getCouponEndDate().compareTo(today) > 0)
                coupon.setActive(true);

            couponService.updateCoupon(coupon);
        }
    }

//    @Scheduled(fixedDelay = 5000)
//    public void methodTwoSec() {
//        System.out.println("Testing schedule run every 5 second");
//    }
}
