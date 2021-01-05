package com.mana.spring.dto;

public class PurchaseDTO {

    private long purchaseId;

    private int productQuantity;

    private ProductDTO productDTO;


    public PurchaseDTO() {
    }

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "\nPurchaseDTO{" +
                "\npurchaseId=" + purchaseId +
                "\n productQuantity=" + productQuantity +
                "\n productDTO=" + productDTO +
                '}';
    }
}
