/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import WebService.adapter.CentreMedicalAdapter;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.centreMedical.CentreMedicalImpl;
import dao.centreMedical.CentreMedicaleInterface;
import java.util.List;
import javax.ws.rs.core.MediaType;
import model.CentreMedicale;
;

@Path("/CentreMedicaleService")
public class CentreMedicaleService {

    @GET
    @Path("/GetCentreMedicals")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {
        
        String feeds = null;
        
        try {
            
            ArrayList<CentreMedicale> feedData;
            CentreMedicaleInterface ui = new CentreMedicalImpl();
            feedData = (ArrayList<CentreMedicale>) ui.getListCentreMedicale();
            Gson gson = new Gson();
            System.out.println((feedData));
          //  System.out.println(gson.toJson(feedData));
            feeds = messagesToJson(feedData);
        } catch (Exception e) {
          System.out.println("Exception Error"); //Console 
        }
        return "{\"centreMedicals\":"+feeds+"}";
    }
     public String messagesToJson(List<CentreMedicale> messages) {  
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.registerTypeAdapter(CentreMedicale.class, new CentreMedicalAdapter()).create();
    return gson.toJson(messages);
}  

}
