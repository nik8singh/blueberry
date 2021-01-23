import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.domain.Metal;
import com.mana.spring.dto.ProductRepoFilter;
import com.mana.spring.web.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestProduct {


    @Autowired
    private ProductController productController;

    @Test
    public void filter1() {
        System.out.println("=================TEST 1 START====================================");
        ProductRepoFilter productRepoFilter = new ProductRepoFilter();
        Set<Gemstone> gemstones = new HashSet<>();
        Gemstone gemstone = new Gemstone();
        gemstone.setGemstoneName("Ruby");
        gemstones.add(gemstone);
        gemstone = new Gemstone();
        gemstone.setGemstoneName("Emeralds");
        gemstones.add(gemstone);
        productRepoFilter.setProductGemstones(gemstones);

        Set<Metal> metals = new HashSet<>();
        Metal metal = new Metal();
        metal.setMetalName("Gold");
        metals.add(metal);
        metal = new Metal();
        metal.setMetalName("Silver");
        metals.add(metal);
        productRepoFilter.setProductMetals(metals);

        Set<JewelryType> jewelryTypes = new HashSet<>();
        JewelryType jewelryType = new JewelryType();
        jewelryType.setJewelryTypeId(8);
        jewelryTypes.add(jewelryType);
        jewelryType = new JewelryType();
        jewelryType.setJewelryTypeId(9);
        jewelryTypes.add(jewelryType);
        productRepoFilter.setProductJewelryTypes(jewelryTypes);

//        productRepoFilter.setMin(20);
//        productRepoFilter.setMax(200);

        productRepoFilter.setExactGT(false);
        productRepoFilter.setExactMT(true);

        productRepoFilter.setSortBy("newest");

        System.out.println(productController.getFilteredProducts(1, productRepoFilter));
        System.out.println("=================TEST 1 END====================================");
    }

    @Test
    public void filter2() {
        System.out.println("=================TEST 2 START====================================");
        ProductRepoFilter productRepoFilter = new ProductRepoFilter();
        Set<Gemstone> gemstones = new HashSet<>();
        Gemstone gemstone = new Gemstone();
        gemstone.setGemstoneName("Sunstone");
        gemstones.add(gemstone);
        productRepoFilter.setProductGemstones(gemstones);

        Set<Metal> metals = new HashSet<>();
        Metal metal = new Metal();
        metal.setMetalName("Silver Plated");
        metals.add(metal);
        productRepoFilter.setProductMetals(metals);


        System.out.println(productController.getFilteredProducts(1, productRepoFilter));
        System.out.println("=================TEST 2 END====================================");
    }

    @Test
    public void filter3() {
        System.out.println("=================TEST 3 START====================================");
        ProductRepoFilter productRepoFilter = new ProductRepoFilter();
        Set<Gemstone> gemstones = new HashSet<>();
        Gemstone gemstone = new Gemstone();
        gemstone.setGemstoneName("Sunstone");
        gemstones.add(gemstone);
        productRepoFilter.setProductGemstones(gemstones);

        System.out.println(productController.getFilteredProducts(1, productRepoFilter));
        System.out.println("=================TEST 3 END====================================");
    }

    @Test
    public void filter4() {
        System.out.println("=================TEST 4 START====================================");
        ProductRepoFilter productRepoFilter = new ProductRepoFilter();

        Set<Metal> metals = new HashSet<>();
        Metal metal = new Metal();
        metal.setMetalName("Silver Plated");
        metals.add(metal);
        productRepoFilter.setProductMetals(metals);

        System.out.println(productController.getFilteredProducts(1, productRepoFilter));
        System.out.println("=================TEST 4 END====================================");
    }

    @Test
    public void filter5() {
        System.out.println("=================TEST 5 START====================================");
        ProductRepoFilter productRepoFilter = new ProductRepoFilter();
        Set<Gemstone> gemstones = new HashSet<>();
        Gemstone gemstone = new Gemstone();
        gemstone.setGemstoneName("Sunstone");
        gemstones.add(gemstone);
        productRepoFilter.setProductGemstones(gemstones);

        Set<JewelryType> jewelryTypes = new HashSet<>();
        JewelryType jewelryType = new JewelryType();
        jewelryType.setJewelryTypeId(5);
        jewelryTypes.add(jewelryType);
        productRepoFilter.setProductJewelryTypes(jewelryTypes);

        System.out.println(productController.getFilteredProducts(1, productRepoFilter));
        System.out.println("=================TEST 5 END====================================");
    }

    @Test
    public void filter6() {
        System.out.println("=================TEST 6 START====================================");
        ProductRepoFilter productRepoFilter = new ProductRepoFilter();

        Set<JewelryType> jewelryTypes = new HashSet<>();
        JewelryType jewelryType = new JewelryType();
        jewelryType.setJewelryTypeId(4);
        jewelryTypes.add(jewelryType);
        jewelryType = new JewelryType();
        jewelryType.setJewelryTypeId(8);
        jewelryTypes.add(jewelryType);
        productRepoFilter.setProductJewelryTypes(jewelryTypes);

        System.out.println(productController.getFilteredProducts(1, productRepoFilter));
        System.out.println("=================TEST 6 END====================================");
    }

//    @Test
//    public void all(){
//        System.out.println(productController.getAllProducts(1));
//    }
//
//    @Test
//    public void addProduct() {
//        Product product = new Product();
//        product.setProductName("Unit Test");
//        product.setProductDescription("This is a unit test");
//        product.setProductWeight(10);
//        product.setWeightUnit("lbs");
//        product.setProductPrice(450);
//        product.setProductExpense(100);
//        product.setProductCurrency("USD");
//        product.setProductQuantity(5);
//        product.setProductQuantityType("Pieces");
//        product.setProductOnFeatured(false);
//        product.setProductPublished(false);
//        product.setProductAcceptCoupon(false);
//        JewelryType jewelryType = new JewelryType();
//        jewelryType.setJewelryTypeId(18);
//        product.setProductJewelryType(jewelryType);
//        Set<Gemstone> gemstones = new HashSet<>(0);
//        Gemstone gemstone = new Gemstone();
//        gemstone.setGemstoneId(27);
//        gemstones.add(gemstone);
//        gemstone = new Gemstone();
//        gemstone.setGemstoneId(31);
//        gemstones.add(gemstone);
//        product.setGemstones(gemstones);
//        Set<Metal> metals = new HashSet<>(0);
//        Metal metal = new Metal();
//        metal.setMetalId(1);
//        metals.add(metal);
//        metal = new Metal();
//        metal.setMetalId(4);
//        metals.add(metal);
//        product.setMetals(metals);
//        System.out.println(productController.saveProduct(product));
//    }
//
//
//    @Test
//    public void getProduct() {
//        System.out.println(productController.getProduct((long) 20));
//    }
//
//    @Test
//    public void updatePublishFlag() {
////        System.out.println(productController.updateProductPublish((long) 20,true));
//    }
//
//    @Test
//    public void imageTest() {
////        productController.authtest();
////        File dir = new File(rootPath + File.separator + "images");
//    }
//
//    @Test
//    public void updateProduct() {
//        Product product = new Product();
//        product.setProductId(20);
//        product.setProductName("Unit Test EDIT");
//        product.setProductDescription("This is a unit test");
//        product.setProductWeight(10);
//        product.setWeightUnit("lbs");
//        product.setProductPrice(450);
//        product.setProductExpense(100);
//        product.setProductCurrency("USD");
//        product.setProductQuantity(5);
//        product.setProductQuantityType("Pieces");
//        product.setProductOnFeatured(false);
//        product.setProductPublished(false);
//        product.setProductAcceptCoupon(false);
//        JewelryType jewelryType = new JewelryType();
//        jewelryType.setJewelryTypeId(18);
//        product.setProductJewelryType(jewelryType);
//        Set<Gemstone> gemstones = new HashSet<>(0);
//        Gemstone gemstone = new Gemstone();
//        gemstone.setGemstoneId(27);
//        gemstones.add(gemstone);
//        gemstone = new Gemstone();
//        gemstone.setGemstoneId(31);
//        gemstones.add(gemstone);
//        product.setGemstones(gemstones);
//        Set<Metal> metals = new HashSet<>(0);
//        Metal metal = new Metal();
//        metal.setMetalId(1);
//        metals.add(metal);
//        metal = new Metal();
//        metal.setMetalId(4);
//        metals.add(metal);
//        product.setMetals(metals);
//        System.out.println(productController.updateProduct(product));
//    }


}
