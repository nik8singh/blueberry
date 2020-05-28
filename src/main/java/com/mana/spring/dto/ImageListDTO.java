package com.mana.spring.dto;

import com.mana.spring.domain.Image;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class ImageListDTO extends Pagination {
    private ArrayList<ImageDTO> imageDtos;

    public ImageListDTO() {
        imageDtos = new ArrayList<>();
    }

    public ArrayList<ImageDTO> getImageDtos() {
        return imageDtos;
    }

    public void setImageDtos(ArrayList<ImageDTO> imageDtos) {
        this.imageDtos = imageDtos;
    }

    public void setImages(ArrayList<Image> images) {
        for (Image img : images) {
            this.imageDtos.add(ImageDTOConverter.convertToDTO(img));
        }
    }

    @Override
    public String toString() {
        return "\nGemstoneListDTO{" +
                "\n\timageDtos=" + imageDtos +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}
