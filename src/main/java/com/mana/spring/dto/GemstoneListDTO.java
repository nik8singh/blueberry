package com.mana.spring.dto;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class GemstoneListDTO extends Pagination {

    private ArrayList<Gemstone> gemstones;

    public GemstoneListDTO() {
    }

    public ArrayList<Gemstone> getGemstones() {
        return gemstones;
    }

    public void setGemstones(ArrayList<Gemstone> gemstones) {
        this.gemstones = gemstones;
    }

    @Override
    public String toString() {
        return "\nGemstoneListDTO{" +
                "\n\tgemstones=" + gemstones +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}
