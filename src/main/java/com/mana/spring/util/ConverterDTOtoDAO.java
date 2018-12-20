package com.mana.spring.util;

import com.mana.spring.domain.*;
import com.mana.spring.dto.*;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

public class ConverterDTOtoDAO {

    public static Address addressDtoToDao(AddressDTO addressDTO) {

        User user = new User();
        Shop shop = new Shop();
        Invoice invoice = new Invoice();

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

        if (addressDTO.getInvoiceDTO() != null) {
            BeanUtils.copyProperties(addressDTO.getInvoiceDTO(), invoice);
            target.setInvoiceAddress(invoice);
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
        Set<CartItem> cartItems = new HashSet<CartItem>();
        Set<Purchase> purchases = new HashSet<Purchase>();
        JewelryType jewelryType = new JewelryType();

        if (productDTO.getGemstoneDTOS() != null)
            for (GemstoneDTO gemstoneDTO : productDTO.getGemstoneDTOS())
                gemstones.add(gemstoneDtoToDao(gemstoneDTO));


        if (productDTO.getMetalDTOS() != null)
            for (MetalDTO metalDTO : productDTO.getMetalDTOS())
                metals.add(metalDtoToDao(metalDTO));


        if (productDTO.getImageDTOS() != null)
            for (ImageDTO imageDTO : productDTO.getImageDTOS())
                images.add(imageDtoToDao(imageDTO));

        if (productDTO.getCartItemDTOS() != null)
            for (CartItemDTO cartItemDTO : productDTO.getCartItemDTOS()) {
                CartItem cartItem = new CartItem();
                BeanUtils.copyProperties(cartItemDTO, cartItem);
                cartItems.add(cartItem);
            }

        if (productDTO.getPurchaseDTOS() != null)
            for (PurchaseDTO purchaseDTO : productDTO.getPurchaseDTOS()) {
                Purchase purchase = new Purchase();
                BeanUtils.copyProperties(purchaseDTO, purchase);
                purchases.add(purchase);
            }


        // to copy to
        Product target = new Product();

        BeanUtils.copyProperties(productDTO, target);
        BeanUtils.copyProperties(productDTO, jewelryType);
        target.setProductJewelryType(jewelryType);

        target.setGemstones(gemstones);
        target.setMetals(metals);
        target.setImages(images);
        target.setCartItems(cartItems);
        target.setPurchases(purchases);

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
        Set<CartItem> cartItems = new HashSet<CartItem>();
        Set<Invoice> invoices = new HashSet<Invoice>();

        Set<AddressDTO> addressDTOS = userDTO.getAddressesDto();
        Set<CartItemDTO> cartItemDTOS = userDTO.getCartItemDTOS();
        Set<InvoiceDTO> invoiceDTOS = userDTO.getInvoiceDTOS();

        // to copy to
        User target = new User();
        BeanUtils.copyProperties(userDTO, target);

        if (addressDTOS != null)
            for (AddressDTO addressDTO : addressDTOS) {

                Address targetAdd = new Address();
                BeanUtils.copyProperties(addressDTO, targetAdd);
                addresses.add(targetAdd);
            }

        if (cartItemDTOS != null)
            for (CartItemDTO cartItemDTO : cartItemDTOS) {

                CartItem targetCart = new CartItem();
                BeanUtils.copyProperties(cartItemDTO, targetCart);
                cartItems.add(targetCart);
            }

        if (invoiceDTOS != null)
            for (InvoiceDTO invoiceDTO : invoiceDTOS) {

                Invoice targetInvoice = new Invoice();
                BeanUtils.copyProperties(invoiceDTO, targetInvoice);
                invoices.add(targetInvoice);
            }

        target.setCartItems(cartItems);
        target.setInvoices(invoices);
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

    public static Coupon couponDtoToDao(CouponDTO couponDTO) {
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(couponDTO, coupon);
        return coupon;
    }
}
