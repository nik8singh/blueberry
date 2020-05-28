package com.mana.spring.service;

import com.mana.spring.domain.JewelryType;
import com.mana.spring.dto.JewelryTypeListDTO;

public interface JewelryTypeService {

    JewelryTypeListDTO getActiveJewelryTypes(int pageNumber);

    JewelryTypeListDTO getInactiveJewelryTypes(int pageNumber);

    JewelryType addJewelryType(JewelryType jewelryType);

    JewelryType updateJewelryType(JewelryType jewelryType);

    void deactivateJewelryType(long id);

    void activateJewelryType(long id);

    JewelryType getJewelryType(String jewelryTypeName);

    JewelryType getJewelryTypebyId(long jewelryTypeId);

    JewelryTypeListDTO partialSearch(String searchWord);
}
