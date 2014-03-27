/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.images;

import dao.ville.*;
import java.util.List;
import model.Image;
import model.Ville;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class ImageImpl implements ImageInterface {

    @Override
    public void save(Image image) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(image);
        t.commit();
    }

    @Override
    public Image getVille(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Image) session.load(Image.class, id);
    }

    @Override
    public List<Image> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Image").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Image image) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(image);
        t.commit();
    }

    @Override
    public void update(Image image) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(image);
        t.commit();
    }

}
