package com.mana.spring.dto;

public class ImageDTO {

    private long imageId;

    private String image_public_id;

    private String imagePanelName;

    private String imagePageName;

    private int imagePriority;

    private String image_tags;

    private float image_quality;

    private float image_width;

    private float image_height;

    private String image_format;

    private String image_secure_url;

    private String image_backup_url;

    private long productId;

    public ImageDTO() {
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    //    public void setFile(File file) {
//        this.file = file;
//        byte[] bFile = new byte[(int) file.length()];
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            //convert file into array of bytes
//            fileInputStream.read(bFile);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        setImage(bFile);
//    }


    @Override
    public String toString() {
        return "ImageDTO{" +
                "\nimageId=" + imageId +
                "\nimage_public_id='" + image_public_id + '\'' +
                "\nimagePanelName='" + imagePanelName + '\'' +
                "\nimagePageName='" + imagePageName + '\'' +
                "\nimagePriority=" + imagePriority +
                "\nimage_tags='" + image_tags + '\'' +
                "\nimage_quality=" + image_quality +
                "\nimage_width=" + image_width +
                "\nimage_height=" + image_height +
                "\nimage_format='" + image_format + '\'' +
                "\nimage_secure_url='" + image_secure_url + '\'' +
                "\nimage_backup_url='" + image_backup_url + '\'' +
                "\nproductId=" + productId +
                '}';
    }
}
