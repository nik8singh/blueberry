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

    public ArrayList<Metal> getMetals() {
        return (ArrayList<Metal>) metalDAO.listMetal();
    }

    public void addMetal(Metal metal) {
        metalDAO.saveMetal(metal);
    }

    public void updateMetal(Metal metal) {
        metalDAO.updateMetal(metal);
    }

    public void deleteMetal(Metal metal) {
        metalDAO.deleteMetal(metal);
    }

}
