/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.pharmacie;

import java.util.List;
import model.Pharmacie;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class PharmacieImpl implements PharmacieInterface{

    @Override
    public void save(Pharmacie pharmacie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(pharmacie);
        t.commit();
    }

    @Override
    public List<Pharmacie> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List liste = session.createQuery("from Pharmacie").list();
        t.commit();
        return liste;
    }

    @Override
    public void remove(Pharmacie pharmacie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(pharmacie);
        t.commit();
    }

    @Override
    public void update(Pharmacie pharmacie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(pharmacie);
        t.commit();
    }

    @Override
    public Pharmacie getPharmacie(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Pharmacie) session.load(Pharmacie.class, id);
    }
/*
    @Override
    public Pharmacie findByPharmacie(Pharmacie pharmacie) {
         Pharmacie model = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            model = (Pharmacie) session.createQuery("FROM Pharmacie WHERE pharmacie = '" + pharmacie.getNom_lieu() + "'").uniqueResult();
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            session.beginTransaction().rollback();
        }
        return model;
    }*/
    
}
