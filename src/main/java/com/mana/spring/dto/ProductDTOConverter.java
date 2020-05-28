package com.mana.spring.dto;

import com.mana.spring.domain.Product;

import java.util.ArrayList;

public class ProductDTOConverter {
    public static ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setProductWeight(product.getProductWeight());
        productDTO.setWeightUnit(product.getWeightUnit());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductSku(product.getProductSku());
        productDTO.setProductCurrency(product.getProductCurrency());
        productDTO.setProductQuantity(product.getProductQuantity());
        productDTO.setProductQuantityType(product.getProductQuantityType());
        productDTO.setProductOnFeatured(product.isProductOnFeatured());
        productDTO.setProductPublished(product.isProductPublished());
        productDTO.setProductExpense(product.getProductExpense());
        productDTO.setProductAcceptCoupon(product.isProductAcceptCoupon());

        JewelryTypeDTO jewelryTypeDTO = JewelryTypeDTOConverter.convertToDTO(product.getProductJewelryType());
        productDTO.setJewelryType(jewelryTypeDTO);

        GemstoneListDTO gemstoneListDTO = new GemstoneListDTO();
        gemstoneListDTO.setGemstones(new ArrayList<>(product.getGemstones()));
        productDTO.setGemstones(gemstoneListDTO.getGemstones());

        MetalListDTO metalListDTO = new MetalListDTO();
        metalListDTO.setMetals(new ArrayList<>(product.getMetals()));
        productDTO.setMetals(metalListDTO.getMetalsDtos());

        ImageListDTO imageListDTO = new ImageListDTO();
        imageListDTO.setImages(new ArrayList<>(product.getImages()));
        productDTO.setImages(imageListDTO.getImageDtos());
        productDTO.setImageListDTO(imageListDTO);

        return productDTO;
    }

}
