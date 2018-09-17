package service;

import domain.Gemstone;

import java.util.ArrayList;

public interface GemstoneService {

    ArrayList<Gemstone> getGemstones();
    void addGemstone(Gemstone gemstone);
}
