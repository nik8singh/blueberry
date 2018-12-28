import com.mana.spring.domain.JewelryType;
import com.mana.spring.web.JewelryTypeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJewelryType {

    @Autowired
    private JewelryTypeController jewelryTypeController;

    @Test
    public void getAllInactiveJewelryTypes() {
        System.out.println(jewelryTypeController.getAllInactiveJewelryTypes(1));
    }

    @Test
    public void getActiveJewelryTypes() {
        System.out.println(jewelryTypeController.getAllActiveJewelryTypes(1));
    }

    @Test
    public void getJewelryType() {
        System.out.println(jewelryTypeController.getJewelryType("necklaces"));
    }

    @Test
    public void getJewelryTypeProducts() {
        // Should fail because of lazy fetch type
        System.out.println(jewelryTypeController.getJewelryType("necklaces").getProducts());
    }

    @Test
    public void addNewJewelryType() {
        JewelryType jewelryType = new JewelryType();
        jewelryType.setJewelryTypeName("jewelryTypeGHGIGI");
        jewelryType.setJewelryTypeDescription("Test jewelryType GRGSD");
        jewelryType.setJewelryTypeActive(true);
        System.out.println(jewelryTypeController.saveJewelryType(jewelryType));
    }

    @Test
    public void updateJewelryType() {
        JewelryType jewelryType = new JewelryType();
        jewelryType.setJewelryTypeId(8L);
        jewelryType.setJewelryTypeName("necklaces");
        jewelryType.setJewelryTypeDescription("Rings for neck");
        jewelryType.setJewelryTypeActive(true);
        jewelryTypeController.updateJewelryType(jewelryType);
    }

    @Test
    public void deactivateJewelryType() {
        System.out.println(jewelryTypeController.deactivateJewelryType("TestingNewAdd"));
    }


}