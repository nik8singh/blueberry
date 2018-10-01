package com.mana.spring.service;

import com.mana.spring.domain.Metal;

import java.util.ArrayList;

public interface MetalService {

    ArrayList<Metal> getMetals();

    void addMetal(Metal metal);

    void updateMetal(Metal metal);

    void deleteMetal(Metal metal);
}
