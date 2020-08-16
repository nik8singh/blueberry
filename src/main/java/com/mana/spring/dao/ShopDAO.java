package com.mana.spring.dao;

import com.mana.spring.domain.Shop;

import java.util.List;

public interface ShopDAO {

    void saveShop(Shop shop);

    void updateShop(Shop shop);

    void deleteShop(long id);

    Shop getShop(String shopName);

    Shop getById(long shopId);

    List listShop();

    List listUpcomingShop();

}
