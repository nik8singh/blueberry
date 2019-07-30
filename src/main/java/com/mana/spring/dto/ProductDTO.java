package com.mana.spring.dto;

import com.mana.spring.domain.JewelryType;

import java.util.Date;

public class ProductDTO {

    private long productId;

    private String productName;

    private String productDescription;

    private double productWeight;

    private String weightUnit;

    private double productPrice;

    private String productSku;

    private String productCurrency;

    private int productQuantity;

    private String productQuantityType;

    private boolean productOnFeatured;

    private boolean productPublished;

    private double productExpense;

    private boolean productAcceptCoupon;

    private boolean active;

    private Date createdDate;

    private Date updatedDate;

    private JewelryType productJewelryType;

}
