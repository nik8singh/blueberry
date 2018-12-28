package com.mana.spring.service;

import com.mana.spring.domain.Metal;
import com.mana.spring.dto.MetalListDTO;

public interface MetalService {

    MetalListDTO getActiveMetals(int pageNumber);

    MetalListDTO getInactiveMetals(int pageNumber);

    void addMetal(Metal metal);

    void updateMetal(Metal metal);

    void deactivateMetal(String metalName);

    Metal getMetal(String metalName);

}
