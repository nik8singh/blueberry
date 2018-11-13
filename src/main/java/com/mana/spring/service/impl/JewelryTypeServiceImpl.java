package com.mana.spring.service.impl;

import com.mana.spring.dao.JewelryTypeDAO;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.dto.JewelryTypeDTO;
import com.mana.spring.dto.ProductListDTO;
import com.mana.spring.service.JewelryTypeService;
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
        return daoListToDtoList(jewelryTypes);

    }

    public void addJewelryType(JewelryTypeDTO jewelryTypeDTO) {
        jewelryTypeDAO.saveJewelryType(dtoToDao(jewelryTypeDTO));
    }

    public void updateJewelryType(JewelryTypeDTO jewelryTypeDTO) {
        jewelryTypeDAO.updateJewelryType(dtoToDao(jewelryTypeDTO));
    }

//    public void deleteJewelryType(JewelryTypeDTO jewelryTypeDTO) {
//        jewelryTypeDAO.deleteJewelryType(jewelryType);
//    }

    public ArrayList<JewelryTypeDTO> getActiveJewelryTypes() {
        ArrayList<JewelryType> jewelryTypes = (ArrayList<JewelryType>) jewelryTypeDAO.listActiveJewelryTypes();
        return daoListToDtoList(jewelryTypes);
    }

    public ProductListDTO getJewelryTypeProducts(JewelryTypeDTO jewelryTypeDTO) {
        JewelryType metal = jewelryTypeDAO.getJewelryType(jewelryTypeDTO.getJewelryTypeName());
        ProductListDTO productListDTO = new ProductListDTO();
        BeanUtils.copyProperties(metal, productListDTO);
        return productListDTO;
    }

    public ArrayList<JewelryTypeDTO> daoListToDtoList(ArrayList<JewelryType> jewelryTypes){

        ArrayList<JewelryTypeDTO> jewelryTypeDTOS = new ArrayList<JewelryTypeDTO>();

        for (JewelryType jewelryType : jewelryTypes) {
            jewelryTypeDTOS.add(daoToDto(jewelryType));
        }

        return jewelryTypeDTOS;
    }

    public JewelryTypeDTO daoToDto(JewelryType jewelryType) {

        // to copy to
        JewelryTypeDTO target = new JewelryTypeDTO();

        BeanUtils.copyProperties(jewelryType, target);
        return target;

    }

    public JewelryType dtoToDao(JewelryTypeDTO jewelryTypeDTO) {

        // to copy to
        JewelryType target = new JewelryType();

        BeanUtils.copyProperties(jewelryTypeDTO, target);
        return target;

    }


}
