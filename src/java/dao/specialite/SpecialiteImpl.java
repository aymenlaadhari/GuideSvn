/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.specialite;

import java.util.List;
import model.Specialite;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class SpecialiteImpl implements SpecialiteInterface {

    @Override
    public void save(Specialite specialite) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(specialite);
        t.commit();
    }

    @Override
    public List<Specialite> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List liste = session.createQuery("from Specialite").list();
        t.commit();
        return liste;
    }

    @Override
    public void remove(Specialite specialite) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(specialite);
        t.commit();
    }

    @Override
    public void update(Specialite specialite) {
Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(specialite);
        t.commit();    }

    @Override
    public Specialite getSpecialite(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Specialite) session.load(Specialite.class, id);
    }

    /*
    @Override
    public Specialite findBySpecialite(Specialite specialite) {
         Specialite model = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            model = (Specialite) session.createQuery("FROM Specialite WHERE specialite = '" + specialite.getNom_Spec() + "'").uniqueResult();
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            session.beginTransaction().rollback();
        }
        return model;
    }
    */

}
