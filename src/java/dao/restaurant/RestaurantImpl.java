/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.restaurant;

import java.util.List;
import model.Restaurant;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class RestaurantImpl implements RestaurantInterface{

    @Override
    public void save(Restaurant restaurant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(restaurant);
        t.commit();
    }

    @Override
    public List<Restaurant> list() {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List liste = session.createQuery("from Restaurant").list();
        t.commit();
        return liste;
    }

    @Override
    public void remove(Restaurant restaurant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(restaurant);
        t.commit();
    }

    @Override
    public void update(Restaurant restaurant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(restaurant);
        t.commit();
    }

    @Override
    public Restaurant getCentre(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Restaurant) session.load(Restaurant.class, id);
    }
/*
    @Override
    public Restaurant findByRestaurant(Restaurant restaurant) {
         Restaurant model = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            model = (Restaurant) session.createQuery("FROM Userinfo WHERE user = '" + restaurant.getNom_lieu() + "'").uniqueResult();
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            session.beginTransaction().rollback();
        }
        return model;
    }
    */
}
