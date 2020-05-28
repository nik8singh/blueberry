package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long imageId;

    @Column(name = "image_public_id")
    @NotBlank(message = "Please enter an image_public_id")
    private String image_public_id;

    @Column(name = "image_panel_name")
    private String imagePanelName;

    @Column(name = "image_page_name")
    private String imagePageName;

    @Column(name = "image_priority")
    private int imagePriority;

    @Column(name = "image_tags")
    private String image_tags;

    @Column(name = "image_quality")
    private float image_quality;

    @Column(name = "image_width")
    private float image_width;

    @Column(name = "image_height")
    private float image_height;

    @Column(name = "image_format")
    private String image_format;

    @Column(name = "image_secure_url")
    private String image_secure_url;

    @Column(name = "image_backup_url")
    private String image_backup_url;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "productId")
    @JsonIgnore
    private Product product;

    @JsonIgnore
    private static long imageCounter;

    static {
        imageCounter = 0;
    }

    public Image() {
    }

    public static long getImageCounter() {
        return imageCounter;
    }

    public static void setImageCounter(long imageCounter) {
        Image.imageCounter = imageCounter;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getImage_public_id() {
        return image_public_id;
    }

    public void setImage_public_id(String image_public_id) {
        this.image_public_id = image_public_id;
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

    public String getImage_tags() {
        return image_tags;
    }

    public void setImage_tags(String image_tags) {
        this.image_tags = image_tags;
    }

    public float getImage_quality() {
        return image_quality;
    }

    public void setImage_quality(float image_quality) {
        this.image_quality = image_quality;
    }

    public float getImage_width() {
        return image_width;
    }

    public void setImage_width(float image_width) {
        this.image_width = image_width;
    }

    public float getImage_height() {
        return image_height;
    }

    public void setImage_height(float image_height) {
        this.image_height = image_height;
    }

    public String getImage_format() {
        return image_format;
    }

    public void setImage_format(String image_format) {
        this.image_format = image_format;
    }

    public String getImage_secure_url() {
        return image_secure_url;
    }

    public void setImage_secure_url(String image_secure_url) {
        this.image_secure_url = image_secure_url;
    }

    public String getImage_backup_url() {
        return image_backup_url;
    }

    public void setImage_backup_url(String image_backup_url) {
        this.image_backup_url = image_backup_url;
    }

    @Override
    public String toString() {
        return "\nImage{" +
                "\nimageId=" + imageId +
                "\n\timage_public_id='" + image_public_id + '\'' +
                "\n\timagePanelName='" + imagePanelName + '\'' +
                "\n\timagePageName='" + imagePageName + '\'' +
                "\n\timagePriority=" + imagePriority +
                "\n\timage_tags=" + image_tags +
                "\n\timage_quality=" + image_quality +
                "\n\timage_width=" + image_width +
                "\n\timage_height=" + image_height +
                "\n\timage_format=" + image_format +
                "\n\timage_secure_url=" + image_secure_url +
                "\n\timage_backup_url=" + image_backup_url +
                "\n\tcreatedDate=" + createdDate +
                "\n\tupdatedDate=" + updatedDate +
                "\n\tproduct=" + product +
                '}';
    }
}
