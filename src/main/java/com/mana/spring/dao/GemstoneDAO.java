package com.mana.spring.dao;

import com.mana.spring.domain.Gemstone;

import java.util.List;

public interface GemstoneDAO {

    Gemstone saveGemstone(Gemstone gemstone);

    Gemstone updateGemstone(Gemstone gemstone);

    void deactivateGemstone(long id);

    List listActiveGemstones(int start, int end);

    List listActiveGemstones();

    List listInactiveGemstones(int start, int end);

    Gemstone getGemstone(String gemstoneName, boolean requireProducts);

    Gemstone getGemstonebyId(long gemstoneid, boolean requireProducts);

    List listPartialSearch(String searchWord);

    Gemstone getGemstoneById(long gemstoneId);

    long count(boolean active);

    void activateGemstone(long id);
}
