package com.mana.spring.service.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.*;
import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.dto.ImageDTO;
import com.mana.spring.dto.MetalDTO;
import com.mana.spring.dto.ProductDTO;
import com.mana.spring.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public ArrayList<ProductDTO> getProducts() {

        ArrayList<Product> products = (ArrayList<Product>) productDAO.listProduct();
        ArrayList<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        for (Product product : products) {
            productDTOs.add(daoToDto(product));
        }

        return productDTOs;
    }

    public void addProduct(ProductDTO productDTO) {
        Product product = dtoToDao(productDTO);
        productDAO.saveProduct(product);
    }

    public void updateProduct(ProductDTO productDTO) {
        ProductDTO originalProductDTO = getProduct(productDTO.getProductId());
        BeanUtils.copyProperties(productDTO, originalProductDTO);
//        Product originalProduct = dtoToDao(originalProductDTO);

        Product modifiedProduct = dtoToDao(originalProductDTO);

//        BeanUtils.copyProperties(modifiedProduct, originalProduct);

        productDAO.updateProduct(modifiedProduct);
    }

//    public void deleteProduct(ProductDTO productDTO) {
//        try {
//            Product product = dtoToDao(productDTO);
//            productDAO.deleteProduct(product);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public ArrayList<ProductDTO> getAvailableProducts() {
        ArrayList<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        ArrayList<Product> products = (ArrayList<Product>) productDAO.listAvailableProducts();

        for (Product source : products) {
            ProductDTO target = daoToDto(source);
            productDTOs.add(target);
        }

        return productDTOs;
    }

    public ProductDTO getProduct(Long productId) {
        Product product = productDAO.getProduct(productId);
        return daoToDto(product);
    }

    private ProductDTO daoToDto(Product product) {

        ArrayList<GemstoneDTO> gemstoneDTOs = new ArrayList<GemstoneDTO>();
        ArrayList<MetalDTO> metalDTOs = new ArrayList<MetalDTO>();
        ArrayList<ImageDTO> imageDTOs = new ArrayList<ImageDTO>();

        Set<Gemstone> sourceGemstones = product.getGemstones();
        Set<Metal> sourceMetals = product.getMetals();
        Set<Image> sourceImages = product.getImages();

        // to copy to
        ProductDTO target = new ProductDTO();

        BeanUtils.copyProperties(product, target);

        target.setJewelryTypeName(product.getProductJewelryType().getJewelryTypeName());

        for (Gemstone sourceGem : sourceGemstones) {

            GemstoneDTO targetGem = new GemstoneDTO();
            System.out.println("\n\nSOURCE: " + sourceGem.getGemstoneName() + "\n ==================================================\n");
            BeanUtils.copyProperties(sourceGem, targetGem);
            gemstoneDTOs.add(targetGem);
        }

        for (Metal sourceMetal : sourceMetals) {
            MetalDTO targetMetal = new MetalDTO();
            BeanUtils.copyProperties(sourceMetal, targetMetal);
            metalDTOs.add(targetMetal);
        }

        for (Image sourceImage : sourceImages) {
            ImageDTO targetImage = new ImageDTO();
            BeanUtils.copyProperties(sourceImage, targetImage);
            targetImage.setProductId(sourceImage.getProduct().getProductId());
            imageDTOs.add(targetImage);
        }

        target.setGemstones(gemstoneDTOs);
        target.setMetals(metalDTOs);
        target.setImages(imageDTOs);

        return target;

    }

    private Product dtoToDao(ProductDTO productDTO) {

        Set<Gemstone> gemstones = new HashSet<Gemstone>();
        Set<Metal> metals = new HashSet<Metal>();
        Set<Image> images = new HashSet<Image>();
        JewelryType jewelryType = new JewelryType();

        ArrayList<GemstoneDTO> gemstoneDTOS = productDTO.getGemstones();
        ArrayList<MetalDTO> metalDTOS = productDTO.getMetals();
        ArrayList<ImageDTO> imageDTOS = productDTO.getImages();

        // to copy to
        Product target = new Product();

        BeanUtils.copyProperties(productDTO, target);

        BeanUtils.copyProperties(productDTO, jewelryType);
        target.setProductJewelryType(jewelryType);

        if (gemstoneDTOS != null)
            for (GemstoneDTO gemstoneDTO : gemstoneDTOS) {

                Gemstone targetGem = new Gemstone();
                BeanUtils.copyProperties(gemstoneDTO, targetGem);
                gemstones.add(targetGem);
            }

        if (metalDTOS != null)
            for (MetalDTO metalDTO : metalDTOS) {
                Metal targetMetal = new Metal();
                BeanUtils.copyProperties(metalDTO, targetMetal);
                metals.add(targetMetal);
            }

        if (imageDTOS != null)
            for (ImageDTO imageDTO : imageDTOS) {
                Image targetImage = new Image();
                BeanUtils.copyProperties(imageDTO, targetImage);
                Product imageProduct = new Product();
                imageProduct.setProductId(imageDTO.getProductId());
                targetImage.setProduct(imageProduct);
                images.add(targetImage);
            }

        target.setGemstones(gemstones);
        target.setMetals(metals);
        target.setImages(images);

        return target;

    }

    private Product copyWithoutNulls(Product source, Product target) {

//        if (source.getProductName() != null)
//            target.setProductName(source.getProductName());
//
//        if (source.getProductDescription() != null)
//            target.setProductDescription(source.getProductDescription());
//
//        if (source.getProductJewelryType() != null)
//            target.setProductJewelryType(source.getProductJewelryType());
//
//        if (source.getProductWeight() != 0.0d)
//            target.setProductWeight(source.getProductWeight());
//
//        if (source.getWeightUnit() != null)
//            target.setWeightUnit(source.getWeightUnit());
//
//        if (source.getProductPrice() != 0.0d)
//            target.setProductPrice(source.getProductPrice());
//
//        if (source.getProductCurrency() != null)
//            target.setProductCurrency(source.getProductCurrency());
//
//        if (source.getProductSku() != null)
//            target.setProductSku(source.getProductSku());
//
//        if (source.getProductQuantity() != 0)
//            target.setProductQuantity(source.getProductQuantity());
//
//        if (source.getProductQuantityType() != null)
//            target.setProductQuantityType(source.getProductQuantityType());
//
//        if (source.isProductOnFeatured() != null)
//
//        if (source.getProductPublished() != null) ;
//
//        if (source.getProductExpense() != null) ;
//
//        if (source.getProductAcceptCoupon() != null) ;


        return target;
    }
}
