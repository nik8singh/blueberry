import com.mana.spring.dto.JewelryTypeDTO;
import com.mana.spring.web.JewelryTypeController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJewelryType {

    @Autowired
    private JewelryTypeController jewelryTypeController;

    @Test
    public void getAllJewelryTypes() {
        List<JewelryTypeDTO> jewelryTypeDTOS = jewelryTypeController.getAllJewelryType();
        System.out.println();
        System.out.println(jewelryTypeDTOS);

        //call jewelryTypeController.getAllJewelryType()
    }

    @Test
    public void getActiveJewelryTypes() {
        List<JewelryTypeDTO> jewelryTypeDTOS = jewelryTypeController.getAllActiveJewelryTypes();

        for(JewelryTypeDTO jewelryType : jewelryTypeDTOS)
            Assert.assertTrue(jewelryType.isJewelryTypeActive());

        System.out.println();
        System.out.println(jewelryTypeDTOS);

        // call jewelryTypeController.getAllActiveJewelryTypes()
    }

//    @Test
//    public void getJewelryTypeProducts() {
//        JewelryTypeDTO jewelryTypeDTO = new JewelryTypeDTO();
//        jewelryTypeDTO.setJewelryTypeName("belts");
//        System.out.println();
//        System.out.println(jewelryTypeController.getJewelryTypeProducts(jewelryTypeDTO));
//
//        // call jewelryTypeController.getJewelryTypeProducts(jewelryTypeDTO)
//    }

    @Test
    public void addNewJewelryType() {

        JewelryTypeDTO jewelryTypeDTO = new JewelryTypeDTO();
        jewelryTypeDTO.setJewelryTypeName("TestingNewAdd");
        jewelryTypeDTO.setJewelryTypeDescription("Test test test");
        jewelryTypeDTO.setJewelryTypeActive(true);

        System.out.println();
        System.out.println(jewelryTypeController.saveJewelryType(jewelryTypeDTO));

        // call jewelryTypeController.saveJewelryType(jewelryTypeDTO)
    }

    @Test
    public void updateJewelryType(){
        JewelryTypeDTO jewelryTypeDTO = new JewelryTypeDTO();
        jewelryTypeDTO.setJewelryTypeId(14L);
        jewelryTypeDTO.setJewelryTypeName("TestingNewAdd");
        jewelryTypeDTO.setJewelryTypeDescription("Testing update to inactive");
        jewelryTypeDTO.setJewelryTypeActive(false);
        System.out.println();
        System.out.println(jewelryTypeController.updateJewelryType(jewelryTypeDTO));

        // call metalController.updateMetal(metalDTO)
    }



}