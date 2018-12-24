package com.mana.spring.service;

import com.mana.spring.domain.Product;

import java.util.ArrayList;

public interface ProductService {

    ArrayList<Product> getProducts();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    ArrayList<Product> getAvailableProducts();

    Product getProduct(Long productId);
}

