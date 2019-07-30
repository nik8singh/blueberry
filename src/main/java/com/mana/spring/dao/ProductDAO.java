package com.mana.spring.dao;

import com.mana.spring.domain.Product;

import java.util.List;

public interface ProductDAO {

    Product getProduct(Long productId, boolean requireListOtherData);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    List listAllProducts(int start, int end);

    List listFeaturedProducts();

    List listInStockProducts(int start, int end);

    List listNonPublishedProducts(int start, int end);

    List listPublishedProducts(int start, int end);

    List listOutOfStockProducts(int start, int end);

    long countAll();

    long countInStock(boolean inStock);

    long countPublished(boolean published);

}
