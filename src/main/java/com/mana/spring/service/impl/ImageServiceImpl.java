package com.mana.spring.service.impl;

import com.mana.spring.dao.ImageDAO;
import com.mana.spring.domain.Image;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.ImageDTO;
import com.mana.spring.service.ImageService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Convert;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDAO imageDAO;

    public ArrayList<ImageDTO> getProductImages(Product product) {
        ArrayList<Image> images = (ArrayList<Image>) imageDAO.getImagesByProduct(product.getProductId());
        ArrayList<ImageDTO> imageDTOS = new ArrayList<ImageDTO>();

        for (Image image : images) {
            imageDTOS.add(ConverterDAOtoDTO.imageDaoToDto(image));
        }

        return imageDTOS;
    }

    public ArrayList<ImageDTO> getSiteImages(String siteLocation) {
        ArrayList<Image> images = (ArrayList<Image>) imageDAO.getImagesBySiteLocation(siteLocation);
        ArrayList<ImageDTO> imageDTOS = new ArrayList<ImageDTO>();

        for (Image image : images) {
            imageDTOS.add(ConverterDAOtoDTO.imageDaoToDto(image));
        }
        return imageDTOS;
    }

    public void addImage(ImageDTO imageDTO) {
        Image image = ConverterDTOtoDAO.imageDtoToDao(imageDTO);
        imageDAO.saveImage(image);
    }

    public void updateImage(ImageDTO imageDTO) {
        Image image = ConverterDTOtoDAO.imageDtoToDao(imageDTO);
        imageDAO.updateImage(image);
    }

    public void deleteImage(ImageDTO imageDTO) {
        if (!checkIfLastImage(imageDTO)) {
            callDelete(imageDTO);
        }
    }

    public void deleteImageByProductPriority(ImageDTO imageDTO) {
        if (!checkIfLastImage(imageDTO)) {
            Image image = ConverterDTOtoDAO.imageDtoToDao(imageDTO);
            ArrayList<Image> realImage = (ArrayList<Image>) imageDAO.getImageByProductPriority(image);
            callDelete(ConverterDAOtoDTO.imageDaoToDto(realImage.get(0)));
        }
    }

    private void callDelete(ImageDTO imageDTO) {
        checkIfLastImage(imageDTO);
        Image image = ConverterDTOtoDAO.imageDtoToDao(imageDTO);
        imageDAO.deleteImage(image);
    }

    private boolean checkIfLastImage(ImageDTO imageDTO) {
        if (imageDTO.getProductId() != 0) {
            Product product = new Product();
            product.setProductId(imageDTO.getProductId());
            List list = getProductImages(product);
            System.out.println("List size: " + list.size());
            if (list.size() < 2)
                return true;
        }
        return false;
    }

}
