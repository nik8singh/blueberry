package com.mana.spring.service;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.dto.GemstoneListDTO;

public interface GemstoneService {

    GemstoneListDTO getActiveGemstones(int pageNumber);

    GemstoneListDTO getInactiveGemstones(int pageNumber);

    Gemstone addGemstone(Gemstone gemstone);

    Gemstone updateGemstone(Gemstone gemstone);

    void deactivateGemstone(String gemstoneName);

    Gemstone getGemstone(String gemstoneName);


}
