package com.mana.spring.service.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.GemstoneDTO;
import com.mana.spring.dto.ProductDTO;
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

        ArrayList<ProductDTO> productDTOS = getGemstoneProducts(gemstoneDTO);

        GemstoneDTO modifiedGemstone = new GemstoneDTO();

        BeanUtils.copyProperties(gemstoneDTO, modifiedGemstone);
        modifiedGemstone.setProductDTOS(productDTOS);

        gemstoneDAO.updateGemstone(ConverterDTOtoDAO.gemstoneDtoToDao(modifiedGemstone));
    }

    public  ArrayList<ProductDTO> getGemstoneProducts(GemstoneDTO gemstoneDTO) {
        Gemstone gem = gemstoneDAO.getGemstone(gemstoneDTO.getGemstoneName());
        ArrayList<ProductDTO> productDTOS = new ArrayList<ProductDTO>();

        for(Product product: gem.getProducts()) {
            Product product1 = new Product();
            BeanUtils.copyProperties(product, product1);

            productDTOS.add(ConverterDAOtoDTO.productDaoToDto(product1));
        }
        return productDTOS;
    }

}
