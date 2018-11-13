package com.mana.spring.service.impl;

import com.mana.spring.dao.ShopDAO;
import com.mana.spring.domain.Address;
import com.mana.spring.domain.Shop;
import com.mana.spring.dto.ShopDTO;
import com.mana.spring.service.ShopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDAO shopDAO;

    public ArrayList<ShopDTO> getShops() {
        ArrayList<Shop> shops = (ArrayList<Shop>) shopDAO.listShop();
        return daoListToDtoList(shops);
    }

    public void addShop(ShopDTO shopDTO) {
        shopDAO.saveShop(dtoToDao(shopDTO));
    }

    public void updateShop(ShopDTO shopDTO) {
        shopDAO.updateShop(dtoToDao(shopDTO));
    }

    public ShopDTO getShop(ShopDTO shopDTO) {
        return daoToDto(shopDAO.getShop(shopDTO.getShopName()));
    }

//    public void deleteShop(Shop shop) {
//        shopDAO.deleteShop(shop);
//    }


    public ArrayList<ShopDTO> daoListToDtoList(ArrayList<Shop> shops){

        ArrayList<ShopDTO> shopDTOS = new ArrayList<ShopDTO>();

        for (Shop shop : shops) {
            shopDTOS.add(daoToDto(shop));
        }

        return shopDTOS;
    }

    public ShopDTO daoToDto(Shop shop) {

        ShopDTO target = new ShopDTO();
        Address address = shop.getShopAddress();
        BeanUtils.copyProperties(shop, target);
        BeanUtils.copyProperties(address, target);
        return target;

    }

    public Shop dtoToDao(ShopDTO shopDTO) {

        Address address = new Address();

        BeanUtils.copyProperties(shopDTO, address);

        Shop target = new Shop();

        BeanUtils.copyProperties(shopDTO, target);

        target.setShopAddress(address);

        return target;

    }




}
