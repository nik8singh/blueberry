package com.mana.spring.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mana.spring.dao.ImageDAO;
import com.mana.spring.domain.Image;
import com.mana.spring.dto.ImageDTO;
import com.mana.spring.dto.ImageDTOConverter;
import com.mana.spring.dto.ImageListDTO;
import com.mana.spring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDAO imageDAO;

//    private @Value("${upload-dir}") String uploadDirectory;

    public Image getImage(String imageName) {
        return imageDAO.getImage(imageName);
    }

    public ArrayList<Image> getImagesByPage(String pageName) {
        return (ArrayList<Image>) imageDAO.getImagesByPage(pageName);
    }

    public ArrayList<Image> getImagesByPanel(String panelName) {
        return (ArrayList<Image>) imageDAO.getImagesByPanel(panelName);
    }

    public ImageDTO addProductImage(MultipartFile multipartFile, long id) {

        ImageDTO imageDTO = new ImageDTO();
        Map upload = null;

        Map config = new HashMap();
        config.put("cloud_name", "dz5yh8qj4");
        config.put("api_key", "155244519897888");
        config.put("api_secret", "hj6zfrFmiCyB3XPBRhp77UAb5eQ");
        Cloudinary cloudinary = new Cloudinary(config);

        try {
            upload = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.asMap(
                    "folder", "uat/product/",
                    "quality_analysis", true,
                    "tags", "product_" + id
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageDTO.setProductId(id);

        upload.forEach((k, v) -> {
                    switch (k.toString()) {
                        case "public_id":
                            imageDTO.setImage_public_id(v.toString());
                            break;
                        case "tags":
                            imageDTO.setImage_tags(v.toString());
                            break;
                        case "quality_analysis":
                            String value = v.toString();
                            imageDTO.setImage_quality(Float.parseFloat(value.substring(value.lastIndexOf("=") + 1, value.lastIndexOf("}"))));
                            break;
                        case "width":
                            imageDTO.setImage_width(Float.parseFloat(v.toString()));
                            break;
                        case "height":
                            imageDTO.setImage_height(Float.parseFloat(v.toString()));
                            break;
                        case "format":
                            imageDTO.setImage_format(v.toString());
                            break;
                        case "secure_url":
                            imageDTO.setImage_secure_url(v.toString());
                            break;
                        case "backup_url":
                            imageDTO.setImage_backup_url(v.toString());
                            break;
                        default:
                    }
                }
        );

        imageDTO.setImagePriority((int) (imageDAO.getProductImagesCount(imageDTO.getProductId()) + 1));
        long newImgId = imageDAO.saveImage(ImageDTOConverter.convertToDAO(imageDTO));
        imageDTO.setImageId(newImgId);
        System.out.println(imageDTO);
        return imageDTO;
    }

    public void updateImage(Image image) {
        imageDAO.updateImageName(image);
    }

    @Override
    public void updateImagePriorityBulk(ImageListDTO imageListDTO) {

        for (ImageDTO imageDTO : imageListDTO.getImageDtos()) {
            imageDAO.updateImagePriorityBulk(imageDTO.getImageId(), imageDTO.getImagePriority());
        }

    }

    @Override
    public void deleteImageByPublicId(String publicId) {
        Map config = new HashMap();
        config.put("cloud_name", "dz5yh8qj4");
        config.put("api_key", "155244519897888");
        config.put("api_secret", "hj6zfrFmiCyB3XPBRhp77UAb5eQ");
        Cloudinary cloudinary = new Cloudinary(config);

        try {
            cloudinary.uploader().destroy(publicId, ObjectUtils.asMap(
                    "invalidate", true
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageDAO.deleteImageByPublicId(publicId);
    }


    public boolean deleteImageByProductPriority(long productId, int imagePriority) {

        if (doesProductHaveMoreThanOneImage(productId)) {
            imageDAO.deleteImageByProductAndPriority(productId, imagePriority);
            return true;
        }

        return false;
    }

    public void deleteImageByPanelPriority(String panelName, int imagePriority) {
        imageDAO.deleteImageByPanelAndPriority(panelName, imagePriority);
    }

    @Override
    public long getImageCounter() {
        return imageDAO.getImageCounter();
    }

    private boolean doesProductHaveMoreThanOneImage(long productId) {

        long count = imageDAO.getProductImagesCount(productId);
        System.out.println("product images count: " + count);
        return count > 1;

    }
}
