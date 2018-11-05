package com.mana.spring.dto;

public class MetalDTO {

    private String metalName;

    private String metalDescription;

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

    @Override
    public String toString() {
        return "\n\tMetalDTO{" +
                "\n\t\tmetalName='" + metalName + '\'' +
                "\n\t\tmetalDescription='" + metalDescription + '\'' +
                "\n\t}";
    }
}
