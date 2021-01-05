import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.Product;
import com.mana.spring.domain.User;
import com.mana.spring.dto.CartItemDTOConverter;
import com.mana.spring.web.CartItemController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCartItems {

    @Autowired
    CartItemController cartItemController;

    @Test
    public void addToCart() {
        CartItem cartItem = new CartItem();
        User user = new User();
        Product product = new Product();

        product.setProductId(6L);
        user.setUserId(29L);

        cartItem.setItemQuantity(1);
        cartItem.setProduct(product);
        cartItem.setUser(user);

        cartItemController.addToCart(CartItemDTOConverter.convertToDTO(cartItem));

    }

    @Test
    public void getCart(){
//        System.out.println(cartItemController.getUserCart("nik8singh@gmail.com"));
    }

    @Test
    public void removeCartItem(){
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(7L);

//        cartItemController.removeFromCart(cartItem);
    }

    @Test
    public void updateToCart(){
        CartItem cartItem = new CartItem();
        User user = new User();
        Product product = new Product();

        product.setProductId(24L);
        user.setUserEmail("nik8singh@gmail.com");

//        cartItem.setProductQuantity(1);
        cartItem.setProduct(product);
        cartItem.setUser(user);

//        cartItemController.updateCartItem(cartItem);

    }
}
