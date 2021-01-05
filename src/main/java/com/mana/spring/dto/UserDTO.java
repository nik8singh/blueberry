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

    private String note;

    private boolean deleted;

    private Set<UserAuthorityDTO> userAuthorityDTO = new HashSet<>(0);

    private Set<AddressDTO> addressesDto = new HashSet<>(0);

    private Set<CartItemDTO> cartItemDTOS = new HashSet<>(0);

    private Set<OrderDTO> orderDTOS = new HashSet<>(0);

    private double totalBuys;

    private double totalBusiness;

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

    public Set<UserAuthorityDTO> getUserAuthorityDTO() {
        return userAuthorityDTO;
    }

    public void setUserAuthorityDTO(Set<UserAuthorityDTO> userAuthorityDTO) {
        this.userAuthorityDTO = userAuthorityDTO;
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

    public Set<CartItemDTO> getCartItemDTOS() {
        return cartItemDTOS;
    }

    public void setCartItemDTOS(Set<CartItemDTO> cartItemDTOS) {
        this.cartItemDTOS = cartItemDTOS;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<OrderDTO> getOrderDTOS() {
        return orderDTOS;
    }

    public void setOrderDTOS(Set<OrderDTO> orderDTOS) {
        this.orderDTOS = orderDTOS;
        this.totalBuys = 0;
        this.totalBusiness = 0;
        for (OrderDTO orderDTO : orderDTOS)
            if (!orderDTO.getOrderStatus().equals("Not Executed")) {
                this.totalBuys++;
                this.totalBusiness += orderDTO.getFinalTotal();
            }
    }

    public double getTotalBuys() {
        return totalBuys;
    }

    public double getTotalBusiness() {
        return totalBusiness;
    }

    @Override
    public String toString() {
        return "\nUserDTO{" +
                "\nuserId=" + userId +
                "\n userFirstName='" + userFirstName + '\'' +
                "\n userLastName='" + userLastName + '\'' +
                "\n userEmail='" + userEmail + '\'' +
                "\n authorizationLevel='" + userAuthorityDTO + '\'' +
                "\n deleted=" + deleted +
                "\n note=" + note +
                "\n addressesDto=" + addressesDto +
                "\n cartItemDTOS=" + cartItemDTOS +
                "\n orderDTOS=" + orderDTOS +
                "\n totalBuys=" + totalBuys +
                "\n totalBusiness=" + totalBusiness +
                '}';
    }
}
