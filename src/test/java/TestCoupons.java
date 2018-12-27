import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponListDTO;
import com.mana.spring.web.CouponController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
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
        System.out.println(couponController.getCoupon("test"));
    }

    @Test
    public void addNewPast() {
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 01, 17);
        Date date = cal.getTime();
        Coupon coupon = new Coupon();
        coupon.setCouponName("2017");
        coupon.setCouponDiscountPercent(15);
        coupon.setCouponStartDate(date);
        cal.set(2017, 10, 17);
        date = cal.getTime();
        coupon.setCouponEndDate(date);
        couponController.saveCoupon(coupon);
    }

    @Test
    public void addNewFuture() {
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 01, 17);
        Date date = cal.getTime();
        Coupon coupon = new Coupon();
        coupon.setCouponName("2019");
        coupon.setCouponDiscountPercent(15);
        coupon.setCouponStartDate(date);
        cal.set(2019, 10, 17);
        date = cal.getTime();
        coupon.setCouponEndDate(date);
        couponController.saveCoupon(coupon);
    }

    @Test
    public void addNewPresent() {
        Calendar cal = Calendar.getInstance();
        cal.set(2018, 01, 17);
        Date date = cal.getTime();
        Coupon coupon = new Coupon();
        coupon.setCouponName("2018");
        coupon.setCouponDiscountPercent(15);
        coupon.setCouponStartDate(date);
        cal.set(2018, 12, 31);
        date = cal.getTime();
        coupon.setCouponEndDate(date);
        couponController.saveCoupon(coupon);
    }

    @Test
    public void update() {
        Calendar cal = Calendar.getInstance();
        cal.set(2018, 00, 17);
        Date date = cal.getTime();

        Coupon coupon = new Coupon();
        coupon.setCouponId(6L);
        coupon.setCouponName("Final UT");
        coupon.setCouponDiscountPercent(5);
        coupon.setCouponStartDate(date);
        cal.set(2019, 5, 31);
        date = cal.getTime();
        coupon.setCouponEndDate(date);
        couponController.updateCoupon(coupon);
    }

    @Test
    public void delete() {
        couponController.deleteCoupon("2nd test");
    }


}
