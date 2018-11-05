package com.mana.spring.dao;

import com.mana.spring.domain.Image;
import com.mana.spring.domain.Product;

import java.util.List;

public interface ImageDAO {

    void saveImage(Image image);
    void updateImage(Image image);
    void deleteImage(Image image);
    List getImagesBySiteLocation (String imageSiteLocation);
    List getImagesByProduct (Product product);

}
