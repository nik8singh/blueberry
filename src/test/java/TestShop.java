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
//        List<Shop> shops = shopController.getAllShops();
//        System.out.println(shops);
    }

    @Test
    public void getAllUpcomingAndOngoingShops() {
        List<Shop> shops = shopController.getUpcomingAndOngoingShops();
        System.out.println(shops);
    }

    @Test
    public void getShop() {
        System.out.println(shopController.getShop("GWL - London"));
    }

    @Test
    public void deleteShop() {
//        System.out.println(shopController.deleteShop("TO BE DELETED"));
    }

    @Test
    public void updateShop() {

        Shop shop = shopController.getShop("GWL - London");

        shop.setShopDescription("GWL - USA");
        Address address = shop.getShopAddress();
        address.setAddressFullname("Convention center");
        address.setAddressZipcode("54534");
        address.setAddressLineTwo("458th Ave");
        address.setAddressCity("LA");
        address.setAddressState("Cali");
        address.setAddressCountry("USA");
        shop.setShopAddress(address);
//        shopController.updateShop(shop);
    }

    @Test
    public void addShop() {
        Shop shop = new Shop();
        shop.setShopName("TO BE DELETED");
        shop.setShopDescription("VT show");
        shop.setBoothNumber("254");
        shop.setShopStartDate(new Date());
        shop.setShopEndDate(new Date());

        Address address = new Address();
        address.setAddressFullname("DELETED GWL");
        address.setAddressLineOne("212t St");
        address.setAddressLineTwo("BLD 253");
        address.setAddressCity("Essex");
        address.setAddressState("VT");
        address.setAddressCountry("USA");
        address.setAddressZipcode("1057895");

        shop.setShopAddress(address);

//        shopController.saveShop(shop);

    }


}
