package com.mana.spring.dto;

import com.mana.spring.domain.Product;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class ProductListDTO extends Pagination {

    private ArrayList<ProductDTO> productsDtos;

    private String sort;

    public ProductListDTO() {
        productsDtos = new ArrayList<>();
    }

    public ArrayList<ProductDTO> getProductsDtos() {
        return productsDtos;
    }

    public void setProductsDtos(ArrayList<ProductDTO> productsDtos) {
        this.productsDtos = productsDtos;
    }

    public void setProducts(ArrayList<Product> products) {
        for (Product p : products) {
            this.productsDtos.add(ProductDTOConverter.convertToDTO(p));
        }
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
                "\nproducts=" + productsDtos +
                "\nsort='" + sort + '\'' +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}