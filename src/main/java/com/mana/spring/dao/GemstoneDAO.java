package com.mana.spring.dao;

import com.mana.spring.domain.Gemstone;

import java.io.Serializable;
import java.util.List;

public interface GemstoneDAO {

    void saveGemstone(Gemstone gemstone);
    void updateGemstone(Gemstone gemstone);
//    void deleteGemstone(Gemstone gemstone);
    List listGemstones();
    List listActiveGemstones();
    Gemstone getGemstone(long gemstoneId);
}
