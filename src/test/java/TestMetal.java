import com.mana.spring.domain.Metal;
import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.dto.MetalDTO;
import com.mana.spring.web.GemstoneController;
import com.mana.spring.web.MetalController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMetal {

    @Autowired
    private MetalController metalController;

    @Test
    public void getAllMetals() {
        List<MetalDTO> metalDTOS = metalController.getAllMetals();
        System.out.println();
        System.out.println(metalDTOS);

        //call metalController.getAllMetals()
    }

    @Test
    public void getActiveMetals() {
        List<MetalDTO> metals = metalController.getAllActiveMetals();

        for(MetalDTO metal : metals)
            Assert.assertTrue(metal.isMetalActive());

        System.out.println();
        System.out.println(metals);

        // call metalController.getAllActiveMetals()
    }

    @Test
    public void getMetalProduct() {
        MetalDTO metalDTO = new MetalDTO();
        metalDTO.setMetalName("gold");
        System.out.println();
        System.out.println(metalController.getMetalProducts(metalDTO));

        // call metalController.getMetalProducts(metalDTO)
    }

    @Test
    public void addNewGemstones() {

        MetalDTO metalDTO = new MetalDTO();
        metalDTO.setMetalName("TestingNewAdd");
        metalDTO.setMetalDescription("Test test test");
        metalDTO.setMetalActive(true);

        System.out.println();
        System.out.println(metalController.saveMetal(metalDTO));

        // call metalController.saveMetal(metalDTO)
    }

    @Test
    public void updateGemstone(){
        MetalDTO metalDTO = new MetalDTO();
        metalDTO.setMetalId(9L);
        metalDTO.setMetalName("TestingNewAdd");
        metalDTO.setMetalDescription("Testing update to inactive");
        metalDTO.setMetalActive(false);
        System.out.println();
        System.out.println(metalController.updateMetal(metalDTO));

        // call metalController.updateMetal(metalDTO)
    }



}