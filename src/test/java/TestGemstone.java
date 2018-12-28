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

        System.out.println(gemstoneController.getAllActiveGemstones(4));

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
        gemstone.setGemstoneName("HJDHFI");
        gemstone.setGemstoneDescription("Test HHH");
        gemstone.setGemstoneActive(true);
        System.out.println(gemstoneController.saveGemstone(gemstone));
    }

    @Test
    public void updateGemstone() {
        Gemstone gemstone = new Gemstone();
        gemstone.setGemstoneId(29L);
        gemstone.setGemstoneName("amber");
        gemstone.setGemstoneDescription("A Fire Gemstone");
        gemstone.setGemstoneActive(true);
        System.out.println();
        gemstoneController.updateGemstone(gemstone);
    }

    @Test
    public void deactivateGemstone() {
        System.out.println(gemstoneController.deactivateGemstone("tester"));
    }


}