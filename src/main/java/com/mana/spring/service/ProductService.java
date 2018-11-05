package com.mana.spring.service;

import com.mana.spring.dto.ProductDTO;

import java.util.ArrayList;

public interface ProductService {

    ArrayList<ProductDTO> getProducts();

    void addProduct(ProductDTO productDTO);

    void updateProduct(ProductDTO productDTO);

    void deleteProduct(ProductDTO productDTO);

    ArrayList<ProductDTO> getAvailableProducts();

    ProductDTO getProduct(Long productId);
}

