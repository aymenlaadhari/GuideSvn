/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.garde;

import java.util.List;
import model.Garde;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class GardeImpl implements GardeInterface{

    @Override
    public void save(Garde garde) {
 Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(garde);
        t.commit();    }

    @Override
    public List<Garde> list() {
 Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List liste = session.createQuery("from Garde").list();
        t.commit();
        return liste;    }

    @Override
    public void remove(Garde garde) {
Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(garde);
        t.commit();    }

    @Override
    public void update(Garde garde) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(garde);
        t.commit();
    }
    
    @Override
    public Garde getGarde(int id) {
          Session session = HibernateUtil.getSessionFactory().openSession();
       return (Garde) session.load(Garde.class, id);
        
    }
    
}
