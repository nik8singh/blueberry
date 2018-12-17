package com.mana.spring.service.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.dto.ProductListDTO;
import com.mana.spring.service.GemstoneService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class GemstoneServiceImpl implements GemstoneService {

    @Autowired
    private GemstoneDAO gemstoneDAO;

    public ArrayList<GemstoneDTO> getGemstones() {
        ArrayList<Gemstone> gemstones = (ArrayList<Gemstone>) gemstoneDAO.listGemstones();
        return ConverterDAOtoDTO.gemstoneListDaoToDto(gemstones);
    }

    public ArrayList<GemstoneDTO> getActiveGemstones() {

        ArrayList<Gemstone> gemstones = (ArrayList<Gemstone>) gemstoneDAO.listActiveGemstones();
        return ConverterDAOtoDTO.gemstoneListDaoToDto(gemstones);

    }

    public void addGemstone(GemstoneDTO gemstoneDTO) {

        gemstoneDAO.saveGemstone(ConverterDTOtoDAO.gemstoneDtoToDao(gemstoneDTO));
    }

    public void updateGemstone(GemstoneDTO gemstoneDTO) {
        gemstoneDAO.updateGemstone(ConverterDTOtoDAO.gemstoneDtoToDao(gemstoneDTO));
    }

    public ProductListDTO getGemstoneProducts(GemstoneDTO gemstoneDTO) {
        Gemstone gem = gemstoneDAO.getGemstone(gemstoneDTO.getGemstoneName());
        ProductListDTO productListDTO = new ProductListDTO();
        BeanUtils.copyProperties(gem, productListDTO);
        return productListDTO;
    }

}
