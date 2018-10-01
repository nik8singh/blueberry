package com.mana.spring.service.impl;

import com.mana.spring.dao.JewelryTypeDAO;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.service.JewelryTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class JewelryTypeServiceImpl implements JewelryTypeService {

    @Autowired
    private JewelryTypeDAO jewelryTypeDAO;

    public ArrayList<JewelryType> getJewelryTypes() {
        System.out.println("STATUS: All jewelry type SERVICE");
        return (ArrayList<JewelryType>) jewelryTypeDAO.listJewelryType();
    }

    public void addJewelryType(JewelryType jewelryType) {
        jewelryTypeDAO.saveJewelryType(jewelryType);
    }

    public void updateJewelryType(JewelryType jewelryType) {
        jewelryTypeDAO.updateJewelryType(jewelryType);
    }

    public void deleteJewelryType(JewelryType jewelryType) {
        jewelryTypeDAO.deleteJewelryType(jewelryType);
    }
}
