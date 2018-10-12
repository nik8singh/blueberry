package com.mana.spring.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @Column(name = "shop_desrciption", nullable = false)
    private String shopDescription;

    @Column(name = "booth_number", nullable = false)
    private String boothNumber;

    @Column(name = "shop_start_date", nullable = false)
    private Date shopStartDate;

    @Column(name = "shop_end_date", nullable = false)
    private Date shopEndDate;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_address", nullable = false)
    private Address shopAddress;

    public Shop() {
    }

    public Shop(String shopName, String shopDescription, String boothNumber, Date shopStartDate, Date shopEndDate, Date createdDate, Date updatedDate, Address shopAddress) {
        this.shopName = shopName;
        this.shopDescription = shopDescription;
        this.boothNumber = boothNumber;
        this.shopStartDate = shopStartDate;
        this.shopEndDate = shopEndDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.shopAddress = shopAddress;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Address getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Override
    public String toString() {
        return "shop{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", shopDescription='" + shopDescription + '\'' +
                ", boothNumber='" + boothNumber + '\'' +
                ", shopStartDate=" + shopStartDate +
                ", shopEndDate=" + shopEndDate +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", shopAddress=" + shopAddress +
                '}';
    }
}
