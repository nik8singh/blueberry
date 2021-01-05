package com.mana.spring.dao.impl;

import com.mana.spring.dao.OrderDAO;
import com.mana.spring.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Order saveOrder(Order order) {
        hibernateTemplate.save(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        hibernateTemplate.update(order);
        return order;
    }

    @Override
    public Order getByPaymentId(long paymentId) {
        return (Order) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Order ord where ord.paymentId = :id").setParameter("id", paymentId).uniqueResult();
    }

    @Override
    public Order getByOrderId(long orderId) {
        return (Order) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Order ord where ord.orderId = :id").setParameter("id", orderId).uniqueResult();
    }

    @Override
    public List getAllByUserEmail(String email, int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Order ord where ord.user.userEmail = :email").setFirstResult(start).setMaxResults(end).setParameter("email", email).list();
    }

    @Override
    public long count(String statusFilter) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Order ord where ord.orderStatus = :status").setParameter("status", statusFilter).uniqueResult();
    }

    @Override
    public long countyMultipleStatus(ArrayList<String> filters) {
        return (long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Order ord where ord.orderStatus in :status").setParameter("status", filters).uniqueResult();
    }

    @Override
    public List getOrdersByStatus(String status, int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Order ord where ord.orderStatus = :status order by ord.orderPlacedDate desc ").setFirstResult(start).setMaxResults(end).setParameter("status", status).list();
    }

    @Override
    public List getOrdersByMultipleStatus(ArrayList<String> filters, int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Order ord where ord.orderStatus IN :status order by ord.orderPlacedDate desc ").setFirstResult(start).setMaxResults(end).setParameter("status", filters).list();
    }

    @Override
    public List listPartialSearch(String searchWord) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Order ord where ord.confirmationNumber LIKE concat('%',:searchWord,'%') or ord.user.userFirstName LIKE concat('%',:searchWord,'%') or ord.user.userLastName LIKE concat('%',:searchWord,'%')").setParameter("searchWord", searchWord).list();
    }

    @Override
    public void updatePrivateNote(String message, long orderId) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.Order ord SET ord.privateNote = :newNote WHERE ord.orderId= :orderId").setParameter("orderId", orderId).setParameter("newNote", message).executeUpdate();

    }

    @Override
    public void updatePublicNote(String message, long orderId) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.Order ord SET ord.noteForCustomer = :newNote WHERE ord.orderId= :orderId").setParameter("orderId", orderId).setParameter("newNote", message).executeUpdate();

    }

    @Override
    public void updateTrackingNumber(String trackingNumber, long orderId) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("UPDATE com.mana.spring.domain.Order ord SET ord.trackingNumber = :trackingNumber WHERE ord.orderId= :orderId").setParameter("orderId", orderId).setParameter("trackingNumber", trackingNumber).executeUpdate();

    }
}
