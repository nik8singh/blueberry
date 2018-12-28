package com.mana.spring.dao;

import com.mana.spring.domain.JewelryType;

import java.util.List;

public interface JewelryTypeDAO {

    void saveJewelryType(JewelryType jewelryType);

    void updateJewelryType(JewelryType jewelryType);

    void deactivateJewelryType(String jewelryTypeName);

    List listActiveJewelryType(int start, int end);

    List listInactiveJewelryTypes(int start, int end);

    JewelryType getJewelryType(String jewelryTypeName, boolean requireProducts);

    JewelryType getJewelryTypeById(long jewelryTypeId);

    long count(boolean active);

}
