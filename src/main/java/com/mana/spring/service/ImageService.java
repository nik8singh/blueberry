package com.mana.spring.service;

import com.mana.spring.domain.Image;

import java.util.ArrayList;

public interface ImageService {

    Image getImage(String imageName);

    ArrayList<Image> getImagesByPage(String pageName);

    ArrayList<Image> getImagesByPanel(String panelName);

    void addImage(Image image);

    void updateImage(Image image);

    void deleteImageByProductPriority(long productId, int imagePriority);

    void deleteImageByPanelPriority(String panelName, int imagePriority);

}
