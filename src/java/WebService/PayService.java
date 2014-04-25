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
import dao.pays.PaysImpl;
import dao.pays.PaysInterface;
import javax.ws.rs.core.MediaType;
import model.Pay;

@Path("/PayService")
public class PayService {

    @GET
    @Path("/GetPays")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {
        
        String feeds = null;
        
        try {
            
            ArrayList<Pay> feedData;
            PaysInterface ui = new PaysImpl();
            feedData = (ArrayList<Pay>) ui.getListPays();
            Gson gson = new Gson();
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);
        } catch (Exception e) {
          System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }

}
