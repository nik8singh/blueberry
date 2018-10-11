package com.mana.spring.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "metal")
public class Metal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "metal_id")
    private long metalId;

    @Column(name = "metal_name", nullable = false)
    private String metalName;

    @Column(name = "metal_description")
    private String metalDescription;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    public Metal() {
    }

    public Metal(String metalName, String metalDescription, Date createdDate, Date updatedDate) {
        this.metalName = metalName;
        this.metalDescription = metalDescription;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public long getMetalId() {
        return metalId;
    }

    public void setMetalId(long metalId) {
        this.metalId = metalId;
    }

    public String getMetalName() {
        return metalName;
    }

    public void setMetalName(String metalName) {
        this.metalName = metalName;
    }

    public String getMetalDescription() {
        return metalDescription;
    }

    public void setMetalDescription(String metalDescription) {
        this.metalDescription = metalDescription;
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

    @Override
    public String toString() {
        return "metal{" +
                "metalId=" + metalId +
                ", metalName='" + metalName + '\'' +
                ", metalDescription='" + metalDescription + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
