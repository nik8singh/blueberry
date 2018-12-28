package com.mana.spring.dto;

import java.io.File;
import java.io.FileInputStream;

public class ImageDTO {

    private long imageId;

    private String imageName;

    private String imagePanelName;

    private String imagePageName;

    private byte[] image;

    private File file;

    private int imagePriority;

    private long productId;

    public ImageDTO() {
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

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
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
