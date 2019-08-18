package com.mana.spring.dao.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductRepoFilter;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    public Product getProduct(Long productId, boolean requireListOtherData) {

        Product product = (Product) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productId= :id ").setParameter("id", productId).uniqueResult();

        // this will force Hibernate to execute the query that will join with the product's other lists and populate the appropriate information into the user object.
        if (requireListOtherData)
            makeItEager(product);

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

    public List listInStockProducts(int start, int end, ProductRepoFilter repoFilter) {

        String repoQuery = "select distinct p from Product p " +
                "JOIN p.gemstones g " +
                "JOIN p.metals m " +
                "where p.productQuantity > 0 ";

//        String repoQuery = "select p.productId from Product p " +
//                "LEFT JOIN p.gemstones as g " +
//                "where g in :gemstones " +
//                "group by p " +
//                "having count (distinct p)="+repoFilter.getProductGemstones().size();

        if(repoFilter.getProductGemstones() != null) {
            repoQuery += "AND g in :gemstones ";
        }

        if(repoFilter.getProductMetals() != null) {
            repoQuery += "AND m in :metals ";
        }
        if (repoFilter.getProductJewelryTypes() != null)
            repoQuery += "AND p.productJewelryType =:JT ";

        System.out.println("repoQuery: "+repoQuery);

        Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(repoQuery);
        query.setFirstResult(start).setMaxResults(end);

        if(repoFilter.getProductGemstones() != null) {
            query.setParameterList("gemstones",repoFilter.getProductGemstones());
        }

        if(repoFilter.getProductMetals() != null) {
            query.setParameterList("metals",repoFilter.getProductMetals());
        }

        if (repoFilter.getProductJewelryTypes() != null)
            query.setParameter("JT", repoFilter.getProductJewelryTypes());

        List<Product>ps =query.list();

        System.out.println("Size: "+ps.size());

        return ps;

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

    @Override
    public List listFilteredProducts(int start, int end) {
        return null;
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

    public Product getProductByName(String name, boolean requireListOtherData) {
        Product product = (Product) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productName= :name ").setParameter("name", name).uniqueResult();

        // this will force Hibernate to execute the query that will join with the product's other lists and populate the appropriate information into the user object.
        if (requireListOtherData)
            makeItEager(product);

        return product;
    }

    private void makeItEager(Product product) {
        hibernateTemplate.initialize(product.getGemstones());
        hibernateTemplate.initialize(product.getMetals());
        hibernateTemplate.initialize(product.getImages());
        hibernateTemplate.initialize(product.getProductJewelryType());
        hibernateTemplate.initialize(product.getPurchases());
    }

}