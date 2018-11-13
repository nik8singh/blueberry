package com.mana.spring.service.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.dto.ProductListDTO;
import com.mana.spring.service.GemstoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
public class GemstoneServiceImpl implements GemstoneService {

    @Autowired
    private GemstoneDAO gemstoneDAO;

    public ArrayList<GemstoneDTO> getGemstones() {
        ArrayList<Gemstone> gemstones = (ArrayList<Gemstone>) gemstoneDAO.listGemstones();
       return daoListToDtoList(gemstones);
    }

    public ArrayList<GemstoneDTO> getActiveGemstones() {

        ArrayList<Gemstone> gemstones = (ArrayList<Gemstone>) gemstoneDAO.listActiveGemstones();
        return daoListToDtoList(gemstones);

    }

    public void addGemstone(GemstoneDTO gemstoneDTO) {

        gemstoneDAO.saveGemstone(dtoToDao(gemstoneDTO));
    }

    public void updateGemstone(GemstoneDTO gemstoneDTO) {
        gemstoneDAO.updateGemstone(dtoToDao(gemstoneDTO));
    }

//    public void deleteGemstone(GemstoneDTO gemstoneDTO) {
//        gemstoneDAO.deleteGemstone(dtoToDao(gemstoneDTO));
//    }

    public ProductListDTO getGemstoneProducts(GemstoneDTO gemstoneDTO) {
        Gemstone gem = gemstoneDAO.getGemstone(gemstoneDTO.getGemstoneName());
        ProductListDTO productListDTO = new ProductListDTO();
        BeanUtils.copyProperties(gem, productListDTO);
        return productListDTO;
    }

    public ArrayList<GemstoneDTO> daoListToDtoList(ArrayList<Gemstone> gemstones){

        ArrayList<GemstoneDTO> gemstoneDTOs = new ArrayList<GemstoneDTO>();

        for (Gemstone gem : gemstones) {
            gemstoneDTOs.add(daoToDto(gem));
        }

        return gemstoneDTOs;
    }

    public GemstoneDTO daoToDto(Gemstone gemstone) {

        // to copy to
        GemstoneDTO target = new GemstoneDTO();

        BeanUtils.copyProperties(gemstone, target);
        return target;

    }

    public Gemstone dtoToDao(GemstoneDTO gemstoneDTO) {

        // to copy to
        Gemstone target = new Gemstone();

        BeanUtils.copyProperties(gemstoneDTO, target);
        return target;

    }

}
