package com.mana.spring.dao;

import com.mana.spring.domain.Metal;

import java.util.List;

public interface MetalDAO {

    void saveMetal(Metal metal);

    void updateMetal(Metal metal);

    void deleteMetal(Metal metal);

    List listMetal();

    Metal getMetal(String metalName);
}
