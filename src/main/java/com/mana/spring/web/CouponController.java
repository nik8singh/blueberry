package com.mana.spring.web;

import com.mana.spring.domain.Coupon;
import com.mana.spring.domain.Metal;
import com.mana.spring.service.CouponService;
import com.mana.spring.service.MetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    public CouponService couponService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<Coupon> getAllGemstones() {
        return couponService.getCoupons();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveMetal(@RequestBody Coupon coupon) {
        couponService.addCoupon(coupon);
        return new ResponseEntity(coupon, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateMetal(@RequestBody Coupon coupon) {
        couponService.updateCoupon(coupon);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteMetal(@RequestBody Coupon coupon) {
        System.out.println("delete requested for " + coupon.getCouponId());
        couponService.deleteCoupon(coupon);
        return new ResponseEntity(HttpStatus.OK);
    }


}