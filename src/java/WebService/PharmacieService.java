/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import WebService.adapter.PharmacieAdapter;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.pharmacie.PharmacieImpl;
import dao.pharmacie.PharmacieInterface;
import java.util.List;
import javax.ws.rs.core.MediaType;
import model.Pharmacie;

@Path("/PharmacieService")
public class PharmacieService {

    @GET
    @Path("/GetPharmacies")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {

        String feeds = null;

        try {

            ArrayList<Pharmacie> feedData;
            PharmacieInterface ui = new PharmacieImpl();
            feedData = (ArrayList<Pharmacie>) ui.getListPharmacie();
            Gson gson = new Gson();
            //System.out.println(gson.toJson(feedData));
            //feeds = gson.toJson(feedData);
            System.out.println((feedData));
            feeds = messagesToJson(feedData);
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return "{\"pharmacies\":" + feeds + "}";
    }
    public String messagesToJson(List<Pharmacie> messages) {  
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.registerTypeAdapter(Pharmacie.class, new PharmacieAdapter()).create();
    return gson.toJson(messages);
}  


}
