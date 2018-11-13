package com.mana.spring.service.impl;

import com.mana.spring.dao.MetalDAO;
import com.mana.spring.domain.Metal;
import com.mana.spring.dto.MetalDTO;
import com.mana.spring.dto.ProductListDTO;
import com.mana.spring.service.MetalService;
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
        return daoListToDtoList(metals);
    }

    public ArrayList<MetalDTO> getActiveMetals() {
        ArrayList<Metal> metals = (ArrayList<Metal>) metalDAO.listActiveMetals();
        return daoListToDtoList(metals);
    }

    public void addMetal(MetalDTO metalDTO) {
        metalDAO.saveMetal(dtoToDao(metalDTO));
    }

    public void updateMetal(MetalDTO metalDTO) {
        metalDAO.updateMetal(dtoToDao(metalDTO));
    }

//    public void deleteMetal(MetalDTO metalDTO) {
//        metalDAO.deleteMetal(dtoToDao(metalDTO));
//    }

    public ProductListDTO getMetalProducts(MetalDTO metalDTO) {
        Metal metal = metalDAO.getMetal(metalDTO.getMetalName());
        ProductListDTO productListDTO = new ProductListDTO();
        BeanUtils.copyProperties(metal, productListDTO);
        return productListDTO;
    }


    public ArrayList<MetalDTO> daoListToDtoList(ArrayList<Metal> metals){

        ArrayList<MetalDTO> metalDTOS = new ArrayList<MetalDTO>();

        for (Metal metal : metals) {
            metalDTOS.add(daoToDto(metal));
        }

        return metalDTOS;
    }

    public MetalDTO daoToDto(Metal metal) {

        // to copy to
        MetalDTO target = new MetalDTO();

        BeanUtils.copyProperties(metal, target);
        return target;

    }

    public Metal dtoToDao(MetalDTO metalDTO) {

        // to copy to
        Metal target = new Metal();

        BeanUtils.copyProperties(metalDTO, target);
        return target;

    }


}
