package com.mana.spring.dao;

import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.Product;
import com.mana.spring.domain.Purchase;

import java.util.List;

public interface PurchaseDAO {

    void savePurchase(Purchase purchase);

    List listPurchase(Invoice invoice);

    List listPurchase(Product product);

}
