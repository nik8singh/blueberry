package com.mana.spring.service;

import com.mana.spring.dto.MetalDTO;

import java.util.ArrayList;

public interface MetalService {

    ArrayList<MetalDTO> getMetals();

    ArrayList<MetalDTO> getActiveMetals();

    void addMetal(MetalDTO metalDTO);

    void updateMetal(MetalDTO metalDTO);

//  void deleteMetal(MetalDTO metalDTO);

//    ProductListDTO getMetalProducts(MetalDTO metalDTO);
}
