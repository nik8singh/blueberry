package com.mana.spring.dao.impl;

import com.mana.spring.dao.ImageDAO;
import com.mana.spring.domain.Image;
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

    public void updateImageName(Image image) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Image img set img.image_public_id=:name where img.imageId= :id ").setParameter("id", image.getImageId()).setParameter("name", image.getImage_public_id()).executeUpdate();
    }

    public void deleteImageByProductAndPriority(long productId, int imagePriority) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("delete com.mana.spring.domain.Image img where img.product.productId = :id and img.imagePriority=:priority").setParameter("id", productId).setParameter("priority", imagePriority).executeUpdate();
    }

    public void deleteImageByPanelAndPriority(String panelName, int imagePriority) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("delete com.mana.spring.domain.Image img where img.imagePanelName = :panelName and img.imagePriority=:priority").setParameter("panelName", panelName).setParameter("priority", imagePriority).executeUpdate();
    }

    public Image getImage(String imageName) {
        return (Image) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Image img where img.image_public_id = :name").setParameter("name", imageName).uniqueResult();
    }

    @Override
    public void updateImagePriorityBulk(long imageId, int priority) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update com.mana.spring.domain.Image img set img.imagePriority=:p where img.imageId= :id ").setParameter("id", imageId).setParameter("p", priority).executeUpdate();
    }

    @Override
    public void deleteImageByPublicId(String publicId) {
        hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("delete com.mana.spring.domain.Image img where img.image_public_id = :id").setParameter("id", publicId).executeUpdate();
    }

    public List getImagesByPage(String pageName) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Image img where img.imagePageName = :name").setParameter("name", pageName).list();
    }

    public List getImagesByPanel(String panelName) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from com.mana.spring.domain.Image img where img.imagePanelName = :name").setParameter("name", panelName).list();
    }

    public long getProductImagesCount(long productId) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select count(*) from com.mana.spring.domain.Image img where img.product.productId = :id").setParameter("id", productId).uniqueResult();
    }

    @Override
    public long getImageCounter() {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select max(img.imageId) from com.mana.spring.domain.Image img").uniqueResult();
    }


}
