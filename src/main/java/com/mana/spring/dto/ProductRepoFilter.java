package com.mana.spring.dto;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.domain.Metal;
import com.mana.spring.util.Pagination;

import java.util.Set;

public class ProductRepoFilter extends Pagination {

    private Set<JewelryType> productJewelryTypes;
    private Set<Gemstone> productGemstones;
    private Set<Metal> productMetals;
    /**
     * Available sorts - pricelowToHigh, priceHighToLow, newest, relevance
     **/
    private String sortBy = "relevance";
    private double min = 0;
    private double max = -1;

    public ProductRepoFilter() {
    }

    public Set<JewelryType> getProductJewelryTypes() {
        return productJewelryTypes;
    }

    public void setProductJewelryTypes(Set<JewelryType> productJewelryTypes) {
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

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public String toString() {
        return "\nProductRepoFilter{" +
                "\nproductJewelryTypes=" + productJewelryTypes +
                "\n productGemstones=" + productGemstones +
                "\n productMetals=" + productMetals +
                "\n sortBy='" + sortBy + '\'' +
                "\n min=" + min +
                "\n max=" + max +
                "\n count=" + count +
                "\n totalPages=" + totalPages +
                "\n currentPageNumber=" + currentPageNumber +
                '}';
    }
}
