package com.mana.spring.dao;

import com.mana.spring.domain.Show;

import java.util.List;

public interface ShowDAO {

    void saveShow(Show show);

    void updateShow(Show show);

    void deleteShow(Show show);

    List listShow();
}
