package com.mana.spring.service;

import com.mana.spring.domain.JewelryType;
import com.mana.spring.dto.JewelryTypeListDTO;

public interface JewelryTypeService {

    JewelryTypeListDTO getActiveJewelryTypes(int pageNumber);

    JewelryTypeListDTO getInactiveJewelryTypes(int pageNumber);

    void addJewelryType(JewelryType jewelryType);

    void updateJewelryType(JewelryType jewelryType);

    void deactivateJewelryType(String jewelryTypeName);

    JewelryType getJewelryType(String jewelryTypeName);
}
