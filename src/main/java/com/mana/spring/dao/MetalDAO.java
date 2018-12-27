package com.mana.spring.dao;

import com.mana.spring.domain.Metal;

import java.util.List;

public interface MetalDAO {

    void saveMetal(Metal metal);

    void updateMetal(Metal metal);

    void deactivateMetal(String metalName);

    List listActiveMetals(int start, int end);

    List listInactiveMetals(int start, int end);

    Metal getMetal(String metalName, boolean requireProducts);

    Metal getMetalById(long metalId);

    long count(boolean active);
}
