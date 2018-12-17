package com.mana.spring.dao.impl;

import com.mana.spring.dao.CartItemDAO;
import com.mana.spring.domain.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemDAOImpl implements CartItemDAO {


    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(CartItem cartItem) {
        hibernateTemplate.save(cartItem);
    }

    public void delete(CartItem cartItem) {
        hibernateTemplate.delete(cartItem);
    }

    public void update(CartItem cartItem) {
        hibernateTemplate.update(cartItem);
    }

    public List listUserCartItems(String email) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.CartItem met where met.user.userEmail= :email").setParameter("email", email).list();
    }

    public CartItem cartItemByProductAndUser(CartItem cartItem) {
        return (CartItem) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.CartItem met where met.user.userEmail= :email AND met.product.productId=:productId").setParameter("email", cartItem.getUser().getUserEmail()).setParameter("productId",cartItem.getProduct().getProductId()).list().get(0);
    }
}
