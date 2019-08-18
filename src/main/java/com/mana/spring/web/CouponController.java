package com.mana.spring.web;

import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponListDTO;
import com.mana.spring.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    public CouponService couponService;

    @RequestMapping(value = "adm/list/active/{p}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    CouponListDTO getActiveCoupons(@PathVariable int p) {
        return couponService.getActiveCoupons(p);
    }


    @RequestMapping(value = "adm/list/active", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    CouponListDTO getCoupons() {
        return couponService.getActiveCoupons(1);
    }

    @RequestMapping(value = "adm/list/inactive/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    CouponListDTO getInactiveCoupons(@PathVariable int pageNumber) {
        return couponService.getInactiveCoupons(pageNumber);
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public ResponseEntity saveCoupon(@RequestBody Coupon coupon) {
        couponService.addCoupon(coupon);
        return new ResponseEntity(coupon, HttpStatus.OK);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public ResponseEntity updateCoupon(@RequestBody Coupon coupon) {
        couponService.updateCoupon(coupon);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteCoupon(@RequestBody String couponName) {
        couponService.deleteCoupon(couponName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "cus/coupon/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Coupon getCoupon(@PathVariable String name) {
        return couponService.getCoupon(name);
    }


}
