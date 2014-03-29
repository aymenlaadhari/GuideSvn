/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.restaurant;

import java.util.List;
import model.Restaurant;

/**
 *
 * @author hp
 */
public interface RestaurantInterface {

    public void save(Restaurant restaurant);

    public List<Restaurant> list();

    public void remove(Restaurant restaurant);

    public void update(Restaurant restaurant);

    public Restaurant getCentre(long id);

    //public Restaurant findByRestaurant(Restaurant restaurant);
}
