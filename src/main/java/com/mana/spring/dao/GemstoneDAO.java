package com.mana.spring.dao;

import com.mana.spring.domain.Gemstone;

import java.util.List;

public interface GemstoneDAO {

    Gemstone saveGemstone(Gemstone gemstone);

    Gemstone updateGemstone(Gemstone gemstone);

    void deactivateGemstone(String gemstoneName);

    List listActiveGemstones(int start, int end);

    List listInactiveGemstones(int start, int end);

    Gemstone getGemstone(String gemstoneName, boolean requireProducts);

    Gemstone getGemstoneById(long gemstoneId);

    long count(boolean active);
}
