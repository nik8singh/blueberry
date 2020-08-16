package com.mana.spring.dto;

import java.util.Date;

public class ShopDTO {

    private long shopId;

    private String shopName;

    private String shopDescription;

    private String shopPrivateNote;

    private String boothNumber;

    private Date shopStartDate;

    private Date shopEndDate;

    private double shopSale;

    private double shopExpense;

    private long addressId;

    private String addressFullname;

    private String addressLineOne;

    private String addressLineTwo;

    private String addressCity;

    private String addressState;

    private String addressZipcode;

    private String addressCountry;

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getShopPrivateNote() {
        return shopPrivateNote;
    }

    public void setShopPrivateNote(String shopPrivateNote) {
        this.shopPrivateNote = shopPrivateNote;
    }

    public String getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(String boothNumber) {
        this.boothNumber = boothNumber;
    }

    public Date getShopStartDate() {
        return shopStartDate;
    }

    public void setShopStartDate(Date shopStartDate) {
        this.shopStartDate = shopStartDate;
    }

    public Date getShopEndDate() {
        return shopEndDate;
    }

    public void setShopEndDate(Date shopEndDate) {
        this.shopEndDate = shopEndDate;
    }

    public double getShopSale() {
        return shopSale;
    }

    public void setShopSale(double shopSale) {
        this.shopSale = shopSale;
    }

    public double getShopExpense() {
        return shopExpense;
    }

    public void setShopExpense(double shopExpense) {
        this.shopExpense = shopExpense;
    }

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


    @Override
    public String toString() {
        return "\nShopDTO{" +
                "\n\tshopId=" + shopId +
                "\n\tshopName='" + shopName + '\'' +
                "\n\tshopDescription='" + shopDescription + '\'' +
                "\n\taddressId=" + shopPrivateNote +
                "\n\tboothNumber='" + boothNumber + '\'' +
                "\n\tshopStartDate=" + shopStartDate +
                "\n\tshopEndDate=" + shopEndDate +
                "\n\tshopSale=" + shopSale +
                "\n\tshopExpense=" + shopExpense +
                "\n\taddressId=" + addressId +
                "\n\taddressFullname='" + addressFullname + '\'' +
                "\n\taddressLineOne='" + addressLineOne + '\'' +
                "\n\taddressLineTwo='" + addressLineTwo + '\'' +
                "\n\taddressCity='" + addressCity + '\'' +
                "\n\taddressState='" + addressState + '\'' +
                "\n\taddressZipcode='" + addressZipcode + '\'' +
                "\n\taddressCountry='" + addressCountry + '\'' +
                '}';
    }
}
