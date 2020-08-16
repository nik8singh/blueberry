package com.mana.spring.service;

import com.mana.spring.domain.Shop;
import com.mana.spring.dto.ShopDTO;

import java.util.ArrayList;

public interface ShopService {
    ArrayList<ShopDTO> getShops();

    ArrayList<Shop> getUpcomingAndOngoingShops();

    void addShop(ShopDTO shopDTO);

    void updateShop(ShopDTO shopDTO);

    void deleteShop(long id);

    Shop getShop(String shopName);
}
