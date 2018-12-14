package com.mana.spring.dto;

import java.io.File;
import java.io.FileInputStream;

public class ImageDTO {

    private long imageId;

    private String imageSiteLocation;

    private byte[] image;

    private File file;

    private int imagePriority;

    private long productId;

    public ImageDTO() {
    }


    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getImageSiteLocation() {
        return imageSiteLocation;
    }

    public void setImageSiteLocation(String imageSiteLocation) {
        this.imageSiteLocation = imageSiteLocation;
    }

    public int getImagePriority() {
        return imagePriority;
    }

    public void setImagePriority(int imagePriority) {
        this.imagePriority = imagePriority;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setImage(bFile);
    }
}
