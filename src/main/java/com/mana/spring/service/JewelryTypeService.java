package com.mana.spring.service;

import com.mana.spring.dto.JewelryTypeDTO;
import com.mana.spring.dto.ProductListDTO;

import java.util.ArrayList;

public interface JewelryTypeService {
    ArrayList<JewelryTypeDTO> getJewelryTypes();

    void addJewelryType(JewelryTypeDTO jewelryTypeDTO);

    void updateJewelryType(JewelryTypeDTO jewelryTypeDTO);

    //    void deleteJewelryType(JewelryTypeDTO jewelryTypeDTO);

    ArrayList<JewelryTypeDTO> getActiveJewelryTypes();

    ProductListDTO getJewelryTypeProducts(JewelryTypeDTO jewelryTypeDTO);
}
