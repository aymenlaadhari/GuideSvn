/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pays;

import java.util.List;
import model.Pay;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class PaysImpl implements PaysInterface {

    @Override
    public void save(Pay pays) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(pays);
        t.commit();
    }

    @Override
    public Pay getPays(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Pay) session.load(Pay.class, id);
    }

    @Override
    public List<Pay> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Pay").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Pay pays) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(pays);
        t.commit();
    }

    @Override
    public void update(Pay pays) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(pays);
        t.commit();
    }

}
