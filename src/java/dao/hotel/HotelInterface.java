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

    public void update(Hotel hotel);

    public void remove(Hotel hotel);

    public List<Hotel> getListHotel();//valide
    public List<Hotel> getListHotelInvalide();
    public List<Hotel> getListHotelArchive();

    public Hotel getHotel(int idHotel);

}
