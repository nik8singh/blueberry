package com.mana.spring.dao.impl;

import com.mana.spring.dao.MetalDAO;
import com.mana.spring.domain.Metal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MetalDAOImpl implements MetalDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveMetal(Metal metal) {
        hibernateTemplate.save(metal);
    }

    public void updateMetal(Metal metal) {
        hibernateTemplate.update(metal);
    }

    public void deleteMetal(Metal metal) {
        hibernateTemplate.delete(metal);
    }

    public List listMetal() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal met ORDER BY met.createdDate").list();
    }

    public Metal getMetal(String metalName) {
        return (Metal) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Metal gem where gem.metalName= :name ").setParameter("name", metalName).list().get(0);
    }

}
