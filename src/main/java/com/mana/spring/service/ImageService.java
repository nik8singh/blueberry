package com.mana.spring.service;

import com.mana.spring.domain.Image;
import com.mana.spring.dto.ImageDTO;

import java.util.ArrayList;

public interface ImageService {

    Image getImage(String imageName);

    ArrayList<Image> getImagesByPage(String pageName);

    ArrayList<Image> getImagesByPanel(String panelName);

    void addImage(ImageDTO imageDTO);

    void updateImage(Image image);

    boolean deleteImageByProductPriority(long productId, int imagePriority);

    void deleteImageByPanelPriority(String panelName, int imagePriority);

}
