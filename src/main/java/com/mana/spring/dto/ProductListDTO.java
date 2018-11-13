package com.mana.spring.dto;

import com.mana.spring.domain.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductListDTO {

    private Set<Product> products = new HashSet<Product>(0);

    public ProductListDTO() {
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "\nProductListDTO{" +
                "\n\tproducts=" + products +
                '}';
    }
}
