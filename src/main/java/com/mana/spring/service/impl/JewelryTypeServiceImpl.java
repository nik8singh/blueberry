package com.mana.spring.service.impl;

import com.mana.spring.dao.JewelryTypeDAO;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.dto.JewelryTypeDTO;
import com.mana.spring.dto.ProductListDTO;
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

    public ArrayList<JewelryTypeDTO> getJewelryTypes() {

        ArrayList<JewelryType> jewelryTypes = (ArrayList<JewelryType>) jewelryTypeDAO.listJewelryType();
        return ConverterDAOtoDTO.jewelryTypeListDaoToDto(jewelryTypes);

    }

    public void addJewelryType(JewelryTypeDTO jewelryTypeDTO) {
        jewelryTypeDAO.saveJewelryType(ConverterDTOtoDAO.jewelryTypeDtoToDao(jewelryTypeDTO));
    }

    public void updateJewelryType(JewelryTypeDTO jewelryTypeDTO) {
        jewelryTypeDAO.updateJewelryType(ConverterDTOtoDAO.jewelryTypeDtoToDao(jewelryTypeDTO));
    }

//    public void deleteJewelryType(JewelryTypeDTO jewelryTypeDTO) {
//        jewelryTypeDAO.deleteJewelryType(jewelryType);
//    }

    public ArrayList<JewelryTypeDTO> getActiveJewelryTypes() {
        ArrayList<JewelryType> jewelryTypes = (ArrayList<JewelryType>) jewelryTypeDAO.listActiveJewelryTypes();
        return ConverterDAOtoDTO.jewelryTypeListDaoToDto(jewelryTypes);
    }

    public ProductListDTO getJewelryTypeProducts(JewelryTypeDTO jewelryTypeDTO) {
        JewelryType metal = jewelryTypeDAO.getJewelryType(jewelryTypeDTO.getJewelryTypeName());
        ProductListDTO productListDTO = new ProductListDTO();
        BeanUtils.copyProperties(metal, productListDTO);
        return productListDTO;
    }






}
