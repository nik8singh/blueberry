package com.mana.spring.service;

import com.mana.spring.dto.ShopDTO;

import java.util.ArrayList;

public interface ShopService {
    ArrayList<ShopDTO> getShops();

    void addShop(ShopDTO shopDTO);

    void updateShop(ShopDTO shopDTO);

//    void deleteShop(Shop shop);

    ShopDTO getShop(ShopDTO shopDTO);
}
