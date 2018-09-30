package com.mana.spring.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gemstone")
public class Gemstone {

    @Id
    @GeneratedValue
    @Column(name = "gemstone_id")
    private long gemstoneId;

    @Column(name = "gemstone_name", nullable = false)
    private String gemstoneName;

    @Column(name = "gemstone_description", nullable = false)
    private String gemstoneDescription;

    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    public Gemstone() {
    }

    public Gemstone(String gemstoneName, String gemstoneDescription) {
        this.gemstoneName = gemstoneName;
        this.gemstoneDescription = gemstoneDescription;

    }

    public Gemstone(String gemstoneName, String gemstoneDescription, Date createdDate, Date updatedDate) {
        this.gemstoneName = gemstoneName;
        this.gemstoneDescription = gemstoneDescription;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public long getGemstoneId() {
        return gemstoneId;
    }

    public String getGemstoneName() {
        return gemstoneName;
    }

    public String getGemstoneDescription() {
        return gemstoneDescription;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setGemstoneId(long gemstoneId) {
        this.gemstoneId = gemstoneId;
    }

    public void setGemstoneName(String gemstoneName) {
        this.gemstoneName = gemstoneName;
    }

    public void setGemstoneDescription(String gemstoneDescription) {
        this.gemstoneDescription = gemstoneDescription;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


    @Override
    public String toString() {
        return "Gemstone{" +
                "gemstoneId=" + gemstoneId +
                ", gemstoneName='" + gemstoneName + '\'' +
                ", gemstoneDescription='" + gemstoneDescription + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
