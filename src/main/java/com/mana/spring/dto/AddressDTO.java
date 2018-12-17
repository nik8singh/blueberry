package com.mana.spring.dto;

public class AddressDTO {

    private long addressId;

    private String addressFullname;

    private String addressLineOne;

    private String addressLineTwo;

    private String addressCity;

    private String addressState;

    private String addressZipcode;

    private String addressCountry;

    private boolean active;

    private UserDTO userDTO;

    private ShopDTO shopDTO;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getAddressFullname() {
        return addressFullname;
    }

    public void setAddressFullname(String addressFullname) {
        this.addressFullname = addressFullname;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZipcode() {
        return addressZipcode;
    }

    public void setAddressZipcode(String addressZipcode) {
        this.addressZipcode = addressZipcode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ShopDTO getShopDTO() {
        return shopDTO;
    }

    public void setShopDTO(ShopDTO shopDTO) {
        this.shopDTO = shopDTO;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "\nAddressDTO{" +
                "\naddressId=" + addressId +
                "\n addressFullname='" + addressFullname + '\'' +
                "\n addressLineOne='" + addressLineOne + '\'' +
                "\n addressLineTwo='" + addressLineTwo + '\'' +
                "\n addressCity='" + addressCity + '\'' +
                "\n addressState='" + addressState + '\'' +
                "\n addressZipcode='" + addressZipcode + '\'' +
                "\n addressCountry='" + addressCountry + '\'' +
                "\n active=" + active +
                "\n userDTO=" + userDTO +
                "\n shopDTO=" + shopDTO +
                '}';
    }
}
