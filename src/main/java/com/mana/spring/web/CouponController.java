package com.mana.spring.web;

import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponListDTO;
import com.mana.spring.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
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
    public Coupon updateCoupon(@Valid @RequestBody Coupon coupon) {
        return couponService.updateCoupon(coupon);
    }

    @RequestMapping(value = "cus/coupon/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Coupon getCoupon(@PathVariable String name) {
        return couponService.getCoupon(name);
    }

    @RequestMapping(value = "adm/list/search/{searchWord}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    CouponListDTO getPartialSearch(@PathVariable String searchWord) {
        return couponService.partialSearch(searchWord);
    }

    @RequestMapping(value = "adm/activate/{id}", method = RequestMethod.POST)
    public ResponseEntity activateCoupon(@PathVariable long id) {
        couponService.activateCoupon(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/deactivate/{id}", method = RequestMethod.POST)
    public ResponseEntity deactivateCoupon(@PathVariable long id) {
        couponService.deactivateCoupon(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
