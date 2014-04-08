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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Hotel;

@ManagedBean(name = "hotelManagedBean")
@SessionScoped
public class HotelManagedBean implements Serializable{

    HotelInterface hotelInterface ;
    private Hotel hotel;
    private List<Hotel> listHotel;

    //get+set
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
   
    
 public List<Hotel> getListHotel() {
        hotelInterface = new HotelImpl();
        listHotel = hotelInterface.getListHotel();
        return listHotel;
    }

    public void setListHotel(List<Hotel> listHotel) {
        this.listHotel = listHotel;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        hotel = new Hotel();

    }

    public void editEvent(int id) {
        System.out.print(id);
        hotelInterface = new HotelImpl();
        hotel= hotelInterface.getHotel(id);

    }
 public void suppEvent(int id) {
        System.out.print(id);
        hotelInterface = new HotelImpl();
        hotel= hotelInterface.getHotel(id);

    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("hotel supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        hotelInterface = new HotelImpl();
        hotelInterface.update(hotel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("hotel mise à jour"));
    }

    public void ajoutho(ActionEvent actionEvent) {
        hotelInterface = new HotelImpl();
        hotelInterface.save(hotel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("hotel ajouté"));
        hotel = new Hotel();
    }

    public void delet(ActionEvent actionEvent) {
        hotelInterface = new HotelImpl();
        hotelInterface.remove(hotel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("hotel supprimé"));

    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public HotelManagedBean() {
        this.listHotel = new ArrayList<>();

        if (this.hotel == null) {
            this.hotel = new Hotel();
        }

    }

}
