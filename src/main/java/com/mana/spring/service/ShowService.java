package com.mana.spring.service;

import com.mana.spring.domain.Show;

import java.util.ArrayList;

public interface ShowService {

    ArrayList<Show> getShows();

    void addShow(Show show);

    void updateShow(Show show);

    void deleteShow(Show show);
}
