import com.mana.spring.domain.Address;
import com.mana.spring.domain.Shop;
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
        List<Shop> shops = shopController.getAllShops();
        System.out.println(shops);
    }

    @Test
    public void getShop() {
        System.out.println(shopController.getShop("GDL"));
    }

    @Test
    public void updateShop() {

        Shop shop = shopController.getShop("Stones of worlds");

        shop.setShopDescription("SoW gem shop");
        Address address = shop.getShopAddress();
        address.setAddressFullname("Convention center");
        address.setAddressZipcode("54534");
        address.setAddressLineTwo("458th sthih");
        shop.setShopAddress(address);
        shopController.updateShop(shop);
    }

    @Test
    public void addShop() {
        Shop shop = new Shop();
        shop.setShopName("GWL - London");
        shop.setShopDescription("New ShoTestShopw In London");
        shop.setBoothNumber("542");
        shop.setShopStartDate(new Date());
        shop.setShopEndDate(new Date());

        Address address = new Address();
        address.setAddressFullname("235 pearl st Address for Shop");
        address.setAddressLineOne("212t St");
        address.setAddressLineTwo("BLD 253");
        address.setAddressCity("Tuscon");
        address.setAddressState("AZ");
        address.setAddressCountry("USA");
        address.setAddressZipcode("57895");

        shop.setShopAddress(address);

        shopController.saveShop(shop);

    }


}
