package com.mana.spring.dao.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveProduct(Product product) {
        hibernateTemplate.save(product);
    }

    public void updateProduct(Product product) { hibernateTemplate.merge(product); }

    public void deleteProduct(Product product) {
        hibernateTemplate.delete(product);
    }

    public List listProduct() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product met ORDER BY met.createdDate").list();
    }

    public List listAvailableProducts() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productQuantity> :q ORDER BY p.createdDate").setParameter("q", 0).list();

    }

    public Product getProduct(Long productId) {
        return (Product) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productId= :id ").setParameter("id", productId).list().get(0);

    }
}
