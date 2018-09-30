package com.mana.spring.service.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.dao.impl.GemstoneDAOImpl;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.service.GemstoneService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

@Transactional
public class GemstoneServiceImpl implements GemstoneService {

    @Autowired
    private GemstoneDAO gemstoneDAO;

    public ArrayList<Gemstone> getGemstones() {
        return (ArrayList<Gemstone>) gemstoneDAO.listGemstone();
    }

    public void addUpdateGemstone(Gemstone gemstone) {
            gemstoneDAO.saveGemstone(gemstone);
    }

    public void deleteGemstone(Gemstone gemstone) {
        gemstoneDAO.deleteGemstone(gemstone);
    }
}
