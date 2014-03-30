/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.monument;


import java.util.List;
import model.Monument;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;



/**
 *
 * @author hp
 */
public class MonumentImpl implements MonumentInterface
{

    @Override
    public void save(Monument monument) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(monument);
        t.commit();
     }

    @Override
    public List<Monument> list() 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction transaction = session.beginTransaction();
       List listeMonument = session.createQuery("from Monument").list();
       transaction.commit();
       return listeMonument;
     
          }

    @Override
    public void remove(Monument monument) 
    {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(monument);
        t.commit();
         }

    @Override
    public void update(Monument monument) 
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(monument);
      t.commit();
         }

    @Override
    public Monument getMonument(long idMonument) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Monument) session.load(Monument.class, idMonument);
       
         }


}
