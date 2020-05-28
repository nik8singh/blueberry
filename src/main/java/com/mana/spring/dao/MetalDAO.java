package com.mana.spring.dao;

import com.mana.spring.domain.Metal;

import java.util.List;

public interface MetalDAO {

    Metal saveMetal(Metal metal);

    Metal updateMetal(Metal metal);

    void deactivateMetal(long id);

    void activateMetal(long id);

    List listActiveMetals(int start, int end);

    List listActiveMetals();

    List listInactiveMetals(int start, int end);

    Metal getMetal(String metalName, boolean requireProducts);

    Metal getMetalById(long metalId);

    long count(boolean active);

    List listPartialSearch(String searchWord);
}
