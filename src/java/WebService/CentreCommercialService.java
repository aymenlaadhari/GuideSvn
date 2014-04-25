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
import dao.centreCommercial.CentreCommercialImp;
import dao.centreCommercial.CentreInt;
import javax.ws.rs.core.MediaType;
import model.CentreCommercial;

@Path("/CentreCommercial")
public class CentreCommercialService {

    @GET
    @Path("/GetCentreCommercials")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {
        
        String feeds = null;
        
        try {
            
            ArrayList<CentreCommercial> feedData;
            CentreInt ui = new CentreCommercialImp();
            feedData = (ArrayList<CentreCommercial>) ui.getListCentreCommercial();
            Gson gson = new Gson();
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);
        } catch (Exception e) {
          System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }

}
