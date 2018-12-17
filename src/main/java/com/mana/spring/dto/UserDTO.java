package com.mana.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {


    private long userId;

    private String userFirstName;

    private String userLastName;

    private String userEmail;

    @JsonIgnore
    private String userPassword;

    private String authorizationLevel;

    private boolean deleted;

    private Set<AddressDTO> addressesDto = new HashSet<AddressDTO>(0);

    public UserDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAuthorizationLevel() {
        return authorizationLevel;
    }

    public void setAuthorizationLevel(String authorizationLevel) {
        this.authorizationLevel = authorizationLevel;
    }

    public Set<AddressDTO> getAddressesDto() {
        return addressesDto;
    }

    public void setAddressesDto(Set<AddressDTO> addressesDto) {
        this.addressesDto = addressesDto;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "\nUserDTO{" +
                "\nuserId=" + userId +
                "\n userFirstName='" + userFirstName + '\'' +
                "\n userLastName='" + userLastName + '\'' +
                "\n userEmail='" + userEmail + '\'' +
                "\n userPassword='" + userPassword + '\'' +
                "\n authorizationLevel='" + authorizationLevel + '\'' +
                "\n deleted=" + deleted +
                "\n addressesDto=" + addressesDto +
                '}';
    }
}
