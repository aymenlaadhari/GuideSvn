/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pays;


import dao.pharmacie.PharmacieImpl;
import dao.pharmacie.PharmacieInterface;
import dao.restaurant.RestaurantImpl;
import dao.restaurant.RestaurantInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;



import model.Restaurant;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class RestaurantManagedBean implements Serializable {

    private Restaurant restaurant;
    private DataModel listRestaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    

    public DataModel getListRestaurant() {
        List<Restaurant> list = new RestaurantImpl().list();
        listRestaurant = new ListDataModel(list);

        return listRestaurant;
    }

    public String preparerAjout() {
        restaurant = new Restaurant();
        return "gestionRestaurant";
    }

    public String preparerModifier() {
        restaurant = (Restaurant) (listRestaurant.getRowData());
        return "gestionRestaurant";
    }

    public String supprimer() {
        Restaurant restaurantTemp = (Restaurant) (listRestaurant.getRowData());
        RestaurantInterface cmi = new RestaurantImpl();
        cmi.remove(restaurantTemp);
        return "indexRestaurant";
    }

    public String ajouter() {
        RestaurantInterface cmi = new RestaurantImpl();
        cmi.save(restaurant);
        return "indexRestaurant";
    }

    public String modifier() {
        RestaurantInterface cmi = new RestaurantImpl();
        cmi.update(restaurant);
        return "indexRestaurant";
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public RestaurantManagedBean() {

        if (this.restaurant == null) {
            this.restaurant = new Restaurant();
        }

    }

}
