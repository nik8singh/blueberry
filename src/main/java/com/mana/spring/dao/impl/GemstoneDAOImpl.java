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

    public void saveGemstone(Gemstone gemstone) {
        hibernateTemplate.save(gemstone);
    }

    public void updateGemstone(Gemstone gemstone) {
        hibernateTemplate.update(gemstone);
    }

    public Gemstone getGemstone(String gemstoneName, boolean requireProducts) {

        Gemstone gemstone = (Gemstone) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneName= :name ").setParameter("name", gemstoneName).uniqueResult();

        // this will force Hibernate to execute the query that will join with the gemstone's products and populate the appropriate information into the user object.
        if (requireProducts)
            hibernateTemplate.initialize(gemstone.getProducts());

        return gemstone;

    }

    public void deactivateGemstone(String gemstoneName) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Gemstone gem set gem.gemstoneActive = false where gem.gemstoneName= :name ").setParameter("name", gemstoneName).executeUpdate();
    }

    public List listActiveGemstones(int start, int end) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Gemstone gem where gem.gemstoneActive=true").setFirstResult(start).setMaxResults(end).list();

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
}
