package com.mana.spring.service.impl;

import com.mana.spring.dao.ShowDAO;
import com.mana.spring.domain.Show;
import com.mana.spring.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowDAO showDAO;

    public ArrayList<Show> getShows() {
        return (ArrayList<Show>) showDAO.listShow();
    }

    public void addShow(Show show) {
        showDAO.saveShow(show);
    }

    public void updateShow(Show show) {
        showDAO.updateShow(show);
    }

    public void deleteShow(Show show) {
        showDAO.deleteShow(show);
    }

}
