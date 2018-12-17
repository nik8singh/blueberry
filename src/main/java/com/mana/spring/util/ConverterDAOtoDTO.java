package com.mana.spring.util;

import com.mana.spring.domain.*;
import com.mana.spring.dto.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ConverterDAOtoDTO {

    public static AddressDTO addressDaoToDto(Address address) {

        UserDTO userDTO = new UserDTO();
        ShopDTO shopDTO = new ShopDTO();

        // to copy to
        AddressDTO target = new AddressDTO();
        BeanUtils.copyProperties(address, target);

        if (address.getShopAddress() != null) {
            BeanUtils.copyProperties(address.getShopAddress(), shopDTO);
            target.setShopDTO(shopDTO);
        }
        if (address.getUser() != null) {
            BeanUtils.copyProperties(address.getUser(), userDTO);
            target.setUserDTO(userDTO);
        }

        return target;
    }

    public static ArrayList<GemstoneDTO> gemstoneListDaoToDto(ArrayList<Gemstone> gemstones) {

        ArrayList<GemstoneDTO> gemstoneDTOs = new ArrayList<GemstoneDTO>();

        for (Gemstone gem : gemstones) {
            gemstoneDTOs.add(gemstoneDaoToDto(gem));
        }

        return gemstoneDTOs;
    }

    public static GemstoneDTO gemstoneDaoToDto(Gemstone gemstone) {

        // to copy to
        GemstoneDTO target = new GemstoneDTO();

        BeanUtils.copyProperties(gemstone, target);
        return target;

    }

    public static ImageDTO imageDaoToDto(Image image) {
        // to copy to
        ImageDTO target = new ImageDTO();
        BeanUtils.copyProperties(image, target);
        target.setProductId(image.getProduct().getProductId());
        return target;
    }

    public static ArrayList<JewelryTypeDTO> jewelryTypeListDaoToDto(ArrayList<JewelryType> jewelryTypes) {

        ArrayList<JewelryTypeDTO> jewelryTypeDTOS = new ArrayList<JewelryTypeDTO>();

        for (JewelryType jewelryType : jewelryTypes) {
            jewelryTypeDTOS.add(jewelryTypeDaoToDto(jewelryType));
        }

        return jewelryTypeDTOS;
    }

    public static JewelryTypeDTO jewelryTypeDaoToDto(JewelryType jewelryType) {

        // to copy to
        JewelryTypeDTO target = new JewelryTypeDTO();

        BeanUtils.copyProperties(jewelryType, target);
        return target;

    }

    public static ArrayList<MetalDTO> metalListDaoToDto(ArrayList<Metal> metals) {

        ArrayList<MetalDTO> metalDTOS = new ArrayList<MetalDTO>();

        for (Metal metal : metals) {
            metalDTOS.add(metalDaoToDto(metal));
        }

        return metalDTOS;
    }

    public static MetalDTO metalDaoToDto(Metal metal) {

        // to copy to
        MetalDTO target = new MetalDTO();

        BeanUtils.copyProperties(metal, target);
        return target;

    }

    public static ProductDTO productDaoToDto(Product product) {
        ProductDTO target = new ProductDTO();

        ArrayList<GemstoneDTO> gemstoneDTOs = new ArrayList<GemstoneDTO>();
        ArrayList<MetalDTO> metalDTOs = new ArrayList<MetalDTO>();
        ArrayList<ImageDTO> imageDTOs = new ArrayList<ImageDTO>();

        BeanUtils.copyProperties(product, target);
        BeanUtils.copyProperties(product.getProductJewelryType(), target);

        if (product.getGemstones() != null)
            for (Gemstone sourceGem : product.getGemstones())
                gemstoneDTOs.add(gemstoneDaoToDto(sourceGem));

        if (product.getMetals() != null)
            for (Metal sourceMetal : product.getMetals())
                metalDTOs.add(metalDaoToDto(sourceMetal));

        if (product.getImages() != null)
            for (Image sourceImage : product.getImages())
                imageDTOs.add(imageDaoToDto(sourceImage));

        target.setGemstones(gemstoneDTOs);
        target.setMetals(metalDTOs);
        target.setImages(imageDTOs);

        return target;

    }

    public static ArrayList<ShopDTO> shopListDaoToDto(ArrayList<Shop> shops) {

        ArrayList<ShopDTO> shopDTOS = new ArrayList<ShopDTO>();

        for (Shop shop : shops) {
            shopDTOS.add(shopDaoToDto(shop));
        }

        return shopDTOS;
    }

    public static ShopDTO shopDaoToDto(Shop shop) {

        ShopDTO target = new ShopDTO();
        Address address = shop.getShopAddress();
        BeanUtils.copyProperties(shop, target);
        BeanUtils.copyProperties(address, target);
        return target;

    }

    public static UserDTO userDaoToDto(User user) {

        Set<Address> addresses = user.getAddresses();

        Set<AddressDTO> addressDTOS = new HashSet<AddressDTO>();

        // to copy to
        UserDTO target = new UserDTO();
        BeanUtils.copyProperties(user, target);

        if (addresses != null)
            for (Address address : addresses) {

                AddressDTO targetAdd = new AddressDTO();
                BeanUtils.copyProperties(address, targetAdd);
                addressDTOS.add(targetAdd);
            }

        target.setAddressesDto(addressDTOS);

        return target;

    }

    public static CartItemDTO cartItemDaoToDto(CartItem cartItem) {

        // to copy to
        CartItemDTO target = new CartItemDTO();
        BeanUtils.copyProperties(cartItem, target);

        target.setProductDTO(productDaoToDto(cartItem.getProduct()));
        target.setUserDTO(userDaoToDto(cartItem.getUser()));

        return target;
    }
}
