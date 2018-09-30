package com.mana.spring.service;

import com.mana.spring.domain.Gemstone;

import java.util.ArrayList;

public interface GemstoneService {

    ArrayList<Gemstone> getGemstones();
    void addUpdateGemstone(Gemstone gemstone);
    void deleteGemstone(Gemstone gemstone);
}
