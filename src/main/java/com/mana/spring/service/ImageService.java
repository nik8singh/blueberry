package com.mana.spring.service;

import com.mana.spring.domain.Image;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.ImageDTO;

import java.util.ArrayList;

public interface ImageService {

    ArrayList<ImageDTO> getProductImages(Product product);
    ArrayList<ImageDTO> getSiteImages(String siteLocation);
    void addImage(ImageDTO imageDTO);
    void updateImage(ImageDTO imageDTO);
    void deleteImage(ImageDTO imageDTO);
    void deleteImageByProductPriority(ImageDTO imageDTO);

}
