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
import dao.ville.VilleImpl;
import dao.ville.VilleInterface;
import javax.ws.rs.core.MediaType;
import model.Ville;

@Path("/VilleService")
public class VilleService {

    @GET
    @Path("/GetVilles")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {
        
        String feeds = null;
        
        try {
            
            ArrayList<Ville> feedData;
            VilleInterface ui = new VilleImpl();
            feedData = (ArrayList<Ville>) ui.getListVille();
            Gson gson = new Gson();
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);
        } 
        catch (Exception e)
        {
          System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }

}
