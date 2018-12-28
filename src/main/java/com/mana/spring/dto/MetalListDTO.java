package com.mana.spring.dto;

import com.mana.spring.domain.Metal;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class MetalListDTO extends Pagination {

    private ArrayList<Metal> metals;

    public MetalListDTO() {
    }

    public ArrayList<Metal> getMetals() {
        return metals;
    }

    public void setMetals(ArrayList<Metal> metals) {
        this.metals = metals;
    }

    @Override
    public String toString() {
        return "MetalListDTO{" +
                "\n\tmetals=" + metals +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}
