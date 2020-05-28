package com.mana.spring.dto;

import com.mana.spring.domain.JewelryType;

public class JewelryTypeDTOConverter {

    public static JewelryTypeDTO convertToDTO(JewelryType jewelryType) {
        JewelryTypeDTO jewelryTypeDTO = new JewelryTypeDTO();
        jewelryTypeDTO.setJewelryTypeId(jewelryType.getJewelryTypeId());
        jewelryTypeDTO.setJewelryTypeName(jewelryType.getJewelryTypeName());
        jewelryTypeDTO.setJewelryTypeDescription(jewelryType.getJewelryTypeDescription());
        jewelryTypeDTO.setJewelryTypeActive(jewelryType.isJewelryTypeActive());
        return jewelryTypeDTO;
    }


}
