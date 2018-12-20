import com.mana.spring.web.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMappingOfInventory {

    @Autowired
    private ProductController productController;


    @Test
    public void getProductGemstones() {
        System.out.println();
        System.out.println(productController.getAllProducts().iterator().next().getGemstoneDTOS());
    }

    @Test
    public void getProductMetal() {
        System.out.println();
        System.out.println(productController.getAllProducts().iterator().next().getMetalDTOS());
    }

    @Test
    public void getProductJewelryType() {
        System.out.println();
        System.out.println(productController.getAllProducts().iterator().next().getJewelryTypeName());
    }

    /*
     *  Products ===============
     * */
    @Test
    public void getAvailableProducts() {
        System.out.println();
        System.out.println(productController.getAvailableProducts());
    }

    @Test
    public void getProduct() {
        System.out.println();
        System.out.println(productController.getProduct(7L));
    }

}