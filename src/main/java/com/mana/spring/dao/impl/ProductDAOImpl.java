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


    public Product getProduct(Long productId, boolean requireListOtherData) {

        Product product = (Product) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productId= :id ").setParameter("id", productId).uniqueResult();

        // this will force Hibernate to execute the query that will join with the product's other lists and populate the appropriate information into the user object.
        if (requireListOtherData) {
            hibernateTemplate.initialize(product.getGemstones());
            hibernateTemplate.initialize(product.getMetals());
            hibernateTemplate.initialize(product.getImages());
            hibernateTemplate.initialize(product.getProductJewelryType());
            hibernateTemplate.initialize(product.getPurchases());
        }

        return product;
    }

    public Product saveProduct(Product product) {
        hibernateTemplate.save(product);
        return product;
    }

    public Product updateProduct(Product product) {
        hibernateTemplate.update(product);
        return product;
    }

    public List listAllProducts(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product").setFirstResult(start).setMaxResults(end).list();
    }

    public List listFeaturedProducts() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productOnFeatured = true").list();
    }

    public List listInStockProducts(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p  where p.productQuantity > 0").setFirstResult(start).setMaxResults(end).list();
    }

    public List listNonPublishedProducts(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product  p where p.productPublished = false").setFirstResult(start).setMaxResults(end).list();
    }

    public List listPublishedProducts(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product  p where p.productPublished = true ").setFirstResult(start).setMaxResults(end).list();
    }

    public List listOutOfStockProducts(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product  p where p.productQuantity <= 0").setFirstResult(start).setMaxResults(end).list();
    }

    public long countAll() {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Product").uniqueResult();
    }

    public long countInStock(boolean inStock) {
        if (inStock)
            return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Product p where p.productQuantity > 0").uniqueResult();
        else
            return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Product p where p.productQuantity <= 0").uniqueResult();
    }

    public long countPublished(boolean published) {

        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Product p where p.productOnFeatured = :pub").setParameter("pub", published).uniqueResult();

    }

}