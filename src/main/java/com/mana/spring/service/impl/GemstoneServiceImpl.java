package com.mana.spring.service.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.dao.impl.GemstoneDAOImpl;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.service.GemstoneService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Transactional
public class GemstoneServiceImpl implements GemstoneService {

    @Autowired
    private GemstoneDAO gemstoneDAO;

    public ArrayList<Gemstone> getGemstones() {

//        ArrayList<Gemstone> list = new ArrayList<Gemstone>();
//        Gemstone gemstone = new Gemstone("Emerald", "Architecture is both the process and product of planning, designing and construction. Architectural works, in the material form of buildings, are often perceived as cultural symbols and as works of art. Historical civilizations are often identified with their surviving architectural achievements.");
//
//        list.add(gemstone);
//
//        gemstone = new Gemstone();
//        gemstone.setGemstoneName("Ruby");
//        gemstone.setGemstoneDescription("An arch is a structure that spans a space and supports a load. Arches appeared as early as the 2nd millennium BC in Mesopotamian brick architecture and their systematic use started with the Ancient Romans who were the first to apply the technique to a wide range of structures.");
//        gemstone.setCreatedDate(new Date());
//        gemstone.setUpdatedDate(new Date());
//
//        list.add(gemstone);


        return (ArrayList<Gemstone>) gemstoneDAO.listGemstone();

    }

    public void addGemstone(Gemstone gemstone) {

        // add to database
        gemstoneDAO.createGemstone(gemstone);

    }
}
