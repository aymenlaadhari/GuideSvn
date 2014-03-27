/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.ville;

import java.util.List;
import model.Ville;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class VilleImpl implements VilleInterface {

    @Override
    public void save(Ville ville) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(ville);
        t.commit();
    }

    @Override
    public Ville getVille(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Ville) session.load(Ville.class, id);
    }

    @Override
    public List<Ville> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Ville").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Ville ville) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(ville);
        t.commit();
    }

    @Override
    public void update(Ville ville) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(ville);
        t.commit();
    }

}
