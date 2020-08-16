package com.mana.spring.dto;

import com.mana.spring.domain.User;

public class NewUserDTOConverter {

    public static User convertToDomain(NewUserDTO newUserDTO) {
        User user = new User();
        user.setUserId(newUserDTO.getUserId());
        user.setUserFirstName(newUserDTO.getUserFirstName());
        user.setUserLastName(newUserDTO.getUserLastName());
        user.setUserEmail(newUserDTO.getUserEmail());
        return user;
    }
}
