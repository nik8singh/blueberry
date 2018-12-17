package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cartItem")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_id")
    private long cartItemId;

    @Column(name = "product_quantity")
    private int productQuantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "productId")
    private Product product;

    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    public CartItem() {}

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    @Override
    public String toString() {
        return "\nCartItem{" +
                "\ncartItemId=" + cartItemId +
                "\n productQuantity='" + productQuantity + '\'' +
                "\n user=" + user +
                "\n product=" + product +
                "\n createdDate=" + createdDate +
                "\n updatedDate=" + updatedDate +
                '}';
    }
}
