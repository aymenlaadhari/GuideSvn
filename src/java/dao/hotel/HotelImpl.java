/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.hotel;

import java.util.List;
import model.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;



/**
 *
 * @author hp
 */
public class HotelImpl implements HotelInterface{

    @Override
    public void save(Hotel hotel) 
    {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(hotel);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            System.out.print("Erreur insertion" + e.getMessage());
        }
     }

    @Override
    public List<Hotel> getListHotel() 
    {
         List<Hotel> listHotel = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
           listHotel = session.createQuery("from Hotel").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listHotel;
        }
        return listHotel;
    
       }

    @Override
    public void remove(Hotel hotel) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(hotel);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("Erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
        }
     }

    @Override
    public void update(Hotel hotel) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(hotel);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            System.out.print("Erreur Modification" + e.getMessage());
        }
        }

    @Override
    public Hotel getHotel(int idHotel) 
    {
        Hotel hotel   = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            hotel= (Hotel) session.get(Hotel.class, idHotel);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return hotel;
        }
        return hotel;
       
    }

}
