package com.mana.spring.service;

import com.mana.spring.domain.Product;
import com.mana.spring.domain.User;

import java.util.ArrayList;

public interface ProductService {

    ArrayList<User> getProducts();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);
}
