package com.mana.spring.service.impl;

import com.mana.spring.dao.ImageDAO;
import com.mana.spring.domain.Image;
import com.mana.spring.domain.Product;
import com.mana.spring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;

public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDAO imageDAO;

    public ArrayList<Image> getProductImages(Product product) {
        return (ArrayList<Image>) imageDAO.getImagesByProduct(product);
    }

    public ArrayList<Image> getSiteImages(String siteLocation) {
        return (ArrayList<Image>) imageDAO.getImagesBySiteLocation(siteLocation);
    }

    public void addImage(Image image) {

        String filename = image.getProduct().getProductId().toString() + image.getImagePriority();

        String filePath = new File("").getAbsolutePath();
        for (int i = filePath.length() - 1, j = 0; i >= 0; i--) {
            if (filePath.charAt(i) == '\\')
                if (++j == 2) {
                    filePath = filePath.substring(0, i);
                    filePath += "\\productImages";
                    i = -1;
                }
        }

        image.setImageServerLocation(filePath);

        imageDAO.saveImage(image);

    }

    public void updateImage(Image image) {
        imageDAO.updateImage(image);
    }

    public void deleteImage(Image image) {
        imageDAO.deleteImage(image);
    }
}
