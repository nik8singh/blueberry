package com.mana.spring.dto;

public class GemstoneDTO {

    private long gemstoneId;

    private String gemstoneName;

    private String gemstoneDescription;

    private boolean gemstoneActive;

    public GemstoneDTO() {
    }

    public long getGemstoneId() {
        return gemstoneId;
    }

    public void setGemstoneId(long gemstoneId) {
        this.gemstoneId = gemstoneId;
    }

    public String getGemstoneName() {
        return gemstoneName;
    }

    public void setGemstoneName(String gemstoneName) {
        this.gemstoneName = gemstoneName;
    }

    public String getGemstoneDescription() {
        return gemstoneDescription;
    }

    public void setGemstoneDescription(String gemstoneDescription) {
        this.gemstoneDescription = gemstoneDescription;
    }

    public boolean isGemstoneActive() {
        return gemstoneActive;
    }

    public void setGemstoneActive(boolean gemstoneActive) {
        this.gemstoneActive = gemstoneActive;
    }

    @Override
    public String toString() {
        return "\n\tGemstoneDTO{" +
                "\n\t\tgemstoneId='" + gemstoneId + '\'' +
                "\n\t\tgemstoneName='" + gemstoneName + '\'' +
                "\n\t\tgemstoneDescription='" + gemstoneDescription + '\'' +
                "\n\t\tgemstoneActive='" + gemstoneActive + '\'' +
                "\n\t}";
    }
}
