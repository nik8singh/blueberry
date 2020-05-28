package com.mana.spring.dto;

import com.mana.spring.domain.Metal;

public class MetalDTOConverter {

    public static MetalDTO convertToDTO(Metal metal) {
        MetalDTO metalDTO = new MetalDTO();
        metalDTO.setMetalId(metal.getMetalId());
        metalDTO.setMetalName(metal.getMetalName());
        metalDTO.setMetalDescription(metal.getMetalDescription());
        metalDTO.setMetalActive(metal.isMetalActive());
        return metalDTO;
    }
}
