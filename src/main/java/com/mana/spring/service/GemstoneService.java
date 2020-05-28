package com.mana.spring.service;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.dto.GemstoneListDTO;

public interface GemstoneService {

    GemstoneListDTO getActiveGemstones(int pageNumber);

    GemstoneListDTO getInactiveGemstones(int pageNumber);

    GemstoneListDTO partialSearch(String searchWord);

    Gemstone addGemstone(Gemstone gemstone);

    Gemstone updateGemstone(Gemstone gemstone);

    void deactivateGemstone(long id);

    Gemstone getGemstone(String gemstoneName);

    Gemstone getGemstonebyId(long id);

    void activateGemstone(long id);
}
