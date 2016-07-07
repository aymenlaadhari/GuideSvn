/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.evenement;

import java.util.List;
import model.Evenement;
import org.hibernate.Session;
import util.HibernateUtil;

public class EvenementImpl implements EvenementInterface
{

    @Override
    public void save(Evenement evenement)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(evenement);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
      }

    @Override
    public List<Evenement> getListEvenement()
    {
        List<Evenement> listEvenement = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listEvenement = session.createQuery("from Evenement where validation = true").list();
                       session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listEvenement;
        }
        return listEvenement;
    }
    
         

    @Override
    public void remove(Evenement evenement) 
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(evenement);
            session.getTransaction().commit();
            session.close();
        
        System.out.print("Bien supprimé");
        } catch (Exception e) {
            System.out.print("Erreur Suppression" + e.getMessage());
            session.beginTransaction().rollback();
        }
        }

    @Override
    public void update(Evenement evenement) 
    {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(evenement);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur Modification" + e.getMessage());
        }
        }

    @Override
    public Evenement getEvenement(int idEvent)
    {
     Evenement evenement  = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            evenement= (Evenement) session.get(Evenement.class, idEvent);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return evenement;
        }
        return evenement;
    }

    @Override
    public List<Evenement> getListEvenementInvalide() {
        List<Evenement> listEvenementInvalide = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listEvenementInvalide = session.createQuery("from Evenement where validation = false").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listEvenementInvalide;
        }
        return listEvenementInvalide;
       }

   
       


}
