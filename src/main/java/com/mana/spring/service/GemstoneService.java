package com.mana.spring.service;

import com.mana.spring.domain.Gemstone;

import java.util.ArrayList;

public interface GemstoneService {

    ArrayList<Gemstone> getGemstones();

    ArrayList<Gemstone> getActiveGemstones();

    void addGemstone(Gemstone gemstone);

    void updateGemstone(Gemstone gemstone);

    void deleteGemstone(Gemstone gemstone);

    Gemstone getGemstoneById(long gemstoneId);
}
