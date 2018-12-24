package com.mana.spring.service.impl;

import com.mana.spring.dao.JewelryTypeDAO;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.dto.JewelryTypeDTO;
import com.mana.spring.service.JewelryTypeService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class JewelryTypeServiceImpl implements JewelryTypeService {

    @Autowired
    private JewelryTypeDAO jewelryTypeDAO;

    public ArrayList<JewelryType> getJewelryTypes() {

        ArrayList<JewelryType> jewelryTypes = (ArrayList<JewelryType>) jewelryTypeDAO.listJewelryType();
        return jewelryTypes;

    }

    public void addJewelryType(JewelryType jewelryType) {
        jewelryTypeDAO.saveJewelryType(jewelryType);
    }

    public void updateJewelryType(JewelryType jewelryType) {

        // get from DB then update

        jewelryTypeDAO.updateJewelryType(jewelryType);
    }

    public void deleteJewelryType(JewelryType jewelryType) {
//        jewelryTypeDAO.deleteJewelryType(jewelryType);
    }

    public ArrayList<JewelryType> getActiveJewelryTypes() {
        ArrayList<JewelryType> jewelryTypes = (ArrayList<JewelryType>) jewelryTypeDAO.listActiveJewelryTypes();
        return jewelryTypes;
    }

    public JewelryType getJewelryType(JewelryType jewelryType) {
        return null;
    }
}
