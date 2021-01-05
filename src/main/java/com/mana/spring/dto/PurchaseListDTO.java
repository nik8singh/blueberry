package com.mana.spring.dto;

import com.mana.spring.domain.Purchase;

import java.util.ArrayList;

public class PurchaseListDTO {

    private ArrayList<PurchaseDTO> purchaseDTOS = new ArrayList<>();

    public ArrayList<PurchaseDTO> getPurchaseDTOS() {
        return purchaseDTOS;
    }

    public void setPurchaseDTOS(ArrayList<PurchaseDTO> purchaseDTOS) {
        this.purchaseDTOS = purchaseDTOS;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        for (Purchase p : purchases) {
            purchaseDTOS.add(PurchaseDTOConverter.convertToDTO(p));
        }
    }
}
