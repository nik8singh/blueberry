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
        InvoiceDTO invoiceDTO = new InvoiceDTO();

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

        if (address.getInvoiceAddress() != null) {
            BeanUtils.copyProperties(address.getInvoiceAddress(), invoiceDTO);
            target.setInvoiceDTO(invoiceDTO);
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
        ArrayList<CartItemDTO> cartItemDTOS = new ArrayList<CartItemDTO>();
        ArrayList<PurchaseDTO> purchaseDTOS = new ArrayList<PurchaseDTO>();

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

        if (product.getCartItems() != null)
            for (CartItem sourceCart : product.getCartItems()) {
                CartItemDTO targetCart = new CartItemDTO();
                BeanUtils.copyProperties(sourceCart, targetCart);
                cartItemDTOS.add(targetCart);
            }

        if (product.getPurchases() != null)
            for (Purchase sourcePurchase : product.getPurchases()) {
                PurchaseDTO targetPurchase = new PurchaseDTO();
                BeanUtils.copyProperties(sourcePurchase, targetPurchase);
                purchaseDTOS.add(targetPurchase);
            }

        target.setGemstoneDTOS(gemstoneDTOs);
        target.setMetalDTOS(metalDTOs);
        target.setImageDTOS(imageDTOs);
        target.setCartItemDTOS(cartItemDTOS);
        target.setPurchaseDTOS(purchaseDTOS);

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
        Set<CartItem> cartItems = user.getCartItems();
        Set<Invoice> invoices = user.getInvoices();

        Set<AddressDTO> addressDTOS = new HashSet<AddressDTO>();
        Set<CartItemDTO> cartItemDTOS = new HashSet<CartItemDTO>();
        Set<InvoiceDTO> invoiceDTOS = new HashSet<InvoiceDTO>();

        // to copy to
        UserDTO target = new UserDTO();
        BeanUtils.copyProperties(user, target);

        if (addresses != null)
            for (Address address : addresses) {
                AddressDTO targetAdd = new AddressDTO();
                BeanUtils.copyProperties(address, targetAdd);
                addressDTOS.add(targetAdd);
            }

        if (cartItems != null)
            for (CartItem cartItem : cartItems) {
                cartItemDTOS.add(cartItemDaoToDto(cartItem));
            }

        if (invoices != null)
            for (Invoice invoice : invoices) {
                invoiceDTOS.add(invoiceDaoToDto(invoice));
            }

        target.setCartItemDTOS(cartItemDTOS);
        target.setInvoiceDTOS(invoiceDTOS);
        target.setAddressesDto(addressDTOS);

        return target;

    }

    public static CartItemDTO cartItemDaoToDto(CartItem cartItem) {

        // to copy to
        CartItemDTO target = new CartItemDTO();
        BeanUtils.copyProperties(cartItem, target);

        target.setProductDTO(productDaoToDto(cartItem.getProduct()));

        UserDTO targetUser = new UserDTO();
        BeanUtils.copyProperties(cartItem.getUser(), targetUser);

        target.setUserDTO(targetUser);

        return target;
    }

    public static InvoiceDTO invoiceDaoToDto(Invoice invoice) {

        ArrayList<PurchaseDTO> purchaseDTOS = new ArrayList<PurchaseDTO>();

        // to copy to
        InvoiceDTO target = new InvoiceDTO();
        BeanUtils.copyProperties(invoice, target);

        target.setShippingAddressDTO(addressDaoToDto(invoice.getShippingAddress()));

        if (invoice.getPurchases() != null)
            for (Purchase sourcePurchase : invoice.getPurchases()) {

                PurchaseDTO purchaseDTO = new PurchaseDTO();

                BeanUtils.copyProperties(sourcePurchase, purchaseDTO);
                purchaseDTO.setProductDTO(productDaoToDto(sourcePurchase.getProduct()));
                purchaseDTOS.add(purchaseDTO);
            }

        UserDTO targetUser = new UserDTO();
        BeanUtils.copyProperties(invoice.getUser(), targetUser);
        target.setUserDTO(targetUser);

        return target;
    }
}