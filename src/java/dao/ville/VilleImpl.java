/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.ville;

import java.util.List;
import model.Ville;

import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class VilleImpl implements VilleInterface {

    @Override
    public void save(Ville ville) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(ville);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
    }

    @Override
    public Ville getVille(int idVille) {
       Ville ville = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            ville = (Ville) session.get(Ville.class, idVille);
            org.hibernate.Hibernate.initialize(ville.getPay());
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return ville;
        }
        return ville;
    }

    @Override
    public List<Ville> getListVille()
    {
        List<Ville> listVille = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listVille = session.createQuery("from Ville").list();
           for (Ville cp : listVille) {
                org.hibernate.Hibernate.initialize(cp.getPay());
                //or cp.getCustomer().getLoginName();
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listVille;
        }
        return listVille;
    }


    @Override
    public void remove(Ville ville) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(ville);
            session.getTransaction().commit();
            session.close();
        
        System.out.print("Bien supprimé");
        } catch (Exception e) {
            System.out.print("Erreur Suppression" + e.getMessage());
            session.beginTransaction().rollback();
        }   
    }

    @Override
    public void update(Ville ville) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(ville);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur Modification" + e.getMessage());
        }
    }

}
