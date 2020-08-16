package com.mana.spring.dto;


import java.util.ArrayList;

public class UserAuthorityListDTO {

    private ArrayList<UserAuthorityDTO> userAuthorityDTOS;

    public UserAuthorityListDTO() {
        userAuthorityDTOS = new ArrayList<>();
    }

    public ArrayList<UserAuthorityDTO> getUserAuthorityDTOS() {
        return userAuthorityDTOS;
    }

    public void setUserAuthorityDTOS(ArrayList<UserAuthorityDTO> userAuthorityDTOS) {
        this.userAuthorityDTOS = userAuthorityDTOS;
    }
}
