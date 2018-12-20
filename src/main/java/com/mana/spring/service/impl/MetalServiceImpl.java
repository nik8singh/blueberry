package com.mana.spring.service.impl;

import com.mana.spring.dao.MetalDAO;
import com.mana.spring.domain.Metal;
import com.mana.spring.dto.MetalDTO;
import com.mana.spring.service.MetalService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class MetalServiceImpl implements MetalService {

    @Autowired
    private MetalDAO metalDAO;

    public ArrayList<MetalDTO> getMetals() {
        ArrayList<Metal> metals = (ArrayList<Metal>) metalDAO.listMetals();
        return ConverterDAOtoDTO.metalListDaoToDto(metals);
    }

    public ArrayList<MetalDTO> getActiveMetals() {
        ArrayList<Metal> metals = (ArrayList<Metal>) metalDAO.listActiveMetals();
        return ConverterDAOtoDTO.metalListDaoToDto(metals);
    }

    public void addMetal(MetalDTO metalDTO) {
        metalDAO.saveMetal(ConverterDTOtoDAO.metalDtoToDao(metalDTO));
    }

    public void updateMetal(MetalDTO metalDTO) {
        metalDAO.updateMetal(ConverterDTOtoDAO.metalDtoToDao(metalDTO));
    }

//    public void deleteMetal(MetalDTO metalDTO) {
//        metalDAO.deleteMetal(dtoToDao(metalDTO));
//    }

//    public ProductListDTO getMetalProducts(MetalDTO metalDTO) {
//        Metal metal = metalDAO.getMetal(metalDTO.getMetalName());
//        ProductListDTO productListDTO = new ProductListDTO();
//        BeanUtils.copyProperties(metal, productListDTO);
//        return productListDTO;
//    }


}
