package com.mana.spring.service.impl;

import com.mana.spring.dao.ImageDAO;
import com.mana.spring.domain.Image;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.ImageDTO;
import com.mana.spring.service.ImageService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDAO imageDAO;

    public ArrayList<Image> getProductImages(Product product) {
        ArrayList<Image> images = (ArrayList<Image>) imageDAO.getImagesByProduct(product.getProductId());

        return images;
    }

    public ArrayList<Image> getSiteImages(String siteLocation) {
        ArrayList<Image> images = (ArrayList<Image>) imageDAO.getImagesBySiteLocation(siteLocation);

        return images;
    }

    public void addImage(Image image) {
        imageDAO.saveImage(image);
    }

    public void updateImage(Image image) {
        // get from DB then update

        imageDAO.updateImage(image);
    }

    public void deleteImage(Image image) {
        if (!checkIfLastImage(image)) {
            callDelete(image);
        }
    }

    public void deleteImageByProductPriority(Image image) {
        if (!checkIfLastImage(image)) {
            ArrayList<Image> realImage = (ArrayList<Image>) imageDAO.getImageByProductPriority(image);
            callDelete(realImage.get(0));
        }
    }

    private void callDelete(Image image) {
        checkIfLastImage(image);
        imageDAO.deleteImage(image);
    }

    private boolean checkIfLastImage(Image image) {
        if (image.getProduct() != null) {
            Product product = new Product();
            product.setProductId(image.getProduct().getProductId());
            List list = getProductImages(product);
            System.out.println("List size: " + list.size());
            if (list.size() < 2)
                return true;
        }
        return false;
    }

}
