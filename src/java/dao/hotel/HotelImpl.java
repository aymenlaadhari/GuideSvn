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
        Transaction t = session.beginTransaction();
        session.save(hotel);
        t.commit();
     }

    @Override
    public List<Hotel> list() 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List listeHotel = session.createQuery("from Hotel").list();
        transaction.commit();
        return listeHotel;
        
       }

    @Override
    public void remove(Hotel hotel) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(hotel);
        t.commit();
     }

    @Override
    public void update(Hotel hotel) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(hotel);
       t.commit();
        }

    @Override
    public Hotel getHotel(long idHotel) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Hotel) session.load(Hotel.class, idHotel);
       
    }

}
