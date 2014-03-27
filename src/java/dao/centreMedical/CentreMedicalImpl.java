/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.centreMedical;

import java.util.List;
import model.CentreMedicale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class CentreMedicalImpl implements CentreMedicaleInterface {

    @Override
    public void save(CentreMedicale centreMedicale) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(centreMedicale);
        t.commit();
    }

    @Override
    public List<CentreMedicale> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List liste = session.createQuery("from CentreMedicale").list();
        t.commit();
        return liste;
    }

    @Override
    public void remove(CentreMedicale centreMedicale) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(centreMedicale);
        t.commit();
    }

    @Override
    public void update(CentreMedicale centreMedicale) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(centreMedicale);
        t.commit();
    }

    @Override
    public CentreMedicale getCentreMedicale(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (CentreMedicale) session.load(CentreMedicale.class, id);
    }
/*
    @Override
    public CentreMedicale findByCentre(CentreMedicale centreMedicale) {
        CentreMedicale model = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            model = (CentreMedicale) session.createQuery("FROM CentreMedicale WHERE evenement = '" + centreMedicale.getNom_lieu() + "'").uniqueResult();
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            session.beginTransaction().rollback();
        }
        return model;
    }
*/
}
