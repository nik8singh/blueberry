import com.mana.spring.dto.ShopDTO;
import com.mana.spring.web.ShopController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestShop {
    @Autowired
    private ShopController shopController;


    @Test
    public void getAllShops() {
        List<ShopDTO> shopsDtos = shopController.getAllShops();
        System.out.println();
        System.out.println(shopsDtos);
    }

    @Test
    public void getShop() {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setShopName("GDL");
        System.out.println();
        System.out.println(shopController.getShop(shopDTO));
    }

    @Test
    public void updateShop() {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setShopName("GDL");
        shopDTO = shopController.getShop(shopDTO);
        shopDTO.setShopDescription("Vegas Show testing update");
        shopController.updateShop(shopDTO);
    }

    @Test
    public void addShop() {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setShopName("GWL - London");
        shopDTO.setShopDescription("New ShoTestShopw In London");
        shopDTO.setBoothNumber("542");
        shopDTO.setShopStartDate(new Date());
        shopDTO.setShopEndDate(new Date());
        shopDTO.setAddressFullname("New Address for Shop");
        shopDTO.setAddressLineOne("23rd St");
        shopDTO.setAddressLineTwo("BLD 23");
        shopDTO.setAddressCity("London");
        shopDTO.setAddressState("London state");
        shopDTO.setAddressCountry("UK");
        shopDTO.setAddressZipcode("110086A");
        shopController.saveShop(shopDTO);

    }


}
