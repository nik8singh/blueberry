package com.mana.spring.dto;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.domain.Metal;
import com.mana.spring.util.Pagination;

import java.util.Set;

public class ProductRepoFilter extends Pagination {

    private JewelryType productJewelryTypes;
    private Set<Gemstone> productGemstones;
    private Set<Metal> productMetals;
    private String sortOrder;
    private String sortByr;

    public ProductRepoFilter() {
    }

    public JewelryType getProductJewelryTypes() {
        return productJewelryTypes;
    }

    public void setProductJewelryTypes(JewelryType productJewelryTypes) {
        this.productJewelryTypes = productJewelryTypes;
    }

    public Set<Gemstone> getProductGemstones() {
        return productGemstones;
    }

    public void setProductGemstones(Set<Gemstone> productGemstones) {
        this.productGemstones = productGemstones;
    }

    public Set<Metal> getProductMetals() {
        return productMetals;
    }

    public void setProductMetals(Set<Metal> productMetals) {
        this.productMetals = productMetals;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortByr() {
        return sortByr;
    }

    public void setSortByr(String sortByr) {
        this.sortByr = sortByr;
    }

    @Override
    public String toString() {
        return "ProductRepoFilter{" +
                "productJewelryTypes=" + productJewelryTypes.getJewelryTypeId() +
                ", productGemstones=" + productGemstones +
                ", productMetals=" + productMetals +
                '}';
    }
}
