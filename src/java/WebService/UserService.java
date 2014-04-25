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
import dao.utilisateur.UtilisateurImpl;
import dao.utilisateur.UtilisateurInterface;
import javax.ws.rs.core.MediaType;
import model.Utilisateur;

@Path("/UserService")
public class UserService {

    @GET
    @Path("/GetUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {
        
        String feeds = null;
        
        try {
            
            ArrayList<Utilisateur> feedData;
            UtilisateurInterface ui = new UtilisateurImpl();
            feedData = (ArrayList<Utilisateur>) ui.getListUtilisateur();
            Gson gson = new Gson();
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);
        } catch (Exception e) {
          System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }

}
