package com.mana.spring.service.impl;

import com.mana.spring.dao.ShopDAO;
import com.mana.spring.domain.Shop;
import com.mana.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDAO shopDAO;

    public ArrayList<Shop> getShops() {
        return (ArrayList<Shop>) shopDAO.listShop();
    }

    public void addShop(Shop shop) {
        shopDAO.saveShop(shop);
    }

    public void updateShop(Shop shop) {

        shopDAO.updateShop(shop);
    }

    public Shop getShop(String shopName) {
        return shopDAO.getShop(shopName);
    }

    public void deleteShop(String shopName) {
        shopDAO.deleteShop(shopName);

    }

    public ArrayList<Shop> getUpcomingAndOngoingShops() {
        return (ArrayList<Shop>) shopDAO.listUpcomingShop();
    }
}
