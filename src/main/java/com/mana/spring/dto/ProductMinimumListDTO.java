package com.mana.spring.dto;

import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class ProductMinimumListDTO extends Pagination {

    private ArrayList<ProductMinimumDTO> productMinimumDTOS;

    public ArrayList<ProductMinimumDTO> getProductMinimumDTOS() {
        return productMinimumDTOS;
    }

    public void setProductMinimumDTOS(ArrayList<ProductMinimumDTO> productMinimumDTOS) {
        this.productMinimumDTOS = productMinimumDTOS;
    }

    @Override
    public String toString() {
        return "ProductMinimumListDTO{" +
                "productMinimumDTOS=" + productMinimumDTOS +
                '}';
    }
}
