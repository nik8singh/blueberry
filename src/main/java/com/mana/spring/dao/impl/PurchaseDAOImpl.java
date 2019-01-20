package com.mana.spring.dao.impl;

import com.mana.spring.dao.PurchaseDAO;
import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.Product;
import com.mana.spring.domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PurchaseDAOImpl implements PurchaseDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void savePurchase(Purchase purchase) {
        hibernateTemplate.save(purchase);
    }

    public List listPurchase(Invoice invoice) {
        List<Purchase> purchases = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Purchase where invoice.id = :id").setParameter("id",invoice.getInvoiceId()).list();
        return purchases;
    }

    public List listPurchase(Product product) {
        List<Purchase> purchases = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Purchase where product.id = :id").setParameter("id",product.getProductId()).list();
        return purchases;

    }
}
