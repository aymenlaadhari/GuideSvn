/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.specialite;

import java.util.List;
import model.Specialite;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class SpecialiteImpl implements SpecialiteInterface {

    @Override
    public void save(Specialite specialite) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(specialite);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
    }

    @Override
    public List<Specialite> getListSpecialite() {
        List<Specialite> listSpecialite = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            listSpecialite = session.createQuery("from Specialite").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listSpecialite;
        }
        return listSpecialite;
    }

    @Override
    public void remove(Specialite specialite) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(specialite);
            session.getTransaction().commit();
            session.close();

            System.out.print("Bien supprimé");
        } catch (Exception e) {
            System.out.print("Erreur Suppression" + e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void update(Specialite specialite) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(specialite);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur Modification" + e.getMessage());
        }
    }

    @Override
    public Specialite getSpecialite(int id) {
       Specialite specialite  = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            specialite= (Specialite) session.get(Specialite.class, id);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return specialite;
        }
        return specialite;
    }

    /*
     @Override
     public Specialite findBySpecialite(Specialite specialite) {
     Specialite model = null;
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();

     try {
     session.beginTransaction();
     model = (Specialite) session.createQuery("FROM Specialite WHERE specialite = '" + specialite.getNom_Spec() + "'").uniqueResult();
     session.beginTransaction().commit();
     } catch (HibernateException e) {
     session.beginTransaction().rollback();
     }
     return model;
     }
     */
}
