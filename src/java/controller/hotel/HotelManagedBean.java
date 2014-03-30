/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.hotel;


import dao.hotel.HotelImpl;
import dao.hotel.HotelInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Hotel;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class HotelManagedBean implements Serializable {

    private Hotel hotel ;
    private DataModel listHotel;

   //getteur et setteur -->hotel
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

   //getteur et setteur -->listHotel
    public DataModel getListHotel() {
        
       List<Hotel> list = new HotelImpl().list();
       listHotel = new ListDataModel(list); 
        return listHotel;
    }

///les methodes
    public String preparerAjout() {
        hotel = new Hotel();
        return "gestionHotel";
    }

    public String preparerModifier() {
        hotel = (Hotel) (listHotel.getRowData());
        return "gestionHotel";
    }

   

    public String ajouter() {
        HotelInterface hotelInterface = new HotelImpl();
        hotelInterface.save(hotel);
        return "indexHotel";
    }

    public String modifier() {
        HotelInterface ht = new HotelImpl();
        ht.update(hotel);
        return "indexHotel";
    }
 public String supprimer() {
        Hotel hotelTemp = (Hotel) (listHotel.getRowData());
        HotelInterface hotelInterface = new HotelImpl();
        hotelInterface.remove(hotelTemp);
        return "indexHotel";
    }
    /**
     * Creates a new instance of HotelManagedBean
     */
    public HotelManagedBean() {

        if (this.hotel == null) {
            this.hotel = new Hotel();
        }

    }
    

}
