package com.mana.spring.service.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.dto.GemstoneListDTO;
import com.mana.spring.service.GemstoneService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class GemstoneServiceImpl implements GemstoneService {

    @Autowired
    private GemstoneDAO gemstoneDAO;

    public GemstoneListDTO getActiveGemstones(int pageNumber) {
        int size = Pagination.getPageSize();
        GemstoneListDTO gemstoneListDTO = createListDTO(pageNumber, true);
        gemstoneListDTO.setGemstones((ArrayList<Gemstone>) gemstoneDAO.listActiveGemstones((pageNumber - 1) * size, size));
        return gemstoneListDTO;
    }

    public GemstoneListDTO getInactiveGemstones(int pageNumber) {
        int size = Pagination.getPageSize();
        GemstoneListDTO gemstoneListDTO = createListDTO(pageNumber, false);
        gemstoneListDTO.setGemstones((ArrayList<Gemstone>) gemstoneDAO.listInactiveGemstones((pageNumber - 1) * size, size));
        return gemstoneListDTO;
    }

    public void deactivateGemstone(String gemstoneName) {
        gemstoneDAO.deactivateGemstone(gemstoneName);
    }

    public Gemstone getGemstone(String gemstoneName) {
        return gemstoneDAO.getGemstone(gemstoneName, false); // false to keep fetch type LAZY
    }

    public Gemstone addGemstone(Gemstone gemstone) {
        gemstone.setGemstoneActive(true);
       return gemstoneDAO.saveGemstone(gemstone);
    }

    public Gemstone updateGemstone(Gemstone gemstone) {
        Gemstone gemstoneFromDb = gemstoneDAO.getGemstoneById(gemstone.getGemstoneId());
        gemstoneFromDb.setGemstoneName(gemstone.getGemstoneName());
        gemstoneFromDb.setGemstoneDescription(gemstone.getGemstoneDescription());
        gemstoneFromDb.setCreatedDate(null);
        gemstoneFromDb.setUpdatedDate(null);
        return gemstoneDAO.updateGemstone(gemstoneFromDb);
    }

    private GemstoneListDTO createListDTO(int pageNumber, boolean active) {
        long count = gemstoneDAO.count(active);
        GemstoneListDTO gemstoneListDTO = new GemstoneListDTO();
        gemstoneListDTO.setCount(count);
        gemstoneListDTO.setCurrentPageNumber(pageNumber);
        gemstoneListDTO.calculateAndSetTotalPages();

        return gemstoneListDTO;
    }

}
