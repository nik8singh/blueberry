package com.mana.spring.dto;

public class GemstoneDTO {

    private String gemstoneName;

    private String gemstoneDescription;

    public GemstoneDTO() {
    }

    public GemstoneDTO(String gemstoneName, String gemstoneDescription) {
        this.gemstoneName = gemstoneName;
        this.gemstoneDescription = gemstoneDescription;
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

    @Override
    public String toString() {
        return "\n\tGemstoneDTO{" +
                "\n\t\tgemstoneName='" + gemstoneName + '\'' +
                "\n\t\tgemstoneDescription='" + gemstoneDescription + '\'' +
                "\n\t}";
    }
}
