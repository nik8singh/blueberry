package com.mana.spring.service.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.service.GemstoneService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class GemstoneServiceImpl implements GemstoneService {

    @Autowired
    private GemstoneDAO gemstoneDAO;

    public ArrayList<Gemstone> getGemstones() {
        ArrayList<Gemstone> gemstones = (ArrayList<Gemstone>) gemstoneDAO.listGemstones();
        return gemstones;
    }

    public ArrayList<Gemstone> getActiveGemstones() {

        ArrayList<Gemstone> gemstones = (ArrayList<Gemstone>) gemstoneDAO.listActiveGemstones();
        return gemstones;

    }

    public void addGemstone(Gemstone gemstone) {

        gemstoneDAO.saveGemstone(gemstone);
    }

    public void updateGemstone(Gemstone gemstone) {
        Gemstone gemstoneFromDb = gemstoneDAO.getGemstone(gemstone.getGemstoneId());
        gemstoneFromDb.setGemstoneName(gemstone.getGemstoneName());
        gemstoneFromDb.setGemstoneDescription(gemstone.getGemstoneDescription());
        gemstoneFromDb.setCreatedDate(null);
        gemstoneFromDb.setUpdatedDate(null);
        gemstoneDAO.saveGemstone(gemstoneFromDb);
    }

    public Gemstone getGemstoneById(long gemstoneId) {
        Gemstone gemstone = gemstoneDAO.getGemstone(gemstoneId);
        return gemstone;
    }

    public void deleteGemstone(Gemstone gemstone) {

    }
}
