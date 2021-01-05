package com.mana.spring.dao.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductRepoFilter;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Product getProduct(Long productId) {
        Product product = hibernateTemplate.getSessionFactory().getCurrentSession().load(Product.class, productId);
        makeItEager(product);
        return product;
    }

    public Product saveProduct(Product product) {
        hibernateTemplate.save(product);
        return product;
    }

    @Override
    public void updateProductPublish(Long productId, boolean publishFlag) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update Product as p set p.productPublished=:flag where p.productId= :id").setParameter("id", productId).setParameter("flag", publishFlag).executeUpdate();
    }

    public void updateProduct(Product product) {
        hibernateTemplate.update(product);
    }

    public List listAllProducts(int start, int end) {
        List data = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product").setFirstResult(start).setMaxResults(end).list();
        makeItEager(data);
        return data;
    }

    public List listFeaturedProducts() {

        List data =  hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productOnFeatured = true").list();
        makeItEager(data);
        return data;
    }

    public List listInStockProducts(int start, int end) {
        List data = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productQuantity > 0").setFirstResult(start).setMaxResults(end).list();
        makeItEager(data);
        return data;
    }

    public List listNonPublishedProducts(int start, int end) {
        List data = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product  p where p.productPublished = false").setFirstResult(start).setMaxResults(end).list();

        makeItEager(data);
        return data;
    }

    public List listPublishedProducts(int start, int end) {
        List data =  hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product  p where p.productPublished = true ").setFirstResult(start).setMaxResults(end).list();

        makeItEager(data);
        return data;
    }

    public List listOutOfStockProducts(int start, int end) {
        List data = (ArrayList<Product>) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product  p where p.productQuantity <= 0").setFirstResult(start).setMaxResults(end).list();
        makeItEager(data);
        return data;

    }

    public List listFilteredProducts(int start, int end, ProductRepoFilter repoFilter) {
        List data = (ArrayList<Product>) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product  p where p.productQuantity > 0 and p.productJewelryType = :jt").setParameter("jt",repoFilter.getProductJewelryTypes()).setFirstResult(start).setMaxResults(end).list();
        makeItEager(data);
        return data;

//        Query  query = filterQuery(repoFilter);
//
//        query.setFirstResult(start).setMaxResults(end);
//
//        List<Product> ps = query.list();
//
//        makeItEager(ps);
//
//        return ps;
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

    public long countFiltered(ProductRepoFilter repoFilter){
        return 5;

    }

    public Product getProductByName(String name) {
        Product product = (Product) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productName= :name ").setParameter("name", name).uniqueResult();
        makeItEager(product);

        return product;
    }

    public void updateSKU(long id, String sku) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update Product as p set p.productSku=:sku where p.productId= :id   ").setParameter("id", id).setParameter("sku", sku).executeUpdate();
    }

    public List listPartialSearch(String searchWord) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Product p where p.productName LIKE concat('%',:searchWord,'%') or p.productDescription LIKE concat('%',:searchWord,'%')").setParameter("searchWord", searchWord).list();
    }

    @Override
    public void allocateFromInventory(long productId) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update Product p SET p.productQuantity=-1 where p.productId=:id").setParameter("id", productId).executeUpdate();
    }


    private void makeItEager(Product product) {
        hibernateTemplate.initialize(product.getGemstones());
        hibernateTemplate.initialize(product.getMetals());
        hibernateTemplate.initialize(product.getImages());
        hibernateTemplate.initialize(product.getProductJewelryType());
        hibernateTemplate.initialize(product.getPurchases());
    }

    private void makeItEager(List<Product> product) {
        for (Product p : product)
            makeItEager(p);
    }


    private Query filterQuery(ProductRepoFilter repoFilter){

        String repoQuery = "select distinct p from Product p " +
                "JOIN p.gemstones g " +
                "JOIN p.metals m " +
                "where p.productQuantity > 0 ";

//        String repoQuery = "select p.productId from Product p " +
//                "LEFT JOIN p.gemstones as g " +
//                "where g in :gemstones " +
//                "group by p " +
//                "having count (distinct p)="+repoFilter.getProductGemstones().size();

        if (repoFilter.getProductGemstones() != null) {
            repoQuery += "AND g in :gemstones ";
        }

        if (repoFilter.getProductMetals() != null) {
            repoQuery += "AND m in :metals ";
        }
        if (repoFilter.getProductJewelryTypes() != null)
            repoQuery += "AND p.productJewelryType =:JT ";

        System.out.println("repoQuery: " + repoQuery);

        Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(repoQuery);

        if (repoFilter.getProductGemstones() != null) {
            query.setParameterList("gemstones", repoFilter.getProductGemstones());
        }

        if (repoFilter.getProductMetals() != null) {
            query.setParameterList("metals", repoFilter.getProductMetals());
        }

        if (repoFilter.getProductJewelryTypes() != null)
            query.setParameter("JT", repoFilter.getProductJewelryTypes());

        return  query;
    }
}