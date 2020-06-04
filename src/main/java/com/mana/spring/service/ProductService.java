package com.mana.spring.service;

import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductDTO;
import com.mana.spring.dto.ProductListDTO;
import com.mana.spring.dto.ProductRepoFilter;

public interface ProductService {

    ProductListDTO getAllProducts(int pageNumber);

    ProductListDTO getFeaturedProducts();

    ProductListDTO getInStockProducts(int pageNumber);

    ProductListDTO getNonPublishedProducts(int pageNumber);

    ProductListDTO getPublishedProducts(int pageNumber);

    ProductListDTO getOutOfStockProducts(int pageNumber);

    ProductListDTO getFilteredProducts(int pageNumber, ProductRepoFilter repoFilter);

    Product addProduct(Product product);

    void updateProduct(Product product);

    void updateProductPublish(Long productId, boolean publishFlag);

    ProductDTO getProduct(Long productId);

    Product getProductByName(String name);

    ProductListDTO partialSearch(String searchWord);
}

