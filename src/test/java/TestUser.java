import com.mana.spring.dto.AddressDTO;
import com.mana.spring.dto.CartItemDTO;
import com.mana.spring.dto.ProductDTO;
import com.mana.spring.dto.UserDTO;
import com.mana.spring.web.AddressController;
import com.mana.spring.web.CartItemController;
import com.mana.spring.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUser {
    @Autowired
    private UserController userController;

    @Autowired
    private AddressController addressController;


    @Autowired
    private CartItemController cartItemController;

//    @Test
//    public void getAllUsers() {
//
//    }
//
//    @Test
//    public void getUser() {
//
//        System.out.println(userController.getUserByEmail("yyfyi@.com"));
//    }
//
//    @Test
//    public void updateUser() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserFirstName("Testing@Update");
//        userDTO.setUserLastName("UnitTest");
//        userDTO.setUserEmail("nik8singh@gmail.com");
//
//        userController.updateUser(userDTO);
//    }
//
//    @Test
//    public void addUser() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserFirstName("TestingAdd");
//        userDTO.setUserLastName("Unit Test");
//        userDTO.setUserEmail("nik8singh@gmail.com");
//        userDTO.setUserPassword("Welcome1");
//        userDTO.setAuthorizationLevel("buyer");
//
//        userController.saveUser(userDTO);
//    }
//
//    @Test
//    public void addUserAddress() {
//        AddressDTO addressDTO = new AddressDTO();
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserEmail("yyfyi@.com");
//        addressDTO.setAddressFullname("Nikhil Singh");
//        addressDTO.setAddressLineOne("125th st");
//        addressDTO.setAddressLineTwo("apt 345");
//        addressDTO.setAddressCity("williston");
//        addressDTO.setAddressState("VT");
//        addressDTO.setAddressZipcode("45689");
//        addressDTO.setAddressCountry("USA");
//        Set<AddressDTO> addressesDto = new HashSet<AddressDTO>(0);
//        addressesDto.add(addressDTO);
//        userDTO.setAddressesDto(addressesDto);
//
//        userController.addAddress(userDTO);
//        getUser();
//
//    }
//
//    @Test
//    public void deleteUserAddress() {
//
//        AddressDTO addressDTO = new AddressDTO();
//        addressDTO.setAddressId(1L);
//        addressController.deleteAddress(addressDTO);
//
//    }
//
//    @Test
//    public void deleteUser() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserEmail("yyfyi@.com");
//
//        userController.deleteUser(userDTO);
//    }
//
//    @Test
//    public void updateUserPW() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserEmail("yyfyi@.com");
//        userDTO.setUserPassword("Welcome234");
//
//        userController.updatePassword(userDTO);
//    }
//
//    @Test
//    public void addToCart() {
//        CartItemDTO cartItemDTO = new CartItemDTO();
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserId(3L);
//
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setProductId(27L);
//
//        cartItemDTO.setUserDTO(userDTO);
//        cartItemDTO.setProductDTO(productDTO);
//        cartItemDTO.setProductQuantity(1);
//
//        cartItemController.addToCart(cartItemDTO);
//    }
//
//    @Test
//    public void getUserCart() {
//
//        ArrayList<CartItemDTO> cartItems = cartItemController.getUserCart("nik8singh@gmail.com");
//        System.out.println("Cart for user: " + cartItems.get(0).getUserDTO());
//        System.out.println("****************************************************");
//        int i = 1;
//        for (CartItemDTO cartItemDTO : cartItems) {
//            System.out.println(i + ") Quantity" + cartItemDTO.getProductQuantity());
//            System.out.println(cartItemDTO.getProductDTO());
//        }
//
//    }
//
//    @Test
//    public void removeFromCart() {
//        CartItemDTO cartItemDTO = new CartItemDTO();
//        cartItemDTO.setCartItemId(6L);
//        cartItemController.removeFromCart(cartItemDTO);
//
//    }
//
//    @Test
//    public void updateCartItem() {
//
//        CartItemDTO cartItemDTO = new CartItemDTO();
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserId(3L);
//        userDTO.setUserEmail("nik8singh@gmail.com");
//
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setProductId(27L);
//
//        cartItemDTO.setProductDTO(productDTO);
//        cartItemDTO.setUserDTO(userDTO);
//        cartItemDTO.setProductQuantity(3);
//        cartItemController.updateCartItem(cartItemDTO);
//    }


}
