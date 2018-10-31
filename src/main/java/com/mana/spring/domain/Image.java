package com.mana.spring.domain;

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

    @Column(name = "image_file")
    private byte[] imageFile;

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

    public byte[] getImageFile() {
        return imageFile;
    }

    public void setImageFile(byte[] imageFile) {
        this.imageFile = imageFile;
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
        return "Image{" +
                "imageId=" + imageId +
                ", imageSiteLocation=" + imageSiteLocation +
                ", imageFile=" + imageFile +
                ", imagePriority=" + imagePriority +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
