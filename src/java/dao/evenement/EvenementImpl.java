/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.evenement;

import java.util.List;
import model.Evenement;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EvenementImpl implements EvenementInterface {

    @Override
    public void save(Evenement evenement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(evenement);
        t.commit();
    }

    @Override
    public List<Evenement> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List listeEvenement = session.createQuery("from Evenement").list();
        transaction.commit();
        return listeEvenement;
    }

    @Override
    public void remove(Evenement evenement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(evenement);
        t.commit();
    }

    @Override
    public void update(Evenement evenement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(evenement);
        t.commit();

    }

    @Override
    public Evenement getEvenement(int idEvenement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Evenement) session.load(Evenement.class, idEvenement);
    }

}
