package com.mana.spring.dto;

import com.mana.spring.domain.Gemstone;

public class GemstoneDTOConverter {
    public static GemstoneDTO convertToDTO(Gemstone gemstone) {
        GemstoneDTO gemstoneDTO = new GemstoneDTO();
        gemstoneDTO.setGemstoneId(gemstone.getGemstoneId());
        gemstoneDTO.setGemstoneName(gemstone.getGemstoneName());
        gemstoneDTO.setGemstoneDescription(gemstone.getGemstoneDescription());
        gemstoneDTO.setGemstoneActive(gemstone.isGemstoneActive());
        return gemstoneDTO;
    }

}
