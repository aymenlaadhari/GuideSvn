/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.hotel.HotelImpl;
import dao.hotel.HotelInterface;
import java.util.List;
import javax.ws.rs.core.MediaType;
import WebService.adapter.HotelAdapter;
import model.Hotel;


@Path("/HotelService")
public class HotelService {

    @GET
    @Path("/GetHotels")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {
        
        String feeds = null;
        
        try {
            
            ArrayList<Hotel> feedData;
            HotelInterface ui = new HotelImpl();
            feedData = (ArrayList<Hotel>) ui.getListHotel();
            Gson gson = new Gson();
            System.out.println((feedData));
          //  System.out.println(gson.toJson(feedData));
            feeds = messagesToJson(feedData);
        } catch (Exception e) {
          System.out.println("Exception Error"); //Console 
        }
        return "{\"hotels\":"+feeds+"}";
    }
     public String messagesToJson(List<Hotel> messages) {  
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.registerTypeAdapter(Hotel.class, new HotelAdapter()).create();
    return gson.toJson(messages);
}  

}
