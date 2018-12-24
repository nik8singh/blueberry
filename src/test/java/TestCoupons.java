import com.mana.spring.domain.Coupon;
import com.mana.spring.dto.CouponDTO;
import com.mana.spring.web.CouponController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCoupons {

    @Autowired
    private CouponController couponController;

    @Test
    public void getList() {
        List<Coupon> C = couponController.getAllCoupons();
        System.out.println(C);
    }

    @Test
    public void addNew() {
        Coupon coupon = new Coupon();
        coupon.setCouponName("Xmas");
        coupon.setCouponDiscountPercent(5.5);
        coupon.setCouponEndDate(new Date());
        coupon.setCouponStartDate(new Date());
        couponController.saveCoupon(coupon);
    }

    @Test
    public void update() {
        Coupon couponDTO = new Coupon();
        couponDTO.setCouponId(6L);
        couponDTO.setCouponName("Mid term unit test");
        couponController.updateCoupon(couponDTO);
    }

    @Test
    public void delete() {
        Coupon couponDTO = new Coupon();
        couponDTO.setCouponId(5L);
        couponDTO.setCouponName("test add");
        couponController.deleteCoupon(couponDTO);
    }


}
