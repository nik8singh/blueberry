package com.mana.spring.service.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.Metal;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.dto.MetalDTO;
import com.mana.spring.dto.ProductDTO;
import com.mana.spring.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
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
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productDAO.saveProduct(product);
    }

    public void updateProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productDAO.updateProduct(product);
    }

    public void deleteProduct(ProductDTO productDTO) {
        try {
            Product product = new Product();
            BeanUtils.copyProperties(productDTO, product);
            productDAO.deleteProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProductDTO> getAvailableProducts() {
        ArrayList<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        ArrayList<Product> products = (ArrayList<Product>) productDAO.listAvailableProducts();

        for (Product source : products) {
            ProductDTO target = new ProductDTO();
            BeanUtils.copyProperties(source, target);
            productDTOs.add(target);
        }

        return productDTOs;
    }

    public ProductDTO getProduct(Long productId) {
        Product product = productDAO.getProduct(productId);
        return daoToDto(product);
    }

    public ProductDTO daoToDto(Product product) {

        ArrayList<GemstoneDTO> gemstoneDTOs = new ArrayList<GemstoneDTO>();
        ArrayList<MetalDTO> metalDTOs = new ArrayList<MetalDTO>();

        Set<Gemstone> sourceGemstones =  product.getGemstones();
        Set<Metal> sourceMetals = product.getMetals();

        // to copy to
        ProductDTO target = new ProductDTO();

        BeanUtils.copyProperties(product, target);

        target.setJewelryTypeName(product.getProductJewelryType().getJewelryTypeName());

        for (Gemstone sourceGem : sourceGemstones) {

            GemstoneDTO targetGem = new GemstoneDTO();
            System.out.println("\n\nSOURCE: "+sourceGem.getGemstoneName() + "\n ==================================================\n");
            BeanUtils.copyProperties(sourceGem, targetGem);
            gemstoneDTOs.add(targetGem);
        }

        for (Metal sourceMetal : sourceMetals) {
            MetalDTO targetMetal = new MetalDTO();
            BeanUtils.copyProperties(sourceMetal, targetMetal);
            metalDTOs.add(targetMetal);
        }

        target.setGemstones(gemstoneDTOs);
        target.setMetals(metalDTOs);

        return target;

    }
}
