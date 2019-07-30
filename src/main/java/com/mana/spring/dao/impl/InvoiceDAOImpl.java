package com.mana.spring.dao.impl;

import com.mana.spring.dao.InvoiceDAO;
import com.mana.spring.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InvoiceDAOImpl implements InvoiceDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Invoice saveInvoice(Invoice invoice) {
         hibernateTemplate.save(invoice);
        return invoice;
    }

    public Invoice updateInvoice(Invoice invoice) {
        hibernateTemplate.update(invoice);
        return invoice;
    }

    public Invoice getByInvoiceNumber(long invoiceNumber) {
        return (Invoice) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Invoice inv where inv.squareInvoiceId = :id").setParameter("id", invoiceNumber).uniqueResult();
    }

    public List getByEmail(String email, int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Invoice inv where inv.user.userEmail = :email").setFirstResult(start).setMaxResults(end).setParameter("email", email).list();
    }

    public List getInvoices(boolean completed, boolean refundRequest, boolean refunded, int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Invoice inv where inv.completed = :com and inv.refunded = :ref and inv.refundRequested = :refReq").setParameter("com", completed).setParameter("ref", refunded).setParameter("refReq", refundRequest).setFirstResult(start).setMaxResults(end).list();
    }

    public long count(boolean completed, boolean refundRequest, boolean refunded) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Invoice inv where inv.completed = :com and inv.refunded = :ref and inv.refundRequested = :refReq").setParameter("com", completed).setParameter("ref", refunded).setParameter("refReq", refundRequest).uniqueResult();
    }

    public long count(String email) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Invoice inv where inv.user.userEmail = :email ").setParameter("email", email).uniqueResult();
    }

    public Invoice getById(Invoice invoice) {
        return (Invoice) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Invoice inv where inv.invoiceId = :id").setParameter("id", invoice.getInvoiceId()).uniqueResult();
    }
}
