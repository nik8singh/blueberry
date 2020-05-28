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
        if (pageNumber > 0)
            metalListDTO.setMetals((ArrayList<Metal>) metalDAO.listActiveMetals((pageNumber - 1) * size, size));
        else
            metalListDTO.setMetals((ArrayList<Metal>) metalDAO.listActiveMetals());
        return metalListDTO;
    }

    public MetalListDTO getInactiveMetals(int pageNumber) {
        int size = Pagination.getPageSize();
        MetalListDTO metalListDTO = createListDTO(pageNumber, false);
        metalListDTO.setMetals((ArrayList<Metal>) metalDAO.listInactiveMetals((pageNumber - 1) * size,size));
        return metalListDTO;
    }

    public Metal addMetal(Metal metal) {
        metal.setMetalActive(true);
        return metalDAO.saveMetal(metal);
    }

    public Metal updateMetal(Metal metal) {
        Metal metalFromDb = metalDAO.getMetalById((metal.getMetalId()));
        metalFromDb.setMetalName(metal.getMetalName());
        metalFromDb.setMetalDescription(metal.getMetalDescription());
        metalFromDb.setCreatedDate(null);
        metalFromDb.setUpdatedDate(null);
        return metalDAO.updateMetal(metalFromDb);
    }

    public void deactivateMetal(long id) {
        metalDAO.deactivateMetal(id);
    }

    public void activateMetal(long id) {
        metalDAO.activateMetal(id);
    }

    public Metal getMetal(String metalName) {
        return metalDAO.getMetal(metalName, false);
    }

    @Override
    public MetalListDTO partialSearch(String searchWord) {
        MetalListDTO metalListDTO = new MetalListDTO();
        metalListDTO.setMetals((ArrayList<Metal>) metalDAO.listPartialSearch(searchWord));
        return metalListDTO;
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
