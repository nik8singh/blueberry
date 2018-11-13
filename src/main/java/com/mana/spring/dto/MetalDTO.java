package com.mana.spring.dto;

public class MetalDTO {

    private long metalId;

    private String metalName;

    private String metalDescription;

    private boolean metalActive;


    public MetalDTO(String metalName, String metalDescription) {
        this.metalName = metalName;
        this.metalDescription = metalDescription;
    }

    public MetalDTO() {
    }

    public String getMetalName() {
        return metalName;
    }

    public void setMetalName(String metalName) {
        this.metalName = metalName;
    }

    public String getMetalDescription() {
        return metalDescription;
    }

    public void setMetalDescription(String metalDescription) {
        this.metalDescription = metalDescription;
    }

    public long getMetalId() {
        return metalId;
    }

    public void setMetalId(long metalId) {
        this.metalId = metalId;
    }

    public boolean isMetalActive() {
        return metalActive;
    }

    public void setMetalActive(boolean metalActive) {
        this.metalActive = metalActive;
    }

    @Override
    public String toString() {
        return "\n\tMetalDTO{" +
                "\n\t\tmetalId='" + metalId + '\'' +
                "\n\t\tmetalName='" + metalName + '\'' +
                "\n\t\tmetalDescription='" + metalDescription + '\'' +
                "\n\t\tmetalActive='" + metalActive + '\'' +
                "\n\t}";
    }
}
