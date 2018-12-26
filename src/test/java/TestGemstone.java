import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.web.GemstoneController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestGemstone {

    @Autowired
    private GemstoneController gemstoneController;

//    @Test
//    public void getAllGemstones() {
//        List<GemstoneDTO> gems = gemstoneController.getAllGemstones();
//        System.out.println();
//        System.out.println(gems);
//
//        //call gemstoneController.getAllGemstones()
//    }
//
//    @Test
//    public void getActiveGemstones() {
//        List<GemstoneDTO> gems = gemstoneController.getAllActiveGemstones();
//
//        for(GemstoneDTO g : gems)
//            Assert.assertTrue(g.isGemstoneActive());
//
//        System.out.println();
//        System.out.println(gems);
//
//        // call gemstoneController.getAllActiveGemstones()
//    }
//
////    @Test
////    public void getGemstoneProduct() {
////        GemstoneDTO gemstoneDTO = new GemstoneDTO();
////        gemstoneDTO.setGemstoneName("ruby");
////        System.out.println();
////        System.out.println(gemstoneController.getGemstoneProducts(gemstoneDTO));
////
////        // call gemstoneController.getGemstoneProducts(gemstoneDTO)
////    }
//
//    @Test
//    public void addNewGemstones() {
//
//        GemstoneDTO gemstoneDTO = new GemstoneDTO();
//        gemstoneDTO.setGemstoneName("TestingNewAdd");
//        gemstoneDTO.setGemstoneDescription("Test test test");
//        gemstoneDTO.setGemstoneActive(true);
//
//        System.out.println();
//        System.out.println(gemstoneController.saveGemstone(gemstoneDTO));
//
//        // call gemstoneController.saveGemstone(gemstoneDTO)
//    }
//
//    @Test
//    public void updateGemstone(){
//        GemstoneDTO gemstoneDTO = new GemstoneDTO();
//        gemstoneDTO.setGemstoneId(24L);
//        gemstoneDTO.setGemstoneName("emerald");
//        gemstoneDTO.setGemstoneDescription("Green Gemstone");
//        gemstoneDTO.setGemstoneActive(true);
//        System.out.println();
//        gemstoneController.updateGemstone(gemstoneDTO);
//
////        System.out.println(gemstoneController.getGemstoneProducts(gemstoneDTO));
//
//        // call gemstoneController.updateGemstone(gemstoneDTO)
//    }



}