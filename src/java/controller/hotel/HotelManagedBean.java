/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.hotel;

import dao.hotel.HotelImpl;
import dao.hotel.HotelInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Hotel;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class HotelManagedBean implements Serializable {

    private Hotel hotel;
    private List<Hotel> hotels;
    HotelInterface hotelInterface;

    //getteur et setteur -->hotel
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    //getteur et setteur -->listHotel
    public List<Hotel> getHotels() {
        hotelInterface = new HotelImpl();
        this.hotels = hotelInterface.list();
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

///les methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        hotel = new Hotel();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Hotel supprimé"));
    }

    public void editEvent(long id) {
        System.out.print(id);
        hotelInterface = new HotelImpl();
        hotel = hotelInterface.getHotel(id);

    }

    public void edition(ActionEvent actionEvent) {
        hotelInterface = new HotelImpl();
        hotelInterface.update(hotel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Hotel mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        hotelInterface = new HotelImpl();
        hotelInterface.save(hotel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Hotel Evenement ajouté"));
        hotel = new Hotel();
    }

    public void delet(Hotel hotel) {
        hotelInterface = new HotelImpl();
        hotelInterface.remove(hotel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Hotel supprimé"));

    }

    /**
     * Creates a new instance of HotelManagedBean
     */
    public HotelManagedBean() {

        this.hotels = new ArrayList<>();
        if (this.hotel == null) {
            this.hotel = new Hotel();
        }

    }

}
