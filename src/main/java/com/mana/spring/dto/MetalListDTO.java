package com.mana.spring.dto;

import com.mana.spring.domain.Metal;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class MetalListDTO extends Pagination {

    private ArrayList<MetalDTO> metalsDtos;

    public MetalListDTO() {
        metalsDtos = new ArrayList<>();
    }


    public ArrayList<MetalDTO> getMetalsDtos() {
        return metalsDtos;
    }

    public void setMetalsDtos(ArrayList<MetalDTO> metalsDtos) {
        this.metalsDtos = metalsDtos;
    }

    public void setMetals(ArrayList<Metal> metals) {
        for (Metal m : metals) {
            this.metalsDtos.add(MetalDTOConverter.convertToDTO(m));
        }
    }

    @Override
    public String toString() {
        return "MetalListDTO{" +
                "\n\tmetals=" + metalsDtos +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}
