/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.pharmacie;

import java.util.List;
import model.Pharmacie;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class PharmacieImpl implements PharmacieInterface{

    @Override
    public void save(Pharmacie pharmacie) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(pharmacie);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
    }

    @Override
    public List<Pharmacie> getListPharmacie() 
    {
       List<Pharmacie> listPharmacie = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listPharmacie  = session.createQuery("from Pharmacie where validation = true and archive = false").list();
            for (Pharmacie cp : listPharmacie) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
           session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listPharmacie ;
        }
        return listPharmacie ;
    }
    @Override
    public List<Pharmacie> getListPharmacieInvalide() {
        List<Pharmacie> listPharmacieInvalide = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listPharmacieInvalide  = session.createQuery("from Pharmacie where validation = false and archive = false ").list();
            for (Pharmacie cp : listPharmacieInvalide) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
           session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listPharmacieInvalide ;
        }
        return listPharmacieInvalide ;
        }

    @Override
    public List<Pharmacie> getListPharmacieArchive() {
        List<Pharmacie> listPharmacieArchive = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listPharmacieArchive  = session.createQuery("from Pharmacie where validation = true and archive = true ").list();
             for (Pharmacie cp : listPharmacieArchive) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
           session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listPharmacieArchive ;
        }
        return listPharmacieArchive ;
        }

    @Override
    public void remove(Pharmacie pharmacie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(pharmacie);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("Erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void update(Pharmacie pharmacie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(pharmacie);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur Modification" + e.getMessage());
        }
    }

    @Override
    public Pharmacie getPharmacie(int id) {
        Pharmacie pharmacie   = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            pharmacie= (Pharmacie) session.get(Pharmacie.class, id);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return pharmacie;
        }
        return pharmacie;
    }

    

    
}
