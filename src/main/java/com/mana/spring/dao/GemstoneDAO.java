package com.mana.spring.dao;

import com.mana.spring.domain.Gemstone;

import java.util.List;

public interface GemstoneDAO {

    void saveGemstone(Gemstone gemstone);
    void deleteGemstone(Gemstone gemstone);
    List<Gemstone> listGemstone();
}
