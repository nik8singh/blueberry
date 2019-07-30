import com.mana.spring.domain.Address;
import com.mana.spring.domain.User;
import com.mana.spring.web.AddressController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAddress {
    @Autowired
    private AddressController addressController;

    @Test
    public void getAddressesByEmail(){
        System.out.println(addressController.getAddressByUserEmail("nscoder8@gmail.com"));
    }

    @Test
    public void addUserAddress(){
        Address address = new Address();
        address.setAddressFullname("VHC Office");
        address.setAddressLineOne("12 river road");
        address.setAddressCity("Essex Junction");
        address.setAddressState("Vermont");
        address.setAddressCountry("USA");
        address.setAddressZipcode("05452");
        User user = new User();
        user.setUserId(1L);
        address.setUser(user);

        addressController.saveAddress(address);
    }

    @Test
    public void updateUserAddress(){
        Address address = new Address();
        address.setAddressId(5L);
        address.setAddressFullname("Williston Office");
        address.setAddressLineOne("289 Hurricane Ln");
        address.setAddressCity("Williston");
        address.setAddressState("Vermont");
        address.setAddressCountry("USA");
        address.setAddressZipcode("05495");

        addressController.updateAddress(address);
    }

    @Test
    public void deleteUserAddress(){

        addressController.deactivateAddress(6L);
    }
}
