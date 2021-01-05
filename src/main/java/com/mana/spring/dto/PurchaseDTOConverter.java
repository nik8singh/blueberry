package com.mana.spring.dto;

import com.mana.spring.domain.Purchase;

public class PurchaseDTOConverter {

    public static PurchaseDTO convertToDTO(Purchase purchase) {
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setPurchaseId(purchase.getPurchaseId());
        purchaseDTO.setProductQuantity(purchase.getProductQuantity());
        purchaseDTO.setProductDTO(ProductDTOConverter.convertToDTO(purchase.getProduct()));
        return purchaseDTO;
    }

}
