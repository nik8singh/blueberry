package com.mana.spring.dao;

import com.mana.spring.domain.Product;

import java.util.List;

public interface ProductDAO {

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    List listProduct();
}
