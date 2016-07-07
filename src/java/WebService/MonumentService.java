/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import WebService.adapter.MonumentAdapter;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.monument.MonumentImpl;
import dao.monument.MonumentInterface;
import java.util.List;
import javax.ws.rs.core.MediaType;
import model.Monument;

@Path("/MonumentService")
public class MonumentService {

    @GET
    @Path("/GetMonuments")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {
        
        String feeds = null;
        
        try {
            
            ArrayList<Monument> feedData;
            MonumentInterface ui = new MonumentImpl();
            feedData = (ArrayList<Monument>) ui.getListMonument();
            Gson gson = new Gson();
            System.out.println((feedData));
            //System.out.println(gson.toJson(feedData));
            
           // feeds = gson.toJson(feedData);
            feeds = messagesToJson(feedData);
        } catch (Exception e) {
            e.printStackTrace();
          System.out.println("Exception Error"); //Console 
        }
        return "{\"monuments\":"+feeds+"}";
    }
    
    
    public String messagesToJson(List<Monument> messages) {  
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.registerTypeAdapter(Monument.class, new MonumentAdapter()).create();
    return gson.toJson(messages);
}  

}
