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
    public void addCentreMedicale(CentreMedicale centreMedicale) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(centreMedicale);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
         }
    @Override
   public void updateCentreMedicale(CentreMedicale centreMedicale) {
    
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(centreMedicale);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur modification" + e.getMessage());
        }
    }
    
   
    @Override
    public void deletCentreMedicale(CentreMedicale centreMedicale) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(centreMedicale);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("Erreur Suppression" + e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public CentreMedicale getCentreMedicale(int id) {
        CentreMedicale centreMedicale = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           centreMedicale= (CentreMedicale) session.get(CentreMedicale.class, id);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return centreMedicale;
        }
        return centreMedicale;
    }
    

    @Override
    public List<CentreMedicale> getListCentreMedicale() {
        List<CentreMedicale> listCentreMedicale = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listCentreMedicale = session.createQuery("from CentreMedicale").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("Erreur Suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listCentreMedicale;
        }
        return listCentreMedicale;
    }
}
