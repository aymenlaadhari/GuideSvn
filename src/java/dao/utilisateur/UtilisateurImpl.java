/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.utilisateur;

import java.util.List;
import model.Utilisateur;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class UtilisateurImpl implements UtilisateurInterface {

    @Override
    public void save(Utilisateur utilisateur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(utilisateur);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
    }

    @Override
    public List<Utilisateur> getListUtilisateur() {
         List<Utilisateur> listUtilisateur = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            listUtilisateur = session.createQuery("from Utilisateur").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listUtilisateur;
        }
        return listUtilisateur;
    }

    @Override
    public void remove(Utilisateur utilisateur) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(utilisateur);
            session.getTransaction().commit();
            session.close();

            System.out.print("Bien supprimé");
        } catch (Exception e) {
            System.out.print("Erreur Suppression" + e.getMessage());
            session.beginTransaction().rollback();
        }}

    @Override
    public void update(Utilisateur utilisateur)  {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(utilisateur);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur Modification" + e.getMessage());
        }
    

    }

    @Override
    public Utilisateur getUtilisateur(int id) {
         Utilisateur  utilisateur = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            utilisateur= (Utilisateur) session.get(Utilisateur.class, id);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return utilisateur;
        }
        return utilisateur;
    }

    @Override
    public Utilisateur login(Utilisateur utilisateur) {
        Utilisateur userModel = this.findByUtilisateur(utilisateur);
        if (userModel != null) {
            if (!utilisateur.getPassword().equals(userModel.getPassword())) {
                userModel = null;
            }
        }
        return userModel;
    }

    @Override
    public Utilisateur findByUtilisateur(Utilisateur utilisateur) {
        Utilisateur usuarioModel = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            usuarioModel = (Utilisateur) session.createQuery("FROM Utilisateur WHERE login = '" + utilisateur.getLogin() + "'").uniqueResult();
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            session.beginTransaction().rollback();
        }
        return usuarioModel;
    }

}
