package com.mana.spring.service;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.dto.GemstoneListDTO;

import java.util.ArrayList;

public interface GemstoneService {

    GemstoneListDTO getActiveGemstones(int pageNumber);

    GemstoneListDTO getInactiveGemstones(int pageNumber);

    void addGemstone(Gemstone gemstone);

    void updateGemstone(Gemstone gemstone);

    void deactivateGemstone(String gemstoneName);

    Gemstone getGemstone(String gemstoneName);


}
