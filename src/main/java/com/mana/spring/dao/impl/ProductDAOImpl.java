package com.mana.spring.dao.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.domain.Metal;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductRepoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
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

    public Object[] listFilteredProducts(int start, int end, ProductRepoFilter repoFilter) {
        String query = filterQuery(repoFilter, false);
        return hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(query).setFirstResult(start).setMaxResults(end).list().toArray();

//        "WITH StonesToFind AS (" +
//                "    SELECT * " +
//                "    FROM gemstone " +
//                "    WHERE gemstone_name IN ('Ruby', 'Emeralds') " +
//                "), findProduct AS ( " +
//                " SELECT p.product_id, p.product_jewelry_type, p.product_name, img.image_public_id " +
//                " FROM product AS p " +
//                " JOIN gemstone_product AS ps ON ps.product_id = p.product_id " +
//                " JOIN image AS img ON img.product_id = p.product_id AND img.image_priority = '1'" +
//                " LEFT JOIN StonesToFind AS s ON s.gemstone_id = ps.gemstone_id" +
//                " GROUP BY p.product_id " +
//                " HAVING COUNT(CASE WHEN s.gemstone_id IS NULL THEN 1 END) = 0 " +
//                "     AND COUNT(*) = (SELECT COUNT(*) FROM StonesToFind) " +
//                "), MetalsToFind AS ( " +
//                "    SELECT * " +
//                "    FROM metal " +
//                "    WHERE metal_name IN ('Gold') " +
//                "), productSearched AS ( " +
//                " SELECT pp.product_id, pp.product_jewelry_type, pp.product_name, pp.image_public_id FROM findProduct AS pp " +
//                " JOIN metal_product AS pm ON pm.product_id = pp.product_id" +
//                " LEFT JOIN MetalsToFind AS m ON m.metal_id = pm.metal_id" +
//                " GROUP BY pp.product_id " +
//                " HAVING COUNT(CASE WHEN m.metal_id IS NULL THEN 1 END) = 0 " +
//                "     AND COUNT(*) = (SELECT COUNT(*) FROM MetalsToFind) " +
//                ") " +
//                "SELECT * FROM productSearched p  "
    }

    private String filterQuery(ProductRepoFilter repoFilter, boolean count) {
        String query = "", finalSelect = "", finalSelectWhat = "*", finalQueryforJTWithGorS = "p.product_id, p.product_jewelry_type, p.product_name, img.image_secure_url, p.product_price";
        String priceFilter = "", sortFilter = "";

        if (count) {
            finalSelectWhat = "COUNT(*)";
            finalQueryforJTWithGorS = "COUNT(*)";
        } else {
            if (repoFilter.getMax() > -1)
                priceFilter = " AND p.product_price BETWEEN " + repoFilter.getMin() + " AND " + repoFilter.getMax();
            else
                priceFilter = " AND p.product_price > " + repoFilter.getMin();

            switch (repoFilter.getSortBy()) {
                case "pricelowToHigh":
                    sortFilter = " ORDER BY p.product_price ASC";
                    break;
                case "priceHighToLow":
                    sortFilter = " ORDER BY p.product_price DESC";
                    break;
                case "newest":
                    sortFilter = " ORDER BY p.created_date DESC";
                    break;
                default:
                    break;
            }
        }

        if (repoFilter.getProductGemstones() == null && repoFilter.getProductMetals() == null && repoFilter.getProductJewelryTypes() == null) {
            if (count)
                query = "select COUNT(*) from product p where p.product_published = true " + priceFilter;
            else
                query = "select p.product_id, p.product_jewelry_type, p.product_name, img.image_secure_url, p.product_price from product p JOIN image AS img ON img.product_id = p.product_id AND img.image_priority = '1' where p.product_published = true " + priceFilter + sortFilter;
            return query;
        }

        if (repoFilter.getProductGemstones() != null) {

            query += "WITH StonesToFind AS ( SELECT * FROM gemstone WHERE gemstone_name IN (";

            int i = 0;
            for (Gemstone gemstone : repoFilter.getProductGemstones()) {
                if (i > 0)
                    query += ",";
                query += "'" + gemstone.getGemstoneName() + "'";
                i++;
            }
            query += ")), findProduct AS ( " +
                    " SELECT p.product_id, p.product_jewelry_type, p.product_name, img.image_secure_url,  p.product_price, p.product_published, p.created_date FROM product AS p " +
                    " JOIN image AS img ON img.product_id = p.product_id AND img.image_priority = '1'";
            if (!repoFilter.isExactGT())
                query += " JOIN StonesToFind AS s" +
                        " JOIN gemstone_product AS ps ON ps.product_id = p.product_id AND ps.gemstone_id = s.gemstone_id" +
                        " GROUP BY p.product_id ";
            else
                query += " JOIN gemstone_product AS ps ON ps.product_id = p.product_id " +
                        " LEFT JOIN StonesToFind AS s ON s.gemstone_id = ps.gemstone_id" +
                        " GROUP BY p.product_id " +
                        " HAVING COUNT(CASE WHEN s.gemstone_id IS NULL THEN 1 END) = 0 " +
                        "     AND COUNT(*) = (SELECT COUNT(*) FROM StonesToFind) ";
            query += ")";

            finalSelect = "SELECT " + finalSelectWhat + " FROM findProduct p";
        }

        if (repoFilter.getProductMetals() != null) {
            String metalsSearched = "";
            finalSelect = "SELECT " + finalSelectWhat + " FROM productSearched p";
            int i = 0;
            for (Metal metal : repoFilter.getProductMetals()) {
                if (i > 0)
                    metalsSearched += ",";
                metalsSearched += "'" + metal.getMetalName() + "'";
                i++;
            }

            if (repoFilter.getProductGemstones() != null) {
                query += ", MetalsToFind AS ( SELECT * FROM metal WHERE metal_name IN (" + metalsSearched + "))" +
                        ", productSearched AS ( SELECT pp.product_id, pp.product_jewelry_type, pp.product_name, pp.image_secure_url, pp.product_price, pp.product_published,  pp.created_date FROM findProduct AS pp ";

                if (!repoFilter.isExactMT())
                    query += " JOIN MetalsToFind AS m" +
                            " JOIN metal_product AS pm ON pm.product_id = pp.product_id AND pm.metal_id = m.metal_id" +
                            " GROUP BY pp.product_id";
                else
                    query += " JOIN metal_product AS pm ON pm.product_id = pp.product_id" +
                            " LEFT JOIN MetalsToFind AS m ON m.metal_id = pm.metal_id" +
                            " GROUP BY pp.product_id " +
                            " HAVING COUNT(CASE WHEN m.metal_id IS NULL THEN 1 END) = 0 " +
                            "     AND COUNT(*) = (SELECT COUNT(*) FROM MetalsToFind) ";

            } else {
                query += "WITH MetalsToFind AS ( SELECT * FROM metal WHERE metal_name IN (" + metalsSearched + "))" +
                        ", productSearched AS ( SELECT pp.product_id, pp.product_jewelry_type, pp.product_name, img.image_secure_url, pp.product_price, pp.product_published, pp.created_date FROM product AS pp " +
                        " JOIN image AS img ON img.product_id = pp.product_id AND img.image_priority = '1'";
                if (!repoFilter.isExactMT())
                    query += "JOIN MetalsToFind AS m" +
                            "JOIN metal_product AS pm ON pm.product_id = pp.product_id AND pm.metal_id = m.metal_id" +
                            "GROUP BY pp.product_id";
                else
                    query += " JOIN metal_product AS pm ON pm.product_id = pp.product_id" +
                            " LEFT JOIN MetalsToFind AS m ON m.metal_id = pm.metal_id" +
                            " GROUP BY pp.product_id " +
                            " HAVING COUNT(CASE WHEN m.metal_id IS NULL THEN 1 END) = 0 " +
                            "     AND COUNT(*) = (SELECT COUNT(*) FROM MetalsToFind) ";
            }


            query += ")";
        }

        query += finalSelect;

        if (repoFilter.getProductJewelryTypes() != null) {
            int i = 0;
            String jtSearched = "";
            for (JewelryType jewelryType : repoFilter.getProductJewelryTypes()) {
                if (i > 0)
                    jtSearched += ",";
                jtSearched += "'" + jewelryType.getJewelryTypeId() + "'";
                i++;
            }

            if (repoFilter.getProductMetals() != null || repoFilter.getProductGemstones() != null) {
                query += " where product_jewelry_type IN (" + jtSearched + ")  and p.product_published = true";
            } else if (repoFilter.getProductJewelryTypes() != null && (repoFilter.getProductMetals() == null && repoFilter.getProductGemstones() == null))
                query = "SELECT " + finalQueryforJTWithGorS + " FROM product AS p JOIN image AS img ON img.product_id = p.product_id AND img.image_priority = '1' WHERE p.product_jewelry_type IN (" + jtSearched + ")  and p.product_published = true";


        } else {
            query += " where p.product_published = true";
        }

        query += priceFilter;
        query += sortFilter;

        return query;
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

        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Product p where p.productPublished = :pub").setParameter("pub", published).uniqueResult();

    }

    public long countFiltered(ProductRepoFilter repoFilter){
        return ((BigInteger) hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(filterQuery(repoFilter, true)).uniqueResult()).longValue();

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

}