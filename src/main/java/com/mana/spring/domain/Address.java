package com.mana.spring.domain;

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

    @Column(name = "address_fullname", nullable = false)
    private String addressFullname;

    @Column(name = "address_street", nullable = false)
    private String addressStreet;

    @Column(name = "address_unit", nullable = false)
    private String addressUnit;

    @Column(name = "address_city", nullable = false)
    private String addressCity;

    @Column(name = "address_state", nullable = false)
    private String addressState;

    @Column(name = "address_zipcode", nullable = false)
    private String addressZipcode;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @ManyToMany(mappedBy = "addresses")
    private Set<User> user = new HashSet<User>(0);

//    @OneToOne(mappedBy="showAddress")
//    private Show show;

    public Address() {
    }

    public Address(String addressFullname, String addressStreet, String addressUnit, String addressCity, String addressState, String addressZipcode, Date createdDate, Date updatedDate, Set<User> user) {
        this.addressFullname = addressFullname;
        this.addressStreet = addressStreet;
        this.addressUnit = addressUnit;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressZipcode = addressZipcode;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.user = user;
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

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressUnit() {
        return addressUnit;
    }

    public void setAddressUnit(String addressUnit) {
        this.addressUnit = addressUnit;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressZipcode() {
        return addressZipcode;
    }

    public void setAddressZipcode(String addressZipcode) {
        this.addressZipcode = addressZipcode;
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

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

//    public Show getShow() {
//        return show;
//    }
//
//    public void setShow(Show show) {
//        this.show = show;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addressFullname='" + addressFullname + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", addressUnit='" + addressUnit + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressState='" + addressState + '\'' +
                ", addressZipcode='" + addressZipcode + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
