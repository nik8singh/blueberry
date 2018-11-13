package com.mana.spring.dto;

public class JewelryTypeDTO {

    private long jewelryTypeId;

    private String jewelryTypeName;

    private String jewelryTypeDescription;

    private boolean jewelryTypeActive;

    public JewelryTypeDTO() {
    }

    public long getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(long jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
    }

    public String getJewelryTypeName() {
        return jewelryTypeName;
    }

    public void setJewelryTypeName(String jewelryTypeName) {
        this.jewelryTypeName = jewelryTypeName;
    }

    public String getJewelryTypeDescription() {
        return jewelryTypeDescription;
    }

    public void setJewelryTypeDescription(String jewelryTypeDescription) {
        this.jewelryTypeDescription = jewelryTypeDescription;
    }

    public boolean isJewelryTypeActive() {
        return jewelryTypeActive;
    }

    public void setJewelryTypeActive(boolean jewelryTypeActive) {
        this.jewelryTypeActive = jewelryTypeActive;
    }

    @Override
    public String toString() {
        return "\nJewelryTypeDTO{" +
                "\n\tjewelryTypeId=" + jewelryTypeId +
                "\n\tjewelryTypeName='" + jewelryTypeName + '\'' +
                "\n\tjewelryTypeDescription='" + jewelryTypeDescription + '\'' +
                "\n\tjewelryTypeActive=" + jewelryTypeActive +
                '}';
    }
}
