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

    @Autowired
    private ProductController productController;

    @Test
    public void addProductImage() {

        File file = new File("D:\\Desktop\\Logo.png");

        ImageDTO imageDTO = new ImageDTO();

        imageDTO.setFile(file);
        imageDTO.setImagePriority(2);
        imageDTO.setImageSiteLocation("product");
        imageDTO.setProductId(7L);

        imageController.saveImage(imageDTO);
    }

    @Test
    public void getProductImage() {

        ArrayList<ImageDTO> imageDTOS = productController.getProduct(7L).getImages();

        for (ImageDTO imageDTO: imageDTOS) {

            System.out.println("Image");
            System.out.println(imageDTO.getImageId());
            System.out.println(imageDTO.getImage());
            System.out.println(imageDTO.getProductId());
            System.out.println(imageDTO.getImagePriority());
            System.out.println(imageDTO.getImageSiteLocation());
        }
    }
    @Test
    public void removeProductImage() {

        ImageDTO imageDTO = new ImageDTO();

        imageDTO.setImagePriority(2);
        imageDTO.setProductId(7L);
        imageController.deleteImageByProductAndPriority(imageDTO);

    }

    @Test
    public void addSiteImage() {

        File file = new File("D:\\Desktop\\Logo.png");

        ImageDTO imageDTO = new ImageDTO();

        imageDTO.setFile(file);
        imageDTO.setImagePriority(1);
        imageDTO.setImageSiteLocation("Main page slider");

        imageController.saveImage(imageDTO);
    }

    @Test
    public void getSiteImage() {

        ArrayList<ImageDTO> imageDTOS = imageController.getSiteImage("Main page slider");

        for (ImageDTO imageDTO: imageDTOS) {

            System.out.println("Image: ");
            System.out.println(imageDTO.getImageId());
            System.out.println(imageDTO.getImage());
            System.out.println(imageDTO.getProductId());
            System.out.println(imageDTO.getImagePriority());
            System.out.println(imageDTO.getImageSiteLocation());
        }
    }




}
