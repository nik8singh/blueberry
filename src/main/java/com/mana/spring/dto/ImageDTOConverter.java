package com.mana.spring.dto;

import com.mana.spring.domain.Image;
import com.mana.spring.domain.Product;
import org.springframework.beans.BeanUtils;

public class ImageDTOConverter {
    public static ImageDTO convertToDTO(Image image) {
        // to copy to
        ImageDTO target = new ImageDTO();
        BeanUtils.copyProperties(image, target);

        if (image.getProduct() != null) {
            target.setProductId(image.getProduct().getProductId());
        }

        return target;
    }

    public static Image convertToDAO(ImageDTO imageDTO) {
        // to copy to
        Image target = new Image();
        BeanUtils.copyProperties(imageDTO, target);

        if (imageDTO.getProductId() != 0) {
            Product product = new Product();
            product.setProductId(imageDTO.getProductId());
            target.setProduct(product);
        }

        return target;
    }
}
