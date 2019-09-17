package com.mana.spring.service.impl;

import com.mana.spring.dao.JewelryTypeDAO;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.dto.JewelryTypeListDTO;
import com.mana.spring.service.JewelryTypeService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class JewelryTypeServiceImpl implements JewelryTypeService {

    @Autowired
    private JewelryTypeDAO jewelryTypeDAO;

    public JewelryTypeListDTO getActiveJewelryTypes(int pageNumber) {
        int size = Pagination.getPageSize();
        JewelryTypeListDTO jewelryTypeListDTO = createListDTO(pageNumber, true);
        jewelryTypeListDTO.setJewelryTypes((ArrayList<JewelryType>) jewelryTypeDAO.listActiveJewelryType((pageNumber - 1) * size, size));
        return jewelryTypeListDTO;
    }

    public JewelryTypeListDTO getInactiveJewelryTypes(int pageNumber) {
        int size = Pagination.getPageSize();
        JewelryTypeListDTO jewelryTypeListDTO = createListDTO(pageNumber, false);
        jewelryTypeListDTO.setJewelryTypes((ArrayList<JewelryType>) jewelryTypeDAO.listInactiveJewelryTypes((pageNumber - 1) * size, size));
        return jewelryTypeListDTO;
    }

    public JewelryType addJewelryType(JewelryType jewelryType) {
        jewelryType.setJewelryTypeActive(true);
        return jewelryTypeDAO.saveJewelryType(jewelryType);

    }

    public JewelryType updateJewelryType(JewelryType jewelryType) {
        JewelryType jewelryTypeFromDb = jewelryTypeDAO.getJewelryTypeById((jewelryType.getJewelryTypeId()));
        jewelryTypeFromDb.setJewelryTypeName(jewelryType.getJewelryTypeName());
        jewelryTypeFromDb.setJewelryTypeDescription(jewelryType.getJewelryTypeDescription());
        jewelryTypeFromDb.setJewelryTypeActive(jewelryType.isJewelryTypeActive());
        jewelryTypeFromDb.setCreatedDate(null);
        jewelryTypeFromDb.setUpdatedDate(null);
        return jewelryTypeDAO.updateJewelryType(jewelryTypeFromDb);
    }

    public void deactivateJewelryType(String jewelryTypeName) {
        jewelryTypeDAO.deactivateJewelryType(jewelryTypeName);
    }

    public JewelryType getJewelryType(String jewelryTypeName) {
        return jewelryTypeDAO.getJewelryType(jewelryTypeName, false);
    }

    private JewelryTypeListDTO createListDTO(int pageNumber, boolean active) {
        long count = jewelryTypeDAO.count(active);
        JewelryTypeListDTO jewelryTypeListDTO = new JewelryTypeListDTO();
        jewelryTypeListDTO.setCount(count);
        jewelryTypeListDTO.setCurrentPageNumber(pageNumber);
        jewelryTypeListDTO.calculateAndSetTotalPages();
        return jewelryTypeListDTO;
    }
}
