package com.mana.spring.service;

import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.Product;

import java.util.ArrayList;
import java.util.Set;

public interface GemstoneService {

    ArrayList<Gemstone> getGemstones();
    ArrayList<Gemstone> getActiveGemstones();
    void addGemstone(Gemstone gemstone);
    void updateGemstone(Gemstone gemstone);
    void deleteGemstone(Gemstone gemstone);
    Gemstone getGemstone(String gemstoneName);
}
