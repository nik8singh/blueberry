package com.mana.spring.service.impl;

import com.mana.spring.dao.MetalDAO;
import com.mana.spring.domain.Metal;
import com.mana.spring.service.MetalService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class MetalServiceImpl implements MetalService {

    @Autowired
    private MetalDAO metalDAO;

//    public ArrayList<Metal> getMetals() {
//        ArrayList<Metal> metals = (ArrayList<Metal>) metalDAO.listMetals();
//        return metals;
//    }
//
//    public ArrayList<Metal> getActiveMetals() {
//        ArrayList<Metal> metals = (ArrayList<Metal>) metalDAO.listActiveMetals();
//        return metals;
//    }
//
//    public void addMetal(Metal metal) {
//        metalDAO.saveMetal(metal);
//    }
//
//    public void updateMetal(Metal metal) {
//
//
//        // get from DB then update
//
//        metalDAO.updateMetal(metal);
//    }
//
//    public void deleteMetal(Metal metal) {
////        metalDAO.deleteMetal(dtoToDao(metalDTO));
//    }
//
//    public Metal getMetal(Metal metal) {
//        return null;
//    }


    public ArrayList<Metal> getMetals() {
        return null;
    }

    public ArrayList<Metal> getActiveMetals() {
        return null;
    }

    public void addMetal(Metal metal) {

    }

    public void updateMetal(Metal metal) {

    }

    public void deleteMetal(Metal metal) {

    }

    public Metal getMetal(Metal metalDTO) {
        return null;
    }
}
