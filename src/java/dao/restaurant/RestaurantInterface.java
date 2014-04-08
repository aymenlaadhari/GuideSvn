/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.restaurant;

import java.util.List;
import model.Restaurant;

public interface RestaurantInterface {

    public void save(Restaurant restaurant);
    public List<Restaurant> getlistResto();
    public void remove(Restaurant restaurant);
    public void update(Restaurant restaurant);
    public Restaurant getRestaurant(int id);

    //public Restaurant findByRestaurant(Restaurant restaurant);
}
