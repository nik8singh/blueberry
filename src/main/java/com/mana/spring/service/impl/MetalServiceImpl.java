package com.mana.spring.service.impl;

import com.mana.spring.dao.MetalDAO;
import com.mana.spring.domain.Metal;
import com.mana.spring.dto.MetalListDTO;
import com.mana.spring.service.MetalService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class MetalServiceImpl implements MetalService {

    @Autowired
    private MetalDAO metalDAO;

    public MetalListDTO getActiveMetals(int pageNumber) {
        int size = Pagination.getPageSize();
        MetalListDTO metalListDTO = createListDTO(pageNumber, true);
        metalListDTO.setMetals((ArrayList<Metal>) metalDAO.listActiveMetals((pageNumber - 1) * size, size));
        return metalListDTO;
    }

    public MetalListDTO getInactiveMetals(int pageNumber) {
        int size = Pagination.getPageSize();
        MetalListDTO metalListDTO = createListDTO(pageNumber, false);
        metalListDTO.setMetals((ArrayList<Metal>) metalDAO.listInactiveMetals((pageNumber - 1) * size,size));
        return metalListDTO;
    }

    public void addMetal(Metal metal) {
        metalDAO.saveMetal(metal);
    }

    public void updateMetal(Metal metal) {
        Metal metalFromDb = metalDAO.getMetalById((metal.getMetalId()));
        metalFromDb.setMetalName(metal.getMetalName());
        metalFromDb.setMetalDescription(metal.getMetalDescription());
        metalFromDb.setMetalActive(metal.isMetalActive());
        metalFromDb.setCreatedDate(null);
        metalFromDb.setUpdatedDate(null);
        metalDAO.updateMetal(metalFromDb);
    }

    public void deactivateMetal(String metalName) {
        metalDAO.deactivateMetal(metalName);
    }

    public Metal getMetal(String metalName) {
        return metalDAO.getMetal(metalName, false);
    }

    private MetalListDTO createListDTO(int pageNumber, boolean active) {
        long count = metalDAO.count(active);
        MetalListDTO metalListDTO = new MetalListDTO();
        metalListDTO.setCount(count);
        metalListDTO.setCurrentPageNumber(pageNumber);
        metalListDTO.calculateAndSetTotalPages();
        return metalListDTO;
    }


}
