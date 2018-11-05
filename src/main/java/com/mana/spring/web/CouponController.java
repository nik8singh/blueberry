package com.mana.spring.web;

import com.mana.spring.domain.Coupon;
import com.mana.spring.domain.Metal;
import com.mana.spring.dto.CouponDTO;
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
    ArrayList<CouponDTO> getAllCoupons() {
        return couponService.getCoupons();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveCoupon(@RequestBody CouponDTO couponDTO) {
        couponService.addCoupon(couponDTO);
        return new ResponseEntity(couponDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateCoupon(@RequestBody CouponDTO couponDTO) {
        couponService.updateCoupon(couponDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteCoupon(@RequestBody CouponDTO couponDTO) {
        couponService.deleteCoupon(couponDTO);
        return new ResponseEntity(HttpStatus.OK);
    }


}
