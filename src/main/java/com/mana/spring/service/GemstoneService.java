package com.mana.spring.service;

import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.dto.ProductDTO;

import java.util.ArrayList;

public interface GemstoneService {

    ArrayList<GemstoneDTO> getGemstones();

    ArrayList<GemstoneDTO> getActiveGemstones();

    void addGemstone(GemstoneDTO gemstoneDTO);

    void updateGemstone(GemstoneDTO gemstoneDTO);

    //    void deleteGemstone(Gemstone gemstone);

    ArrayList<ProductDTO> getGemstoneProducts(GemstoneDTO gemstoneDTO);
}
