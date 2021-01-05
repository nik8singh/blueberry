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

    @Override
    public void deleteUserCart(long userId) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("delete com.mana.spring.domain.CartItem cart where cart.user.userId= :id").setParameter("id", userId).executeUpdate();
    }

    public void update(CartItem cartItem) {
        hibernateTemplate.update(cartItem);
    }

    public List listUserCartItems(long userId) {
        List<CartItem> carts = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.CartItem cart where cart.user.userId= :id").setParameter("id", userId).list();
        for (CartItem c : carts)
            hibernateTemplate.initialize(c.getProduct());

        return carts;
    }

    public CartItem cartItemByProductAndUser(long userId, long productId) {
        return (CartItem) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.CartItem cart where cart.user.userId= :userId AND cart.product.productId=:productId").setParameter("userId", userId).setParameter("productId", productId).uniqueResult();
    }
}
