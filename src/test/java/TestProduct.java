import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.dto.MetalDTO;
import com.mana.spring.dto.ProductDTO;
import com.mana.spring.web.ImageController;
import com.mana.spring.web.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestProduct {

    @Autowired
    private ImageController imageController;

    @Autowired
    private ProductController productController;

    @Test
    public void addProduct() {

        ProductDTO product = new ProductDTO();
        product.setProductName("Product Junit 2nd test");
        product.setProductDescription("Testing part 2 addition of product using Junit");
        product.setJewelryTypeId(13L);
        product.setProductWeight(20);
        product.setWeightUnit("Grams");
        product.setProductPrice(50);
        product.setProductCurrency("USD");
        product.setProductSku("125sd44913");
        product.setProductQuantity(5);
        product.setProductQuantityType("pieces");
        product.setProductOnFeatured(true);
        product.setProductPublished(true);
        product.setProductExpense(10.00);
        product.setProductAcceptCoupon(false);

        ArrayList<GemstoneDTO> gemstoneDTOS = new ArrayList<GemstoneDTO>();
        GemstoneDTO gemstoneDTO = new GemstoneDTO();
        gemstoneDTO.setGemstoneId(45L);
        gemstoneDTOS.add(gemstoneDTO);
        gemstoneDTO = new GemstoneDTO();
        gemstoneDTO.setGemstoneId(47L);
        gemstoneDTOS.add(gemstoneDTO);
        product.setGemstones(gemstoneDTOS);

        ArrayList<MetalDTO> metalDTOS = new ArrayList<MetalDTO>();
        MetalDTO metalDTO = new MetalDTO();
        metalDTO.setMetalId(10L);
        metalDTOS.add(metalDTO);
        product.setMetals(metalDTOS);

        productController.saveProduct(product);
    }

    @Test
    public void updateProduct() {

        ProductDTO product = new ProductDTO();
        product.setProductId(27L);
        product.setProductName("Product Junit 3rd test");
        product.setProductDescription("Testing part 3 addition of product using Junit");
        product.setJewelryTypeId(13L);
        product.setProductWeight(40.55);
        product.setWeightUnit("Grams");
        product.setProductPrice(200);
        product.setProductCurrency("USD");
        product.setProductSku("125465989913");
        product.setProductQuantity(2);
        product.setProductQuantityType("pieces");
        product.setProductOnFeatured(true);
        product.setProductPublished(true);
        product.setProductExpense(80.00);
        product.setProductAcceptCoupon(false);

        ArrayList<GemstoneDTO> gemstoneDTOS = new ArrayList<GemstoneDTO>();
        GemstoneDTO gemstoneDTO = new GemstoneDTO();
        gemstoneDTO.setGemstoneId(45L);
        gemstoneDTOS.add(gemstoneDTO);
        gemstoneDTO = new GemstoneDTO();
        gemstoneDTO.setGemstoneId(47L);
        gemstoneDTOS.add(gemstoneDTO);
        product.setGemstones(gemstoneDTOS);

        ArrayList<MetalDTO> metalDTOS = new ArrayList<MetalDTO>();
        MetalDTO metalDTO = new MetalDTO();
        metalDTO.setMetalId(1L);
        metalDTOS.add(metalDTO);
        metalDTO = new MetalDTO();
        metalDTO.setMetalId(4L);
        metalDTOS.add(metalDTO);
        product.setMetals(metalDTOS);

        productController.updateProduct(product);
    }

    @Test
    public void getProduct() {
        System.out.println(productController.getProduct(24L));
    }

}
