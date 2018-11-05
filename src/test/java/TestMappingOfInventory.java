import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.domain.Metal;
import com.mana.spring.web.GemstoneController;
import com.mana.spring.web.JewelryTypeController;
import com.mana.spring.web.MetalController;
import com.mana.spring.web.ProductController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMappingOfInventory {

    @Autowired
    private GemstoneController gemstoneController;

    @Autowired
    private ProductController productController;


    @Autowired
    private JewelryTypeController jewelryTypeController;


    @Autowired
    private MetalController metalController;

    /*
     *  Gemstone ===============
     * */
    @Test
    public void getAllGemstones() {
        List<Gemstone> gems = gemstoneController.getAllGemstones();
        System.out.println();
        System.out.println(gems);
    }

    @Test
    public void getActiveGemstones() {
        List<Gemstone> gems = gemstoneController.getAllActiveGemstones();

        for(Gemstone g : gems)
            Assert.assertTrue(g.isGemstoneActive());

        System.out.println();
        System.out.println(gems);
    }

    @Test
    public void getGemstoneProduct() {
        System.out.println();
        System.out.println(gemstoneController.getGemstone("ruby"));
    }

    @Test
    public void getProductGemstones() {
        System.out.println();
        System.out.println(productController.getAllProducts().iterator().next().getGemstones());
    }

    /*
     *  Jewelry Type ===============
     * */
    @Test
    public void getAllJewelryType() {
        List<JewelryType> jt = jewelryTypeController.getAllJewelryType();
        System.out.println();
        System.out.println(jt);
    }

    @Test
    public void getActiveJewelryType() {
        List<JewelryType> jt = jewelryTypeController.getAllActiveJewelryTypes();

        for(JewelryType j : jt)
            Assert.assertTrue(j.isJewelryTypeActive());
        System.out.println();
        System.out.println(jt);
    }

    @Test
    public void getJewelryTypeProduct() {
        System.out.println();
        System.out.println(jewelryTypeController.getJewelryType("belts"));
    }

    @Test
    public void getProductJewelryType() {
        System.out.println();
        System.out.println(productController.getAllProducts().iterator().next().getJewelryTypeName());
    }

    /*
     *  Metal ===============
     * */
    @Test
    public void getAllMetal() {
        List<Metal> metal = metalController.getAllMetals();
        System.out.println();
        System.out.println(metal);
    }

    @Test
    public void getMetalProduct() {
        System.out.println();
        System.out.println(metalController.getMetal("gold"));
    }

    @Test
    public void getProductMetal() {
        System.out.println();
        System.out.println(productController.getAllProducts().iterator().next().getMetals());
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
