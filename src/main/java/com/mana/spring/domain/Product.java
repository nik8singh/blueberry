package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
//    @NotEmpty(message = "Please provide a name")
    private String productName;

    @Column(name = "product_description")
//    @NotEmpty(message = "Please provide description")
    private String productDescription;

    @Column(name = "product_weight")
//    @DecimalMin(value = "0.001", message = "Product Weight cannot be less than 0.001")
    private double productWeight;

    @Column(name = "weight_unit")
//    @NotEmpty(message = "Please provide weight unit")
    private String weightUnit;

    @Column(name = "product_price")
//    @DecimalMin(value = "1", message = "Product Price cannot be less than 1")
    private double productPrice;

    @Column(name = "product_sku", unique = true)
    private String productSku;

    @Column(name = "price_currency")
//    @NotEmpty(message = "Please provide Currency Type")
    private String productCurrency;

    @Column(name = "product_quantity")
//    @Min(value = 0, message = "Quantity cannot be less than 0")
    private int productQuantity;

    @Column(name = "product_quantity_type")
//    @NotEmpty(message = "Please provide Quantity Type")
    private String productQuantityType;

    @Column(name = "product_onfeatured")
    private boolean productOnFeatured;

    @Column(name = "product_published")
    private boolean productPublished;

    @Column(name = "product_expense")
//    @DecimalMin(value = "0.001", message = "Product Price cannot be less than 0.001")
    private double productExpense;

    @Column(name = "product_accept_coupon")
    private boolean productAcceptCoupon;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedDate;

    @ManyToOne()
    @JoinColumn(name = "product_jewelry_type")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "jewelryTypeId")
    private JewelryType productJewelryType;

    @ManyToMany()
    @JoinTable(
            name = "gemstone_product",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "gemstone_id")}
    )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "gemstoneId")
    private Set<Gemstone> gemstones = new HashSet<>(0);

    @ManyToMany()
    @JoinTable(
            name = "metal_product",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "metal_id")}
    )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "metalId")
    private Set<Metal> metals = new HashSet<>(0);


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "imageId")
    private Set<Image> images = new HashSet<>(0);

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "cartItemId")
    @JsonIgnore
    private Set<CartItem> cartItems = new HashSet<>(0);

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "purchaseId")
    @JsonIgnore
    private Set<Purchase> purchases = new HashSet<>(0);


    public Product() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductCurrency() {
        return productCurrency;
    }

    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductQuantityType() {
        return productQuantityType;
    }

    public void setProductQuantityType(String productQuantityType) {
        this.productQuantityType = productQuantityType;
    }

    public boolean isProductOnFeatured() {
        return productOnFeatured;
    }

    public void setProductOnFeatured(boolean productOnFeatured) {
        this.productOnFeatured = productOnFeatured;
    }

    public boolean isProductPublished() {
        return productPublished;
    }

    public void setProductPublished(boolean productPublished) {
        this.productPublished = productPublished;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public boolean isProductAcceptCoupon() {
        return productAcceptCoupon;
    }

    public void setProductAcceptCoupon(boolean productAcceptCoupon) {
        this.productAcceptCoupon = productAcceptCoupon;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public JewelryType getProductJewelryType() {
        return productJewelryType;
    }

    public void setProductJewelryType(JewelryType productJewelryType) {
        this.productJewelryType = productJewelryType;
    }

    public Set<Gemstone> getGemstones() {
        return gemstones;
    }

    public void setGemstones(Set<Gemstone> gemstones) {
        this.gemstones = gemstones;
    }

    public Set<Metal> getMetals() {
        return metals;
    }

    public void setMetals(Set<Metal> metals) {
        this.metals = metals;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;

        // null check
        if (o == null) {
            System.out.println("Equals failed: object null");
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            System.out.println("Equals failed: object not same type \nActual: " + getClass() + "\nExpected: " + o.getClass());
            return false;
        }

        Product product = (Product) o;

        Set<Long> expectedGems = new HashSet<>();
        for (Gemstone gem : getGemstones())
            expectedGems.add(gem.getGemstoneId());

        Set<Long> expectedMetals = new HashSet<>();
        for (Metal met : getMetals())
            expectedMetals.add(met.getMetalId());

        Set<Long> actualGems = new HashSet<>();
        for (Gemstone gem : product.getGemstones())
            actualGems.add(gem.getGemstoneId());

        Set<Long> actualMetals = new HashSet<>();
        for (Metal met : product.getMetals())
            actualMetals.add(met.getMetalId());

        boolean flag = true;

        if (!Objects.equals(getProductId(), product.getProductId())) {
            System.out.println("Equals failed: Product Id \nActual: " + getProductId() + "\nExpected: " + product.getProductId());
            flag = false;
        }
        if (!Objects.equals(getProductName(), product.getProductName())) {
            System.out.println("Equals failed: Product Name ");
            flag = false;
        }
        if (!Objects.equals(getProductDescription(), product.getProductDescription())) {
            System.out.println("Equals failed: Product Description  \nActual: " + getProductName() + "\nExpected: " + product.getProductName());
            flag = false;
        }
        if (!Objects.equals(getProductWeight(), product.getProductWeight())) {
            System.out.println("Equals failed: Product Weight  \nActual: " + getProductWeight() + "\nExpected: " + product.getProductWeight());
            flag = false;
        }
        if (!Objects.equals(getWeightUnit(), product.getWeightUnit())) {
            System.out.println("Equals failed: Product Weight Unit  \nActual: " + getWeightUnit() + "\nExpected: " + product.getWeightUnit());
            flag = false;
        }
        if (!Objects.equals(getProductPrice(), product.getProductPrice())) {
            System.out.println("Equals failed: Product Price  \nActual: " + getProductPrice() + "\nExpected: " + product.getProductPrice());
            flag = false;
        }
        if (!Objects.equals(getProductCurrency(), product.getProductCurrency())) {
            System.out.println("Equals failed: Product Currency  \nActual: " + getProductCurrency() + "\nExpected: " + product.getProductCurrency());
            flag = false;
        }
        if (!Objects.equals(getProductSku(), product.getProductSku())) {
            System.out.println("Equals failed: Product Sku  \nActual: " + getProductSku() + "\nExpected: " + product.getProductSku());
            flag = false;
        }
        if (!Objects.equals(getProductQuantity(), product.getProductQuantity())) {
            System.out.println("Equals failed: Product Quantity  \nActual: " + getProductQuantity() + "\nExpected: " + product.getProductQuantity());
            flag = false;
        }
        if (!Objects.equals(getProductQuantityType(), product.getProductQuantityType())) {
            System.out.println("Equals failed: Product Quantity Type  \nActual: " + getProductQuantityType() + "\nExpected: " + product.getProductQuantityType());
            flag = false;
        }
        if (!Objects.equals(isProductOnFeatured(), product.isProductOnFeatured())) {
            System.out.println("Equals failed: Product On Featured  \nActual: " + isProductOnFeatured() + "\nExpected: " + product.isProductOnFeatured());
            flag = false;
        }
        if (!Objects.equals(isProductPublished(), product.isProductPublished())) {
            System.out.println("Equals failed: Product Published  \nActual: " + isProductPublished() + "\nExpected: " + product.isProductPublished());
            flag = false;
        }
        if (!Objects.equals(getProductExpense(), product.getProductExpense())) {
            System.out.println("Equals failed: Product Expense  \nActual: " + getProductExpense() + "\nExpected: " + product.getProductExpense());
            flag = false;
        }
        if (!Objects.equals(isProductAcceptCoupon(), product.isProductAcceptCoupon())) {
            System.out.println("Equals failed: Product Accept Coupon  \nActual: " + isProductAcceptCoupon() + "\nExpected: " + product.isProductAcceptCoupon());
            flag = false;
        }
        if (!Objects.equals(getProductJewelryType().getJewelryTypeId(), product.getProductJewelryType().getJewelryTypeId())) {
            System.out.println("Equals failed: Product Jewelry Type ID  \nActual: " + getProductJewelryType().getJewelryTypeId() + "\nExpected: " + product.getProductJewelryType().getJewelryTypeId());
            flag = false;
        }
        if (!actualMetals.containsAll(expectedMetals)) {
            System.out.println("Equals failed: Product Metal IDs  \nActual: " + actualMetals + "\nExpected: " + expectedMetals);
            flag = false;
        }
        if (!actualGems.containsAll(expectedGems)) {
            System.out.println("Equals failed: Product Gemstone IDs  \nActual: " + actualGems + "\nExpected: " + expectedGems);
            flag = false;
        }

        return flag;

    }


    @Override
    public String toString() {
        return "\nProduct{" +
                "\n\tproductId= " + productId +
                "\n\tproductName= '" + productName + '\'' +
                "\n\tproductDescription= '" + productDescription + '\'' +
                "\n\tproductWeight= " + productWeight +
                "\n\tweightUnit= '" + weightUnit + '\'' +
                "\n\tproductPrice= " + productPrice +
                "\n\tproductCurrency= '" + productCurrency + '\'' +
                "\n\tproductSku= '" + productSku + '\'' +
                "\n\tproductQuantity= " + productQuantity +
                "\n\tproductQuantityType= '" + productQuantityType + '\'' +
                "\n\tproductOnFeatured= " + productOnFeatured +
                "\n\tproductPublished= '" + productPublished + '\'' +
                "\n\tproductExpense= '" + productExpense + '\'' +
                "\n\tcreatedDate= " + createdDate +
                "\n\tupdatedDate= " + updatedDate +
                "\n\tproductAcceptCoupon= " + productAcceptCoupon +
//                "\n\tproductJewelryType=" + productJewelryType +
//                "\n\tgemstones=" + gemstones +
                '}';
    }


}
