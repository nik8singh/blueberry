import com.mana.spring.domain.Image;
import com.mana.spring.dto.ImageDTO;
import com.mana.spring.web.ImageController;
import com.mana.spring.web.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.ArrayList;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestImage {

    @Autowired
    private ImageController imageController;

    @Test
    public void addProductImage() {

        File file = new File("\\\\ahs\\ahsfiles\\Users\\AHS-CO\\Nikhil.Singh\\My Pictures\\Goku_91.jpg");

        ImageDTO imageDTO = new ImageDTO();

        imageDTO.setFile(file);
        imageDTO.setImagePriority(2);
        imageDTO.setImageName("tester many gems image from left side");
        imageDTO.setProductId(7L);

        imageController.saveImage(imageDTO);
    }


    @Test
    public void addPanelImage() {

        File file = new File("\\\\ahs\\ahsfiles\\Users\\AHS-CO\\Nikhil.Singh\\My Pictures\\Halloween.jpg");

        ImageDTO imageDTO = new ImageDTO();

        imageDTO.setFile(file);
        imageDTO.setImagePriority(1);
        imageDTO.setImageName("Info image");
        imageDTO.setImagePanelName("Information");
        imageDTO.setImagePageName("Home Page");

        imageController.saveImage(imageDTO);
    }

    @Test
    public void getImage() {
        System.out.println(imageController.getImage("Scooby image for home page"));
    }

    @Test
    public void getAllPanelImage() {
        System.out.println(imageController.getPanelImages("Home Page Slider"));
    }

    @Test
    public void getPageImage() {
        System.out.println(imageController.getPageImages("Home Page"));
    }

    @Test
    public void updateImageName() {

        Image image = new Image();

        image.setImageId(1L);
        image.setImageName("Gem image while wearing");

        imageController.updateImage(image);
    }

    @Test
    public void deleteProductImage() {
        imageController.deleteImageByProductAndPriority(7L,1);
    }

    @Test
    public void deletePanelImage() {
        imageController.deleteImageByPanelAndPriority("Home Page Slider",1);
    }




}
