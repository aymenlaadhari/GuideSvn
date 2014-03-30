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
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class UtilisateurImpl implements UtilisateurInterface{

    @Override
    public void save(Utilisateur utilisateur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(utilisateur);
        t.commit();
    }

    @Override
    public List<Utilisateur> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List liste = session.createQuery("from Utilisateur").list();
        t.commit();
        return liste;
    }

    @Override
    public void remove(Utilisateur utilisateur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(utilisateur);
        t.commit();
    }

    @Override
    public void update(Utilisateur utilisateur) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(utilisateur);
        t.commit();
    }

    @Override
    public Utilisateur getUtilisateur(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Utilisateur) session.load(Utilisateur.class, id);
    }

    @Override
    public Utilisateur login(Utilisateur utilisateur) {
        Utilisateur userModel = this.findByUtilisateur(utilisateur);
        if(userModel != null)
        {
            if(!utilisateur.getPassword().equals(userModel.getPassword()))
                    {
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
            usuarioModel = (Utilisateur)session.createQuery("FROM Utilisateur WHERE nom = '"+utilisateur.getNom()+ "'").uniqueResult();
            session.beginTransaction().commit();            
        } catch (HibernateException e) {
            session.beginTransaction().rollback();
        }
          return usuarioModel;
    }
    
}
