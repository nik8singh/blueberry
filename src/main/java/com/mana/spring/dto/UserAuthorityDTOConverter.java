package com.mana.spring.dto;


import com.mana.spring.domain.UserAuthority;

public class UserAuthorityDTOConverter {

    public static UserAuthorityDTO convertToDTO(UserAuthority userAuthority) {
        UserAuthorityDTO userAuthorityDTO = new UserAuthorityDTO();
        userAuthorityDTO.setAuthorityId(userAuthority.getAuthorityId());
        userAuthorityDTO.setRole(userAuthority.getRole());

        return userAuthorityDTO;
    }
}
