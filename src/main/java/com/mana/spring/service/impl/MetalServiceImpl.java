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

    public ArrayList<Metal> getMetals() {
        ArrayList<Metal> metals = (ArrayList<Metal>) metalDAO.listMetals();
        return metals;
    }

    public ArrayList<Metal> getActiveMetals() {
        ArrayList<Metal> metals = (ArrayList<Metal>) metalDAO.listActiveMetals();
        return metals;
    }

    public void addMetal(Metal metal) {
        metalDAO.saveMetal(metal);
    }

    public void updateMetal(Metal metal) {


        // get from DB then update

        metalDAO.updateMetal(metal);
    }

    public void deleteMetal(Metal metal) {
//        metalDAO.deleteMetal(dtoToDao(metalDTO));
    }

    public Metal getMetal(Metal metal) {
        return null;
    }
}
