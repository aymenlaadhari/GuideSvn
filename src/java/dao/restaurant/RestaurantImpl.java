/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.restaurant;

import java.util.List;
import model.Restaurant;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class RestaurantImpl implements RestaurantInterface{

    @Override
    public void save(Restaurant restaurant) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(restaurant);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
    }

    @Override
    public List<Restaurant> getlistResto() {
         List<Restaurant> listResto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listResto = session.createQuery("from Restaurant where validation = true and archive = false ").list();
            for (Restaurant cp : listResto) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
           session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listResto;
        }
        return listResto;
    }
    

    @Override
    public void remove(Restaurant restaurant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(restaurant);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("Erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void update(Restaurant restaurant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(restaurant);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur Modification" + e.getMessage());
        }
    }

    @Override
    public Restaurant getRestaurant(int idresto) {
       Restaurant restaurant  = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            restaurant= (Restaurant) session.get(Restaurant.class, idresto);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return restaurant;
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> getlistRestoInvalide() {
         List<Restaurant> listRestoInvalid = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listRestoInvalid = session.createQuery("from Restaurant where validation = false and archive = false").list();
             for (Restaurant cp : listRestoInvalid) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
           session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listRestoInvalid;
        }
        return listRestoInvalid;
       }

    @Override
    public List<Restaurant> getlistRestoArchive() {
         List<Restaurant> listRestoArchive = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listRestoArchive = session.createQuery("from Restaurant where validation = true and archive = true").list();
             for (Restaurant cp : listRestoArchive) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
           session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listRestoArchive;
        }
        return listRestoArchive;
         }

}
