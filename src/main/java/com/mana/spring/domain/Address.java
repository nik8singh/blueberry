package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_fullname")
    private String addressFullname;

    @Column(name = "address_lineone")
    private String addressLineOne;

    @Column(name = "address_linetwo")
    private String addressLineTwo;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_state")
    private String addressState;

    @Column(name = "address_zipcode")
    private String addressZipcode;

    @Column(name = "address_country")
    private String addressCountry;

    @Column(name = "created_date", columnDefinition = "TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date", columnDefinition = "TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @JsonIgnore
    @ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
    private Set<User> user = new HashSet<User>(0);

    @JsonIgnore
    @OneToOne(mappedBy ="shopAddress")
    private Shop shopAddress;

    public Address() {
    }

    public Address(String addressFullname, String addressLineOne, String addressLineTwo, String addressCity, String addressState, String addressZipcode, String addressCountry, Date createdDate, Date updatedDate) {
        this.addressFullname = addressFullname;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressZipcode = addressZipcode;
        this.addressCountry = addressCountry;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
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

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Shop getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Shop shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Override
    public String toString() {
        return "\n\t\tAddress{ " +
                "\n\t\taddressId= " + addressId +
                "\n\t\taddressFullname= " + addressFullname+
                "\n\t\taddressLineOne= " + addressLineOne+
                "\n\t\taddressLineTwo= " + addressLineTwo +
                "\n\t\taddressCity= " + addressCity +
                "\n\t\taddressState= " + addressState +
                "\n\t\taddressZipcode= " + addressZipcode +
                "\n\t\taddressCountry= " + addressCountry  +
                "\n\t\tcreatedDate= " + createdDate +
                "\n\t\tupdatedDate= " + updatedDate +
                "\n\t\t}";
    }
}
