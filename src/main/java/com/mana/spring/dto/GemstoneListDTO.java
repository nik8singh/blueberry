package com.mana.spring.dto;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class GemstoneListDTO extends Pagination {

    private ArrayList<GemstoneDTO> gemstonesDtos;

    public GemstoneListDTO() {
        gemstonesDtos = new ArrayList<>();
    }

    public ArrayList<GemstoneDTO> getGemstones() {
        return gemstonesDtos;
    }

    public void setGemstonesDtos(ArrayList<GemstoneDTO> gemstonesDtos) {
        this.gemstonesDtos = gemstonesDtos;
    }

    public void setGemstones(ArrayList<Gemstone> gemstones) {
        for (Gemstone g : gemstones) {
            this.gemstonesDtos.add(GemstoneDTOConverter.convertToDTO(g));
        }
    }

    @Override
    public String toString() {
        return "\nGemstoneListDTO{" +
                "\n\tgemstones=" + gemstonesDtos +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}
