package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @Column(name = "image_site_location")
    private String imageSiteLocation;

    @Column(name = "image_server_location")
    private String imageServerLocation;

    @Column(name = "image_priority")
    private int imagePriority;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "productId")
    private Product product;

    public Image() {
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageSiteLocation() {
        return imageSiteLocation;
    }

    public void setImageSiteLocation(String imageSiteLocation) {
        this.imageSiteLocation = imageSiteLocation;
    }

    public String getImageServerLocation() {
        return imageServerLocation;
    }

    public void setImageServerLocation(String imageFile) {
        this.imageServerLocation = imageFile;
    }

    public int getImagePriority() {
        return imagePriority;
    }

    public void setImagePriority(int imagePriority) {
        this.imagePriority = imagePriority;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "\nImage{" +
                "\n\timageId= " + imageId +
                "\n\timageSiteLocation= " + imageSiteLocation +
                "\n\timageServerLocation= " + imageServerLocation +
                "\n\timagePriority= " + imagePriority +
                "\n\tcreatedDate= " + createdDate +
                "\n\tupdatedDate= " + updatedDate +
                '}';
    }
}
