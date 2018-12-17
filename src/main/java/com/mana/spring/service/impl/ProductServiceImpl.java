package com.mana.spring.service.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductDTO;
import com.mana.spring.service.ProductService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public ArrayList<ProductDTO> getProducts() {

        ArrayList<Product> products = (ArrayList<Product>) productDAO.listProduct();
        ArrayList<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        for (Product product : products) {
            productDTOs.add(ConverterDAOtoDTO.productDaoToDto(product));
        }

        return productDTOs;
    }

    public void addProduct(ProductDTO productDTO) {
        Product product = ConverterDTOtoDAO.productDtoToDao(productDTO);
        productDAO.saveProduct(product);
    }

    public void updateProduct(ProductDTO productDTO) {
        ProductDTO originalProductDTO = getProduct(productDTO.getProductId());
        BeanUtils.copyProperties(productDTO, originalProductDTO);

        Product modifiedProduct = ConverterDTOtoDAO.productDtoToDao(originalProductDTO);

        productDAO.updateProduct(modifiedProduct);
    }

    public ArrayList<ProductDTO> getAvailableProducts() {
        ArrayList<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        ArrayList<Product> products = (ArrayList<Product>) productDAO.listAvailableProducts();

        for (Product source : products) {
            ProductDTO target = ConverterDAOtoDTO.productDaoToDto(source);
            productDTOs.add(target);
        }

        return productDTOs;
    }

    public ProductDTO getProduct(Long productId) {
        Product product = productDAO.getProduct(productId);
        return ConverterDAOtoDTO.productDaoToDto(product);
    }
}
