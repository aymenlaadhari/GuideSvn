/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.monument;
import java.util.List;
import model.Monument;
import org.hibernate.Session;
import util.HibernateUtil;



/**
 *
 * @author hp
 */
public class MonumentImpl implements MonumentInterface
{

    @Override
    public void addMonument(Monument monument) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(monument);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
        }

    @Override
    public void updateMonument(Monument monument) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(monument);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur Modification" + e.getMessage());
        }}

    @Override
    public void deletMonument(Monument monument) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(monument);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("Erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
        } }

    @Override
    public Monument getMonument(int id) {
        Monument monument  = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            monument= (Monument) session.get(Monument.class, id);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("Erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return monument;
        }
        return monument;
    }

    @Override
    public List<Monument> getListMonument() {
    
        List<Monument> listMonument = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listMonument = session.createQuery("from Monument").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("Erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return  listMonument;
        }
        return listMonument;
    }
}

   

