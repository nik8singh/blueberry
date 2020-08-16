package com.mana.spring.dto;

import com.mana.spring.domain.Address;
import com.mana.spring.domain.Shop;

import java.util.ArrayList;

public class ShopDTOConverter {

    public static Shop convertToDomain(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setShopId(shopDTO.getShopId());
        shop.setShopName(shopDTO.getShopName());
        shop.setShopDescription(shopDTO.getShopDescription());
        shop.setShopPrivateNote(shopDTO.getShopPrivateNote());
        shop.setBoothNumber(shopDTO.getBoothNumber());
        shop.setShopStartDate(shopDTO.getShopStartDate());
        shop.setShopEndDate(shopDTO.getShopEndDate());
        shop.setShopSale(shopDTO.getShopSale());
        shop.setShopExpense(shopDTO.getShopExpense());

        Address address = new Address();
        address.setAddressId(shopDTO.getAddressId());
        address.setAddressFullname(shopDTO.getAddressFullname());
        address.setAddressLineOne(shopDTO.getAddressLineOne());
        address.setAddressLineTwo(shopDTO.getAddressLineTwo());
        address.setAddressCity(shopDTO.getAddressCity());
        address.setAddressState(shopDTO.getAddressState());
        address.setAddressCountry(shopDTO.getAddressCountry());
        address.setAddressZipcode(shopDTO.getAddressZipcode());

        shop.setShopAddress(address);

        return shop;
    }

    public static ShopDTO convertToDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setShopId(shop.getShopId());
        shopDTO.setShopName(shop.getShopName());
        shopDTO.setShopDescription(shop.getShopDescription());
        shopDTO.setShopPrivateNote(shop.getShopPrivateNote());
        shopDTO.setBoothNumber(shop.getBoothNumber());
        shopDTO.setShopStartDate(shop.getShopStartDate());
        shopDTO.setShopEndDate(shop.getShopEndDate());
        shopDTO.setShopSale(shop.getShopSale());
        shopDTO.setShopExpense(shop.getShopExpense());
        shopDTO.setAddressId(shop.getShopAddress().getAddressId());
        shopDTO.setAddressFullname(shop.getShopAddress().getAddressFullname());
        shopDTO.setAddressLineOne(shop.getShopAddress().getAddressLineOne());
        shopDTO.setAddressLineTwo(shop.getShopAddress().getAddressLineTwo());
        shopDTO.setAddressCity(shop.getShopAddress().getAddressCity());
        shopDTO.setAddressState(shop.getShopAddress().getAddressState());
        shopDTO.setAddressCountry(shop.getShopAddress().getAddressCountry());
        shopDTO.setAddressZipcode(shop.getShopAddress().getAddressZipcode());
        return shopDTO;
    }

    public static ArrayList<ShopDTO> convertToListOfDTOs(ArrayList<Shop> shops) {
        ArrayList<ShopDTO> shopDTOS = new ArrayList<>();
        for (Shop shop : shops)
            shopDTOS.add(convertToDTO(shop));
        return shopDTOS;

    }
}
