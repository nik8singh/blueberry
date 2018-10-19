package com.mana.spring.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "jewelry_type")
public class JewelryType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "jewelry_type_id")
    private long jewelryTypeId;

    @Column(name = "jewelry_type_name", nullable = false)
    private String jewelryTypeName;

    @Column(name = "jewelry_type_description")
    private String jewelryTypeDescription;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productJewelryType", fetch = FetchType.EAGER)//, orphanRemoval = true)
    private List<Product> product = new ArrayList<Product>();

    public JewelryType() {
    }

    public JewelryType(String jewelryTypeName, String jewelryTypeDescription, Date createdDate, Date updatedDate) {
        this.jewelryTypeName = jewelryTypeName;
        this.jewelryTypeDescription = jewelryTypeDescription;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public long getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(long jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
    }

    public String getJewelryTypeName() {
        return jewelryTypeName;
    }

    public void setJewelryTypeName(String jewelryTypeName) {
        this.jewelryTypeName = jewelryTypeName;
    }

    public String getJewelryTypeDescription() {
        return jewelryTypeDescription;
    }

    public void setJewelryTypeDescription(String jewelryTypeDescription) {
        this.jewelryTypeDescription = jewelryTypeDescription;
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
        return "JewelryType{" +
                "jewelryTypeId=" + jewelryTypeId +
                ", jewelryTypeName='" + jewelryTypeName + '\'' +
                ", jewelryTypeDescription='" + jewelryTypeDescription + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
