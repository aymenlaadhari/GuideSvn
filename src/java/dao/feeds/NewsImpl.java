/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.feeds;

import java.util.List;
import model.Feeds;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class NewsImpl implements NewsInterface{

    @Override
    public void save(Feeds feeds) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(feeds);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajout�");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Erreur insertion" + e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void update(Feeds feeds) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(feeds);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Erreur Modification" + e.getMessage());
            session.beginTransaction().rollback();
        }
         
    }

    @Override
    public void remove(Feeds feeds) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(feeds);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            session.beginTransaction().rollback();
        }
    }

    @Override
    public List<Feeds> getListFeeds() {
         List<Feeds> listfeeds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            listfeeds = session.createQuery("from Hotel where validation = true and archive = false").list();
            for (Feeds cp : listfeeds) {
                org.hibernate.Hibernate.initialize(cp.getId());
                //or cp.getCustomer().getLoginName();
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            
    }
        return listfeeds;

   
    
    }

    @Override
    public Feeds getFeeds(int idFeed) {
        Feeds feeds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            feeds = (Feeds) session.get(Feeds.class, idFeed);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return feeds;
        }
        return feeds;
    }
}
