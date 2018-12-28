package com.mana.spring.service.impl;

import com.mana.spring.dao.ImageDAO;
import com.mana.spring.domain.Image;
import com.mana.spring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDAO imageDAO;

    public Image getImage(String imageName) {
        return null;
    }

    public ArrayList<Image> getImagesByPage(String pageName) {
        return null;
    }

    public ArrayList<Image> getImagesByPanel(String panelName) {
        return null;
    }

    public void addImage(Image image) {

    }

    public void updateImage(Image image) {

    }

    public void deleteImageByProductPriority(long productId, int imagePriority) {

    }

    public void deleteImageByPanelPriority(String panelName, int imagePriority) {

    }

    private boolean doesProductHaveMoreThanOneImage(long productId) {

        long count = imageDAO.getProductImagesCount(productId);
        System.out.println("product images count: " + count);
        return count < 2;

    }
}
