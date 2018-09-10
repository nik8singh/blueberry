package web;

import domain.Gemstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.GemstoneService;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/gemstone")
public class GemstoneController {


    @Autowired
    public GemstoneService gemstoneService;

    @RequestMapping(value = "all",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ArrayList<Gemstone> getAllGemstones() {

        gemstoneService.getGemstones();

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

}
