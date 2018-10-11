package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "show")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private Long showId;

    @Column(name = "show_name", nullable = false)
    private String showName;

    @Column(name = "show_desrciption", nullable = false)
    private String showDescription;

    @Column(name = "booth_number", nullable = false)
    private String boothNumber;

    @Column(name = "show_start_date", nullable = false)
    private Date showStartDate;

    @Column(name = "show_end_date", nullable = false)
    private Date showEndDate;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "show_address")
    private Address showAddress;

    public Show() {
    }

    public Show(String showName, String showDescription, String boothNumber, Date showStartDate, Date showEndDate, Date createdDate, Date updatedDate, Address showAddress) {
        this.showName = showName;
        this.showDescription = showDescription;
        this.boothNumber = boothNumber;
        this.showStartDate = showStartDate;
        this.showEndDate = showEndDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.showAddress = showAddress;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowDescription() {
        return showDescription;
    }

    public void setShowDescription(String showDescription) {
        this.showDescription = showDescription;
    }

    public String getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(String boothNumber) {
        this.boothNumber = boothNumber;
    }

    public Date getStartDate() {
        return showStartDate;
    }

    public void setStartDate(Date showStartDate) {
        this.showStartDate = showStartDate;
    }

    public Date getShowEndDate() {
        return showEndDate;
    }

    public void setShowEndDate(Date showEndDate) {
        this.showEndDate = showEndDate;
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

    public Address getShowAddress() {
        return showAddress;
    }

    public void setShowAddress(Address showAddress) {
        this.showAddress = showAddress;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", showName='" + showName + '\'' +
                ", showDescription='" + showDescription + '\'' +
                ", boothNumber='" + boothNumber + '\'' +
                ", showStartDate=" + showStartDate +
                ", showEndDate=" + showEndDate +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", showAddress=" + showAddress +
                '}';
    }
}
