package com.mana.spring.service;

import com.mana.spring.domain.Image;
import com.mana.spring.dto.ImageDTO;
import com.mana.spring.dto.ImageListDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface ImageService {

    Image getImage(String imageName);

    ArrayList<Image> getImagesByPage(String pageName);

    ArrayList<Image> getImagesByPanel(String panelName);

    ImageDTO addProductImage(MultipartFile multipartFile, long id);

    void updateImage(Image image);

    void updateImagePriorityBulk(ImageListDTO imageListDTO);

    void deleteImageByPublicId(String publicId);

    boolean deleteImageByProductPriority(long productId, int imagePriority);

    void deleteImageByPanelPriority(String panelName, int imagePriority);

    long getImageCounter();


}
