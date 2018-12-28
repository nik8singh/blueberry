package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long imageId;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_panel_name")
    private String imagePanelName;

    @Column(name = "image_page_name")
    private String imagePageName;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_priority")
    private int imagePriority;

    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "productId")
    private Product product;

    public Image() {
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePanelName() {
        return imagePanelName;
    }

    public void setImagePanelName(String imagePanelName) {
        this.imagePanelName = imagePanelName;
    }

    public String getImagePageName() {
        return imagePageName;
    }

    public void setImagePageName(String imagePageName) {
        this.imagePageName = imagePageName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
                "\nimageId=" + imageId +
                "\n\tImageName='" + imageName + '\'' +
                "\n\timagePanelName='" + imagePanelName + '\'' +
                "\n\timagePageName='" + imagePageName + '\'' +
                "\n\timage=" + Arrays.toString(image) +
                "\n\timagePriority=" + imagePriority +
                "\n\tcreatedDate=" + createdDate +
                "\n\tupdatedDate=" + updatedDate +
                "\n\tproduct=" + product +
                '}';
    }
}
