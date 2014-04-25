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
import dao.specialite.SpecialiteImpl;
import dao.specialite.SpecialiteInterface;
import javax.ws.rs.core.MediaType;
import model.Specialite;


@Path("/SpecialiteService")
public class SpecialiteService {

    @GET
    @Path("/GetSpecialites")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {
        
        String feeds = null;
        
        try {
            
            ArrayList<Specialite> feedData;
            SpecialiteInterface ui = new SpecialiteImpl();
            feedData = (ArrayList<Specialite>) ui.getListSpecialite();
            Gson gson = new Gson();
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);
        } catch (Exception e) {
          System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }

}
