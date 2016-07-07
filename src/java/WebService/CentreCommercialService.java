/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;
import WebService.adapter.CentreCommAdapter;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.centreCommercial.CentreCommercialImp;
import dao.centreCommercial.CentreInt;
import java.util.List;
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
            System.out.println((feedData));
          //  System.out.println(gson.toJson(feedData));
            feeds = messagesToJson(feedData);
        } catch (Exception e) {
          System.out.println("Exception Error"); //Console 
        }
       return "{\"centreCommercials\":"+feeds+"}";
    }
    public String messagesToJson(List<CentreCommercial> messages) {  
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.registerTypeAdapter(CentreCommercial.class, new CentreCommAdapter()).create();
    return gson.toJson(messages);
}  


}
