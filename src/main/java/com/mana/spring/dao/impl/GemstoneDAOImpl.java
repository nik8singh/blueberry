package com.mana.spring.dao.impl;

import com.mana.spring.dao.GemstoneDAO;
import com.mana.spring.domain.Gemstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GemstoneDAOImpl implements GemstoneDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Gemstone saveGemstone(Gemstone gemstone) {
        hibernateTemplate.save(gemstone);
        return gemstone;
    }

    public Gemstone updateGemstone(Gemstone gemstone) {
        hibernateTemplate.update(gemstone);
        return gemstone;
    }

    public Gemstone getGemstone(String gemstoneName, boolean requireProducts) {

        Gemstone gemstone = (Gemstone) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneName= :name ").setParameter("name", gemstoneName).uniqueResult();

        // this will force Hibernate to execute the query that will join with the gemstone's products and populate the appropriate information into the user object.
        if (requireProducts)
            hibernateTemplate.initialize(gemstone.getProducts());

        return gemstone;

    }

    @Override
    public Gemstone getGemstonebyId(long gemstoneid, boolean requireProducts) {
        Gemstone gemstone = (Gemstone) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneId= :id ").setParameter("id", gemstoneid).uniqueResult();

        // this will force Hibernate to execute the query that will join with the gemstone's products and populate the appropriate information into the user object.
        if (requireProducts)
            hibernateTemplate.initialize(gemstone.getProducts());

        return gemstone;
    }


    @Override
    public List listPartialSearch(String searchWord) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneName LIKE concat('%',:searchWord,'%') or gem.gemstoneDescription LIKE concat('%',:searchWord,'%')").setParameter("searchWord", searchWord).list();
    }

    public void deactivateGemstone(long id) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Gemstone gem set gem.gemstoneActive = false where gem.gemstoneId= :id ").setParameter("id", id).executeUpdate();
    }

    public List listActiveGemstones(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneActive=true").setFirstResult(start).setMaxResults(end).list();

    }

    public List listActiveGemstones() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneActive=true").list();
    }

    public List listInactiveGemstones(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneActive=false").setFirstResult(start).setMaxResults(end).list();
    }

    public Gemstone getGemstoneById(long gemstoneId) {
        Gemstone gemstone = (Gemstone) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneId= :id ").setParameter("id", gemstoneId).uniqueResult();
        hibernateTemplate.initialize(gemstone.getProducts());

        return gemstone;
    }

    public long count(boolean active) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Gemstone gem where gem.gemstoneActive = :ac").setParameter("ac", active).uniqueResult();
    }

    @Override
    public void activateGemstone(long id) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Gemstone gem set gem.gemstoneActive = true where gem.gemstoneId= :id ").setParameter("id", id).executeUpdate();
    }
}
