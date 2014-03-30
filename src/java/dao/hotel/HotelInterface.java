/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.hotel;

import java.util.List;
import model.Hotel;


public interface HotelInterface {

    public void save(Hotel hotel);

    public List<Hotel> list();

    public void remove(Hotel hotel);

    public void update(Hotel hotel);

    public Hotel getHotel(long idHotel);

  
}
