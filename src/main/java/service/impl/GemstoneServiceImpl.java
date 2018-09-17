package service.impl;

import domain.Gemstone;
import service.GemstoneService;

import java.util.ArrayList;
import java.util.Date;

public class GemstoneServiceImpl implements GemstoneService {

    public ArrayList<Gemstone> getGemstones() {

        ArrayList<Gemstone> list = new ArrayList<Gemstone>();
        Gemstone gemstone = new Gemstone();

        gemstone.setGemstoneName("Emerald");
        gemstone.setGemstoneDescription("Architecture is both the process and product of planning, designing and construction. Architectural works, in the material form of buildings, are often perceived as cultural symbols and as works of art. Historical civilizations are often identified with their surviving architectural achievements.");
        gemstone.setCreatedDate(new Date());
        gemstone.setUpdatedDate(new Date());

        list.add(gemstone);

        gemstone = new Gemstone();
        gemstone.setGemstoneName("Ruby");
        gemstone.setGemstoneDescription("An arch is a structure that spans a space and supports a load. Arches appeared as early as the 2nd millennium BC in Mesopotamian brick architecture and their systematic use started with the Ancient Romans who were the first to apply the technique to a wide range of structures.");
        gemstone.setCreatedDate(new Date());
        gemstone.setUpdatedDate(new Date());

        list.add(gemstone);

        return list;

    }

    public void addGemstone(Gemstone gemstone) {

        // add to database

        System.out.println(gemstone.getGemstoneName() + "/n" +gemstone.getGemstoneDescription());

        System.out.println("gemstone added to DB");

    }
}
