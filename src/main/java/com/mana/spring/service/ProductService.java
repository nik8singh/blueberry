package com.mana.spring.service;

import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductListDTO;

public interface ProductService {

    ProductListDTO getAllProducts(int pageNumber);

    ProductListDTO getFeaturedProducts();

    ProductListDTO getInStockProducts(int pageNumber);

    ProductListDTO getNonPublishedProducts(int pageNumber);

    ProductListDTO getPublishedProducts(int pageNumber);

    ProductListDTO getOutOfStockProducts(int pageNumber);

    ProductListDTO getFilteredProducts(int pageNumber);

    void addProduct(Product product);

    void updateProduct(Product product);

    Product getProduct(Long productId);
}

