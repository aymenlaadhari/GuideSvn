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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;




import model.Restaurant;
import org.primefaces.event.ToggleEvent;


/**
 *
 * @author hp
 */
@ManagedBean(name = "RestaurantManagedBean")
@SessionScoped
public class RestaurantManagedBean implements Serializable{
    
 RestaurantInterface restaurantInterface;
 private Restaurant restaurant;
 private List<Restaurant> listRestaurant;
 private Restaurant selectResto;

//get+set
 
    public Restaurant getSelectResto() {
        return selectResto;
    }

    public void setSelectResto(Restaurant selectResto) {
        this.selectResto = selectResto;
    }
 
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
    

    public void editEvent(int idresto) {
        System.out.print(idresto);
        restaurantInterface = new RestaurantImpl();
        restaurant = restaurantInterface.getRestaurant(idresto);

    }
public void suppEvent(int idresto) {
        System.out.print(idresto);
        restaurantInterface = new RestaurantImpl();
        restaurant = restaurantInterface.getRestaurant(idresto);

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

//methode pour l affichage de dialog de detail ("flech à gauche")
  public void onRowToggle(ToggleEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
                                            "Ligne  " + event.getVisibility(),  
                                            "Nom :" + ((Restaurant) event.getData()).getNom());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
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
