package com.mana.spring.service;

import com.mana.spring.domain.JewelryType;

import java.util.ArrayList;

public interface JewelryTypeService {
    ArrayList<JewelryType> getJewelryTypes();
    void addJewelryType(JewelryType jewelryType);
    void updateJewelryType(JewelryType jewelryType);
    void deleteJewelryType(JewelryType jewelryType);
    ArrayList<JewelryType> getActiveJewelryTypes();
    JewelryType getJewelryType(String jewelryTypeName);
}
