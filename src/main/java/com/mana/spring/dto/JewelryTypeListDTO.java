package com.mana.spring.dto;

import com.mana.spring.domain.JewelryType;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class JewelryTypeListDTO extends Pagination {

    ArrayList<JewelryType> jewelryTypes;

    public JewelryTypeListDTO() {
    }

    public ArrayList<JewelryType> getJewelryTypes() {
        return jewelryTypes;
    }

    public void setJewelryTypes(ArrayList<JewelryType> jewelryTypes) {
        this.jewelryTypes = jewelryTypes;
    }

    @Override
    public String toString() {
        return "JewelryTypeListDTO{" +
                "\n\tjewelryTypes=" + jewelryTypes +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}
