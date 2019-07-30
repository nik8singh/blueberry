import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponListDTO;
import com.mana.spring.web.CouponController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCoupons {

    @Autowired
    private CouponController couponController;

    @Test
    public void getActiveList() {
        CouponListDTO couponListDTO = couponController.getActiveCoupons(1);
        System.out.println(couponListDTO);
    }

    @Test
    public void getInactiveList() {
        CouponListDTO couponListDTO = couponController.getInactiveCoupons(1);
        System.out.println(couponListDTO);
    }

    @Test
    public void getCoupon() {
        System.out.println(couponController.getCoupon("Winter2018"));
    }

    @Test
    public void addNewPast() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2017-5-01");
        Coupon coupon = new Coupon();
        coupon.setCouponName("Summer2017");
        coupon.setCouponDiscountPercent(15);
        coupon.setCouponStartDate(date);
        date = formatter.parse("2017-7-31");
        coupon.setCouponEndDate(date);
        couponController.saveCoupon(coupon);
    }

    @Test
    public void addNewFuture() throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2019-12-01");
        Coupon coupon = new Coupon();
        coupon.setCouponName("Winter2019");
        coupon.setCouponDiscountPercent(20);
        System.out.println("start: " + date);
        coupon.setCouponStartDate(date);
        date = formatter.parse("2020-4-01");
        System.out.println("end: " + date);
        coupon.setCouponEndDate(date);
        couponController.saveCoupon(coupon);
    }

    @Test
    public void addNewPresent() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2018-12-01");
        Coupon coupon = new Coupon();
        coupon.setCouponName("Winter2018");
        coupon.setCouponDiscountPercent(20);
        System.out.println("start: " + date);
        coupon.setCouponStartDate(date);
        date = formatter.parse("2019-5-01");
        System.out.println("end: " + date);
        coupon.setCouponEndDate(date);
        couponController.saveCoupon(coupon);
    }

    @Test
    public void update() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2019-5-01");

        Coupon coupon = new Coupon();
        coupon.setCouponId(1L);
        coupon.setCouponName("Summer2019");
        coupon.setCouponDiscountPercent(20);
        coupon.setCouponStartDate(date);
        date = formatter.parse("2019-8-31");
        coupon.setCouponEndDate(date);
        couponController.updateCoupon(coupon);
    }

    @Test
    public void delete() {
        couponController.deleteCoupon("Winter2019");
    }


}
