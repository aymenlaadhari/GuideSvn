/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.restaurant;


import dao.restaurant.RestaurantImpl;
import dao.restaurant.RestaurantInterface;
import dao.specialite.SpecialiteInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;




import model.Restaurant;
import model.Specialite;

/**
 *
 * @author hp
 */
@ManagedBean(name = "RestaurantManagedBean")
@SessionScoped
public class RestaurantManagedBean implements Serializable{
    
 RestaurantInterface restaurantInterface;
 SpecialiteInterface specialiteInterface;
    private Restaurant restaurant;
    private Specialite specialite;
       private List<Restaurant> listRestaurant;

//get+set
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
     public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public List<Restaurant> getListRestaurant() {
         restaurantInterface= new RestaurantImpl();
        listRestaurant = restaurantInterface.getlistResto();
        return listRestaurant;
    }

    public void setListRestaurant(List<Restaurant> listRestaurant) {
        this.listRestaurant = listRestaurant;
    }
   

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        restaurant= new Restaurant();

    }
    

    public void editEvent(int id) {
        System.out.print(id);
        restaurantInterface = new RestaurantImpl();
        restaurant = restaurantInterface.getRestaurant(id);

    }
public void suppEvent(int id) {
        System.out.print(id);
        restaurantInterface = new RestaurantImpl();
        restaurant = restaurantInterface.getRestaurant(id);

    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        restaurantInterface = new RestaurantImpl();
        restaurantInterface.update(restaurant);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant mise à jour"));
    }

    public void ajoutr(ActionEvent actionEvent) {
        restaurantInterface = new RestaurantImpl();
        restaurantInterface.save(restaurant);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant ajouté"));
        restaurant = new Restaurant();
    }

    public void delet(ActionEvent actionEvent) {
        restaurantInterface = new RestaurantImpl();
          restaurantInterface.remove(restaurant);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant supprimé"));

    }


    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public RestaurantManagedBean() {
        this.listRestaurant = new ArrayList<>();

        if (this.restaurant == null) {
            this.restaurant = new Restaurant();

    }
    }
}
