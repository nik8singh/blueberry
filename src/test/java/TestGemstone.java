import com.mana.spring.domain.Gemstone;
import com.mana.spring.web.GemstoneController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestGemstone {

    @Autowired
    private GemstoneController gemstoneController;

    @Test
    public void getAllInactiveGemstones() {
        System.out.println(gemstoneController.getAllInactiveGemstones(1));
    }

    @Test
    public void getActiveGemstones() {

        System.out.println(gemstoneController.getAllActiveGemstones(1));

    }

    @Test
    public void getGemstone() {
        System.out.println(gemstoneController.getGemstone("ruby"));
    }

    @Test
    public void getGemstoneProducts() {
        // Should fail because of lazy fetch type
        System.out.println(gemstoneController.getGemstone("ruby").getProducts());
    }


    @Test
    public void addNewGemstones() {
        Gemstone gemstone = new Gemstone();
        gemstone.setGemstoneName("Unit Test");
        gemstone.setGemstoneDescription("Testing unit test on 4/7/2019 8:21 PM");
        gemstone.setGemstoneActive(true);
        System.out.println(gemstoneController.saveGemstone(gemstone));
    }

    @Test
    public void updateGemstone() {
        Gemstone gemstone = new Gemstone();
        gemstone.setGemstoneId(51L);
        gemstone.setGemstoneName("Test Gem");
        gemstone.setGemstoneDescription("A Testing Gemstone");
        gemstone.setGemstoneActive(true);
        System.out.println();
        gemstoneController.updateGemstone(gemstone);
    }

    @Test
    public void deactivateGemstone() {
        System.out.println(gemstoneController.deactivateGemstone("Test inactive"));
    }


}