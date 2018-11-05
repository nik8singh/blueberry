import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.domain.Metal;
import com.mana.spring.dto.CouponDTO;
import com.mana.spring.web.*;
import org.junit.Assert;
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
    public void getAllGemstones() {
        List<CouponDTO> C = couponController.getAllCoupons();
        System.out.println();
        System.out.println(C);
    }

    @Test
    public void addGemstones() {
        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setCouponName("test add");
        couponDTO.setCouponDiscountPercent(5.5);
        couponDTO.setCouponEndDate(new Date());
        couponDTO.setCouponStartDate(new Date());
        couponController.saveCoupon(couponDTO);
        System.out.println();
    }


}
