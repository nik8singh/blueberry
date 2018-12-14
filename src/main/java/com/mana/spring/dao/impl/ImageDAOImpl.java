package com.mana.spring.dao.impl;

import com.mana.spring.dao.ImageDAO;
import com.mana.spring.domain.Image;
import com.mana.spring.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ImageDAOImpl implements ImageDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveImage(Image image) {
        hibernateTemplate.save(image);
    }

    public void updateImage(Image image) {

        hibernateTemplate.update(image);
    }

    public void deleteImage(Image image) {

        hibernateTemplate.delete(image);
    }

    public List getImagesBySiteLocation(String imageSiteLocation) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Image img where img.imageSiteLocation= :siteLocation ").setParameter("siteLocation", imageSiteLocation).list();
    }

    public List getImagesByProduct(Long productId) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Image img where img.product.productId= :product ").setParameter("product", productId).list();

    }

    public List getImageByProductPriority(Image image) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Image img where img.product.productId= :product and img.imagePriority= :priority").setParameter("product", image.getProduct().getProductId()).setParameter("priority",image.getImagePriority()).list();

    }
}
