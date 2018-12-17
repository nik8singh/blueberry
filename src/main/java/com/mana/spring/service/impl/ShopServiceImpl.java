package com.mana.spring.service.impl;

import com.mana.spring.dao.ShopDAO;
import com.mana.spring.domain.Shop;
import com.mana.spring.dto.ShopDTO;
import com.mana.spring.service.ShopService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDAO shopDAO;

    public ArrayList<ShopDTO> getShops() {
        ArrayList<Shop> shops = (ArrayList<Shop>) shopDAO.listShop();
        return ConverterDAOtoDTO.shopListDaoToDto(shops);
    }

    public void addShop(ShopDTO shopDTO) {
        shopDAO.saveShop(ConverterDTOtoDAO.shopDtoToDao(shopDTO));
    }

    public void updateShop(ShopDTO shopDTO) {
        shopDAO.updateShop(ConverterDTOtoDAO.shopDtoToDao(shopDTO));
    }

    public ShopDTO getShop(ShopDTO shopDTO) {
        return ConverterDAOtoDTO.shopDaoToDto(shopDAO.getShop(shopDTO.getShopName()));
    }

}
