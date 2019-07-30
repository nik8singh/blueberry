package com.mana.spring.dto;

import com.mana.spring.domain.Product;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class ProductListDTO extends Pagination {

    private ArrayList<Product> products;

    private String sort;

    public ProductListDTO() {
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "\nProductListDTO{" +
                "\nproducts=" + products +
                "\nsort='" + sort + '\'' +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}