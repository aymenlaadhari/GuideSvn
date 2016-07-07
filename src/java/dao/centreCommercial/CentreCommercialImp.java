/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.centreCommercial;

import java.util.List;
import model.CentreCommercial;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class CentreCommercialImp implements CentreInt {

    @Override
    public void addCentreCommercial(CentreCommercial centreCommercial) {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(centreCommercial);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
    }
    @Override
    public void updateCentreCommercial(CentreCommercial centreCommercial) {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(centreCommercial);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur Modification" + e.getMessage());
        }
    }
     @Override
    public void deletCentreCommercial(CentreCommercial centreCommercial) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(centreCommercial);
            session.getTransaction().commit();
            session.close();
        
        System.out.print("Bien supprimé");
        } catch (Exception e) {
            System.out.print("Erreur Suppression" + e.getMessage());
            session.beginTransaction().rollback();
        }
    }
    @Override
    public CentreCommercial getCentreCommercial(int idCC) {
 
        CentreCommercial centreCommercial  = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            centreCommercial= (CentreCommercial) session.get(CentreCommercial.class, idCC);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return centreCommercial;
        }
        return centreCommercial;
    }
    @Override
    public List<CentreCommercial> getListCentreCommercial() {
        List<CentreCommercial> listCentreCommercial = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listCentreCommercial = session.createQuery("from CentreCommercial where validation = true and archive = false").list();
            for (CentreCommercial cp : listCentreCommercial) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
           session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listCentreCommercial;
        }
        return listCentreCommercial;
    }
   
    @Override
    public List<CentreCommercial> getListCentreCommercialInvalide() {
         List<CentreCommercial> listCentreCommercialInvalide = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listCentreCommercialInvalide = session.createQuery("from CentreCommercial where validation = false and archive = false").list();
            for (CentreCommercial cp : listCentreCommercialInvalide) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
           session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listCentreCommercialInvalide;
        }
        return listCentreCommercialInvalide;
    }

    @Override
    public List<CentreCommercial> getListCentreCommercialArchive() {
       List<CentreCommercial> listCentreCommercialArchive = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listCentreCommercialArchive = session.createQuery("from CentreCommercial where validation = true and archive = true").list();
            for (CentreCommercial cp : listCentreCommercialArchive) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
           session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listCentreCommercialArchive;
        }
        return listCentreCommercialArchive;
    }

     
}
