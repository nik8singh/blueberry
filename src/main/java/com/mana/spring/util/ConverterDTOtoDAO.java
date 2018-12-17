package com.mana.spring.util;

import com.mana.spring.domain.*;
import com.mana.spring.dto.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ConverterDTOtoDAO {

    public static Address addressDtoToDao(AddressDTO addressDTO) {

        User user = new User();
        Shop shop = new Shop();

        // to copy to
        Address target = new Address();
        BeanUtils.copyProperties(addressDTO, target);

        if (addressDTO.getShopDTO() != null) {
            BeanUtils.copyProperties(addressDTO.getShopDTO(), shop);
            target.setShopAddress(shop);
        }
        if (addressDTO.getUserDTO() != null) {
            BeanUtils.copyProperties(addressDTO.getUserDTO(), user);
            target.setUser(user);
        }
        return target;
    }

    public static Gemstone gemstoneDtoToDao(GemstoneDTO gemstoneDTO) {

        // to copy to
        Gemstone target = new Gemstone();

        BeanUtils.copyProperties(gemstoneDTO, target);
        return target;

    }

    public static Image imageDtoToDao(ImageDTO imageDTO) {

        // to copy to
        Image target = new Image();

        BeanUtils.copyProperties(imageDTO, target);

        if (imageDTO.getProductId() != 0) {
            Product product = new Product();
            product.setProductId(imageDTO.getProductId());
            target.setProduct(product);
        }

        return target;

    }

    public static JewelryType jewelryTypeDtoToDao(JewelryTypeDTO jewelryTypeDTO) {

        // to copy to
        JewelryType target = new JewelryType();

        BeanUtils.copyProperties(jewelryTypeDTO, target);
        return target;

    }

    public static Metal metalDtoToDao(MetalDTO metalDTO) {

        // to copy to
        Metal target = new Metal();

        BeanUtils.copyProperties(metalDTO, target);
        return target;

    }

    public static Product productDtoToDao(ProductDTO productDTO) {

        Set<Gemstone> gemstones = new HashSet<Gemstone>();
        Set<Metal> metals = new HashSet<Metal>();
        Set<Image> images = new HashSet<Image>();
        JewelryType jewelryType = new JewelryType();

        if (productDTO.getGemstones() != null)
            for (GemstoneDTO gemstoneDTO : productDTO.getGemstones())
                gemstones.add(gemstoneDtoToDao(gemstoneDTO));


        if (productDTO.getMetals() != null)
            for (MetalDTO metalDTO : productDTO.getMetals())
                metals.add(metalDtoToDao(metalDTO));


        if (productDTO.getImages() != null)
            for (ImageDTO imageDTO : productDTO.getImages())
                images.add(imageDtoToDao(imageDTO));

        // to copy to
        Product target = new Product();

        BeanUtils.copyProperties(productDTO, target);
        BeanUtils.copyProperties(productDTO, jewelryType);
        target.setProductJewelryType(jewelryType);

        target.setGemstones(gemstones);
        target.setMetals(metals);
        target.setImages(images);

        return target;

    }

    public static Shop shopDtoToDao(ShopDTO shopDTO) {

        Address address = new Address();

        BeanUtils.copyProperties(shopDTO, address);

        Shop target = new Shop();

        BeanUtils.copyProperties(shopDTO, target);

        target.setShopAddress(address);

        return target;

    }

    public static User userDtoToDao(UserDTO userDTO) {

        Set<Address> addresses = new HashSet<Address>();

        Set<AddressDTO> addressDTOS = userDTO.getAddressesDto();

        // to copy to
        User target = new User();
        BeanUtils.copyProperties(userDTO, target);

        if (addressDTOS != null)
            for (AddressDTO addressDTO : addressDTOS) {

                Address targetAdd = new Address();
                BeanUtils.copyProperties(addressDTO, targetAdd);
                addresses.add(targetAdd);
            }

        target.setAddresses(addresses);

        return target;

    }

    public static CartItem cartItemDtoToDao(CartItemDTO cartItemDTO) {

        // to copy to
        CartItem target = new CartItem();
        BeanUtils.copyProperties(cartItemDTO, target);

        if (cartItemDTO.getProductDTO() != null)
            target.setProduct(productDtoToDao(cartItemDTO.getProductDTO()));

        if (cartItemDTO.getUserDTO() != null)
            target.setUser(userDtoToDao(cartItemDTO.getUserDTO()));

        return target;
    }
}
