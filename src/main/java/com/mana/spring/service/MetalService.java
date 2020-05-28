package com.mana.spring.service;

import com.mana.spring.domain.Metal;
import com.mana.spring.dto.MetalListDTO;

public interface MetalService {

    MetalListDTO getActiveMetals(int pageNumber);

    MetalListDTO getInactiveMetals(int pageNumber);

    Metal addMetal(Metal metal);

    Metal updateMetal(Metal metal);

    void deactivateMetal(long id);

    void activateMetal(long id);

    Metal getMetal(String metalName);

    MetalListDTO partialSearch(String searchWord);
}
