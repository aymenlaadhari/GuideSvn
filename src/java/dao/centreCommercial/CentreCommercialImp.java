/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.centreCommercial;

import java.util.List;
import model.CentreCommercial;


import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class CentreCommercialImp implements CentreInt {

    @Override
    public void save(CentreCommercial centreCommercial) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(centreCommercial);
        t.commit();
    }

    @Override
    public List<CentreCommercial> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List liste = session.createQuery("from CentreCommercial").list();
        t.commit();
        return liste;
    }

    @Override
    public void remove(CentreCommercial centreCommercial) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(centreCommercial);
        t.commit();
    }

    @Override
    public void update(CentreCommercial centreCommercial) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(centreCommercial);
        t.commit();
    }

    @Override
    public CentreCommercial getCentre(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (CentreCommercial) session.load(CentreCommercial.class, id);
    }
/*
    @Override
    public CentreCommercial findByCentre(CentreCommercial centreCommercial) {
        CentreCommercial model = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            model = (CentreCommercial) session.createQuery("FROM Userinfo WHERE user = '" + centreCommercial.get + "'").uniqueResult();
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            session.beginTransaction().rollback();
        }
        return model;
    }*/

}
