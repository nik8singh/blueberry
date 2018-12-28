import com.mana.spring.domain.Metal;
import com.mana.spring.web.MetalController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMetal {

    @Autowired
    private MetalController metalController;

    @Test
    public void getAllInactiveMetals() {
        System.out.println(metalController.getAllInactiveMetals(1));
    }

    @Test
    public void getActiveMetals() {
        System.out.println(metalController.getAllActiveMetals(2));
    }

    @Test
    public void getMetal() {
        System.out.println(metalController.getMetal("Gold"));
    }

    @Test
    public void getMetalProducts() {
        // Should fail because of lazy fetch type
        System.out.println(metalController.getMetal("Gold").getProducts());
    }


    @Test
    public void addNewMetal() {
        Metal metal = new Metal();
        metal.setMetalName("MetalGHGIGI");
        metal.setMetalDescription("Test HHH");
        metal.setMetalActive(true);
        System.out.println(metalController.saveMetal(metal));
    }

    @Test
    public void updateMetal() {
        Metal metal = new Metal();
        metal.setMetalId(4L);
        metal.setMetalName("silver");
        metal.setMetalDescription("grey sparkly thing");
        metal.setMetalActive(true);
        metalController.updateMetal(metal);
    }

    @Test
    public void deactivateMetal() {
        System.out.println(metalController.deactivateMetal("test"));
    }


}