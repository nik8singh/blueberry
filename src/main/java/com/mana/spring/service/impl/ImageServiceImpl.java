package com.mana.spring.service.impl;

import com.mana.spring.dao.ImageDAO;
import com.mana.spring.domain.Image;
import com.mana.spring.dto.ImageDTO;
import com.mana.spring.service.ImageService;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDAO imageDAO;

    public Image getImage(String imageName) {
        return imageDAO.getImage(imageName);
    }

    public ArrayList<Image> getImagesByPage(String pageName) {
        return (ArrayList<Image>) imageDAO.getImagesByPage(pageName);
    }

    public ArrayList<Image> getImagesByPanel(String panelName) {
        return (ArrayList<Image>) imageDAO.getImagesByPanel(panelName);
    }

    public void addImage(ImageDTO imageDTO) {
        imageDAO.saveImage(ConverterDTOtoDAO.imageDtoToDao(imageDTO));
    }

    public void updateImage(Image image) {
        imageDAO.updateImageName(image);
    }

    public boolean deleteImageByProductPriority(long productId, int imagePriority) {

        if (doesProductHaveMoreThanOneImage(productId)) {
            imageDAO.deleteImageByProductAndPriority(productId, imagePriority);
            return true;
        }

        return false;
    }

    public void deleteImageByPanelPriority(String panelName, int imagePriority) {
        imageDAO.deleteImageByPanelAndPriority(panelName, imagePriority);
    }

    private boolean doesProductHaveMoreThanOneImage(long productId) {

        long count = imageDAO.getProductImagesCount(productId);
        System.out.println("product images count: " + count );
        return count > 1;

    }
}
