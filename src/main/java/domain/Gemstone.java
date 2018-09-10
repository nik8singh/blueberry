package domain;

import java.util.Date;

public class Gemstone {

    private long gemstoneId;
    private String gemstoneName;
    private String gemstoneDescription;
    private Date createdDate;
    private Date updatedDate;

    public long getGenstoneId() {
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

    public void setGenstoneId(long gemstoneId) {
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
}
