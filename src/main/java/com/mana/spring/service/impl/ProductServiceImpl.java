package com.mana.spring.service.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.Product;
import com.mana.spring.domain.User;
import com.mana.spring.service.ProductService;
import com.mana.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public ArrayList<User> getProducts() {
        return (ArrayList<User>) productDAO.listProduct();
    }

    public void addProduct(Product product) {

        productDAO.saveProduct(product);
    }

    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    public void deleteProduct(Product product) {
        try {

            productDAO.deleteProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
