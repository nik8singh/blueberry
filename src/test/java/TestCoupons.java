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
        List<CouponDTO> C = couponController.getAllCoupons();
        System.out.println(C);
    }

    @Test
    public void addNew() {
        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setCouponName("test add");
        couponDTO.setCouponDiscountPercent(5.5);
        couponDTO.setCouponEndDate(new Date());
        couponDTO.setCouponStartDate(new Date());
        couponController.saveCoupon(couponDTO);
    }

    @Test
    public void update() {
        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setCouponId(6L);
        couponDTO.setCouponName("Mid term unit test");
        couponController.updateCoupon(couponDTO);
    }

    @Test
    public void delete() {
        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setCouponId(5L);
        couponDTO.setCouponName("test add");
        couponController.deleteCoupon(couponDTO);
    }


}
