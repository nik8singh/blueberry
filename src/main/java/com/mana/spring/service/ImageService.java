package com.mana.spring.service;

import com.mana.spring.domain.Image;
import com.mana.spring.domain.Product;

import java.util.ArrayList;

public interface ImageService {

    ArrayList<Image> getProductImages(Product product);

    ArrayList<Image> getSiteImages(String siteLocation);

    void addImage(Image image);

    void updateImage(Image image);

    void deleteImage(Image image);

    void deleteImageByProductPriority(Image image);

}
