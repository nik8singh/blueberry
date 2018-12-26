package com.mana.spring.service.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.Product;
import com.mana.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public ArrayList<Product> getProducts() {

        ArrayList<Product> products = (ArrayList<Product>) productDAO.listProduct();
        return products;
    }

    public void addProduct(Product product) {
        productDAO.saveProduct(product);
    }

    public void updateProduct(Product product) {

        productDAO.updateProduct(product);
    }

    public ArrayList<Product> getAvailableProducts() {
        ArrayList<Product> products = (ArrayList<Product>) productDAO.listAvailableProducts();

        return products;
    }

    public Product getProduct(Long productId) {
        Product product = productDAO.getProduct(productId);
        return product;
    }

    public void deleteProduct(Product product) {

    }
}
