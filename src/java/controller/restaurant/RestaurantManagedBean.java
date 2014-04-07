/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.restaurant;

import dao.restaurant.RestaurantImpl;
import dao.restaurant.RestaurantInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Restaurant;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class RestaurantManagedBean implements Serializable {

    private Restaurant restaurant;
    private List<Restaurant> restaurants;
     RestaurantInterface restaurantInterface;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant selectedRestaurant) {
        this.restaurant = selectedRestaurant;
    }

    public List<Restaurant> getRestaurants() {
        restaurantInterface = new RestaurantImpl();
        this.restaurants = restaurantInterface.list();
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

     public void ajoutEvent(ActionEvent actionEvent) {
        restaurant = new Restaurant();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant supprimé"));
    }

    public void editEvent(long id) {
        System.out.print(id);
        restaurantInterface = new RestaurantImpl();
        restaurant = restaurantInterface.getCentre(id);

    }

    public void edition(ActionEvent actionEvent) {
        restaurantInterface = new RestaurantImpl();
        restaurantInterface.update(restaurant);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Restaurant mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        restaurantInterface = new RestaurantImpl();
        restaurantInterface.save(restaurant);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant Evenement ajouté"));
        restaurant = new Restaurant();
    }

    public void delet(Restaurant restaurant) {
        restaurantInterface = new RestaurantImpl();
        restaurantInterface.remove(restaurant);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Restaurant supprimé"));

    }

    
    public RestaurantManagedBean() {

        this.restaurants = new ArrayList<>();

        if (this.restaurant == null) {
            this.restaurant = new Restaurant();
        }

    }

}
