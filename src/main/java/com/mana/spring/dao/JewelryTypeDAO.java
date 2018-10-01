package com.mana.spring.dao;

import com.mana.spring.domain.JewelryType;

import java.util.List;

public interface JewelryTypeDAO {

    void saveJewelryType(JewelryType jewelryType);
    void updateJewelryType(JewelryType jewelryType);
    void deleteJewelryType(JewelryType jewelryType);
    List listJewelryType();

}
