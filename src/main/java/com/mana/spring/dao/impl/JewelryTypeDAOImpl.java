package com.mana.spring.dao.impl;

import com.mana.spring.dao.JewelryTypeDAO;
import com.mana.spring.domain.JewelryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JewelryTypeDAOImpl implements JewelryTypeDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public JewelryType saveJewelryType(JewelryType jewelryType) {
        hibernateTemplate.save(jewelryType);
        return jewelryType;
    }

    public JewelryType updateJewelryType(JewelryType jewelryType) {
        hibernateTemplate.update(jewelryType);
        return jewelryType;
    }

    public void deactivateJewelryType(String jewelryTypeName) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.JewelryType jt set jt.jewelryTypeActive = false where jt.jewelryTypeName= :name ").setParameter("name", jewelryTypeName).executeUpdate();
    }

    public List listActiveJewelryType(int start, int end) {
        System.out.println("========== Start: "+start);
        System.out.println("========== end: "+end);

        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.JewelryType jt where jt.jewelryTypeActive= true").setFirstResult(start).setMaxResults(end).list();

    }

    public List listInactiveJewelryTypes(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.JewelryType jt where jt.jewelryTypeActive= false").setFirstResult(start).setMaxResults(end).list();

    }

    public JewelryType getJewelryType(String jewelryTypeName, boolean requireProducts) {
        JewelryType jewelryType = (JewelryType) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.JewelryType jt where jt.jewelryTypeName= :name ").setParameter("name", jewelryTypeName).uniqueResult();

        if (requireProducts)
            hibernateTemplate.initialize(jewelryType.getProducts());

        return jewelryType;
    }

    public JewelryType getJewelryTypeById(long jewelryTypeId) {
        JewelryType jewelryType = (JewelryType) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.JewelryType jt where jt.jewelryTypeId= :id ").setParameter("id", jewelryTypeId).uniqueResult();
        hibernateTemplate.initialize(jewelryType.getProducts());
        return jewelryType;
    }

    public long count(boolean active) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.JewelryType jt where jt.jewelryTypeActive = :ac").setParameter("ac", active).uniqueResult();

    }

}
