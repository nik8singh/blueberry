package com.mana.spring.service.impl;

import com.mana.spring.dao.ShopDAO;
import com.mana.spring.domain.Shop;
import com.mana.spring.dto.ShopDTO;
import com.mana.spring.dto.ShopDTOConverter;
import com.mana.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDAO shopDAO;

    public ArrayList<ShopDTO> getShops() {
        ArrayList<Shop> shops = (ArrayList<Shop>) shopDAO.listShop();

        return ShopDTOConverter.convertToListOfDTOs(shops);
    }

    public void addShop(ShopDTO shopDTO) {
        Shop shop = ShopDTOConverter.convertToDomain(shopDTO);
        shopDAO.saveShop(shop);
    }

    public void updateShop(ShopDTO shopDTO) {
        Shop shop = ShopDTOConverter.convertToDomain(shopDTO);
        shopDAO.updateShop(shop);
    }

    public Shop getShop(String shopName) {
        return shopDAO.getShop(shopName);
    }

    public void deleteShop(long id) {
        shopDAO.deleteShop(id);

    }

    public ArrayList<Shop> getUpcomingAndOngoingShops() {
        return (ArrayList<Shop>) shopDAO.listUpcomingShop();
    }
}
