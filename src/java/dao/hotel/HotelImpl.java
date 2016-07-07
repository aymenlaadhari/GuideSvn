/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.hotel;

import java.util.List;
import model.Hotel;
import model.Pay;
import model.Ville;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class HotelImpl implements HotelInterface {

    @Override
    public void save(Hotel hotel) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(hotel);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien ajouté");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Erreur insertion" + e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public List<Hotel> getListHotel() {
        List<Hotel> listHotel = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            listHotel = session.createQuery("from Hotel where validation = true and archive = false").list();
            for (Hotel cp : listHotel) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listHotel;
        }
        return listHotel;

    }

    @Override
    public void remove(Hotel hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(hotel);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void update(Hotel hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(hotel);
            session.getTransaction().commit();
            session.close();
            System.out.print("Bien modifier");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Erreur Modification" + e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public Hotel getHotel(int idHotel) {
        Hotel hotel = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            hotel = (Hotel) session.get(Hotel.class, idHotel);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return hotel;
        }
        return hotel;

    }

    @Override
    public List<Hotel> getListHotelInvalide() {
        List<Hotel> listHotelInvalide = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            listHotelInvalide = session.createQuery("from Hotel where validation = false and archive = false").list();
             for (Hotel cp : listHotelInvalide) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listHotelInvalide;
        }
        return listHotelInvalide;
    }

    @Override
    public List<Hotel> getListHotelArchive() {
        List<Hotel> listHotelArchive = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            listHotelArchive = session.createQuery("from Hotel where validation = true and archive = true").list();
             for (Hotel cp : listHotelArchive) {
                org.hibernate.Hibernate.initialize(cp.getIdVille());
                //or cp.getCustomer().getLoginName();
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("erreur suppression" + e.getMessage());
            session.beginTransaction().rollback();
            return listHotelArchive;
        }
        return listHotelArchive;
    }

    public List<Pay> getListAllPaysHotel() {
        List<Pay> listHotelPays = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            //    listHotelPays = session.createSQLQuery("select distinct h.idVille from  hotel h").list();

            listHotelPays = session.createSQLQuery("select distinct h.idVille.pay from  hotel h").addEntity(Hotel.class).list();

            /*   session.createSQLQuery("SELECT * FROM hotel h, ville v WHERE h.idVille = v.idVille")
             .addEntity("hotel", Hotel.class)
             .addJoin("hotel","idVille");
            
             session.createSQLQuery("SELECT c.ID, NAME, BIRTHDATE, DOG_ID, D_ID, D_NAME FROM CATS c, DOGS d WHERE c.DOG_ID = d.D_ID")
             .addEntity("cat", Hotel.class)
             .addJoin("cat.dog");*/
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            e.printStackTrace();
            session.beginTransaction().rollback();
            return listHotelPays;
        }
        return listHotelPays;
    }

    public List<Pay> getListAllPays() {
        List<Pay> listHotelPays = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            listHotelPays = session.createQuery("from Pay p where p.idPay in "
                    + "(select v.pay from Ville v, Hotel h where v.idVille=h.idVille)").list();

            /*listHotelPays = session.createSQLQuery("select h.idHotel, distinct h.idVille as ville from  hotel as h")
             .addEntity(Hotel.class)
                    
             .list();*/
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur suppression" + e.getMessage());
            e.printStackTrace();
            session.beginTransaction().rollback();
            return listHotelPays;
        }
        return listHotelPays;
    }

    public List<Ville> getListAllVille(String pays) {
        List<Ville> listHotelVille = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            listHotelVille = session.createQuery("from Ville v where v.idVille in "
                    + "(select h.idVille from Ville vv, Hotel h where vv.idVille=h.idVille and vv.pay.nom=:nom)").setParameter("nom", pays).list();

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur getListAllVille" + e.getMessage());
            e.printStackTrace();
            session.beginTransaction().rollback();
            return listHotelVille;
        }
        return listHotelVille;
    }
        public List<Hotel> getListAllHotel(String pays,String ville) {
        List<Hotel> listHotel = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            listHotel = session.createQuery("from Hotel h where h.idVille in "
                    + "(select vv.idVille from Ville vv where vv.pay.nom=:nomPays and vv.nom=:nom)")
                    .setParameter("nomPays", pays).setParameter("nom", ville)
                    .list();

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.print("erreur getListAllVille" + e.getMessage());
            e.printStackTrace();
            session.beginTransaction().rollback();
            return listHotel;
        }
        return listHotel;
    }

}
