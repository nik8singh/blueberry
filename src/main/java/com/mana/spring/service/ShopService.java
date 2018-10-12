package com.mana.spring.service;

import com.mana.spring.domain.Shop;

import java.util.ArrayList;

public interface ShopService {
    ArrayList<Shop> getShops();

    void addShop(Shop shop);

    void updateShop(Shop shop);

    void deleteShop(Shop shop);
}
