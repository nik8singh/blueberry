package com.mana.spring.dao;

import com.mana.spring.domain.Image;

import java.util.List;

public interface ImageDAO {

    void saveImage(Image image);

    void updateImageName(Image image);

    void deleteImageByProductAndPriority(long productId, int imagePriority);

    void deleteImageByPanelAndPriority(String panelName, int imagePriority);

    Image getImage(String imageName);

    void updateImagePriorityBulk(long imageId, int priority);

    void deleteImageByPublicId(String publicId);

    List getImagesByPage(String pageName);

    List getImagesByPanel(String panelName);

    long getProductImagesCount(long productId);

    long getImageCounter();
}
