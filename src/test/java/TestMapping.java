import com.mana.spring.domain.Address;
import com.mana.spring.domain.Shop;
import com.mana.spring.domain.User;
import com.mana.spring.web.AddressController;
import com.mana.spring.web.ShopController;
import com.mana.spring.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMapping {

    @Autowired
    private ShopController shopController;

    @Autowired
    private UserController userController;

    @Autowired
    private AddressController addressController;

    @Test
    public void getAllShops() {
        List<Shop> shops = shopController.getAllShops();
        System.out.println();
        System.out.println(shops);
    }

    @Test
    public void deleteShopShouldNotDeleteAddress() {

        Shop shop = new Shop();
        shop.setShopId(13L);
        Address address = new Address();
        address.setAddressId(14L);
        shop.setShopAddress(address);
        shopController.deleteShop(shop);
        List<Shop> shops = shopController.getAllShops();
        System.out.println();
        System.out.println(shops);

    }

    @Test
    public void getAllUsers() {
        List<User> users = userController.getAllUsers();
        System.out.println();
        System.out.println(users);
    }

    @Test
    public void removeUserAddress() {


        User user = userController.getAllUsers().get(0);
        Address add = user.getAddresses().iterator().next();
        System.out.println(add);

        for (Iterator<User> iterator = add.getUser().iterator(); iterator.hasNext(); ) {
            if (iterator.next().getUserId().equals(user.getUserId())) {
                iterator.remove();
                break;
            }
        }

        for (Iterator<Address> iterator = user.getAddresses().iterator(); iterator.hasNext(); ) {
            Address a = iterator.next();
            if (a.getAddressId().equals(add.getAddressId())) {
                iterator.remove();
                break;
            }
        }

        System.out.println(user);

        userController.updateUser(user);

    }

    @Test
    public void deletingUserShouldNotDeleteAddress() {
        List<User> users = userController.getAllUsers();
        for (User a : users) {
            System.out.println(a);
            userController.deleteUser(a);
            break;
        }


    }

}
