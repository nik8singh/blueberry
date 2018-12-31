package com.mana.spring.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private long shopId;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "shop_desrciption")
    private String shopDescription;

    @Column(name = "booth_number")
    private String boothNumber;

    @Column(name = "shop_start_date")
    private Date shopStartDate;

    @Column(name = "shop_end_date")
    private Date shopEndDate;

    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_address")
    private Address shopAddress;

    public Shop() {
    }

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
        return "\nshop{" +
                "\n\tshopId= " + shopId +
                "\n\tshopName= " + shopName +
                "\n\tshopDescription= " + shopDescription +
                "\n\tboothNumber= " + boothNumber +
                "\n\tshopStartDate= " + shopStartDate +
                "\n\tshopEndDate= " + shopEndDate +
                "\n\tcreatedDate= " + createdDate +
                "\n\tupdatedDate= " + updatedDate +
                "\n\tshopAddress= " + shopAddress +
                '}';
    }
}
