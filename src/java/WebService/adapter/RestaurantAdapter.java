/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService.adapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import model.Restaurant;

/**
 *
 * @author Administrator
 */
public class RestaurantAdapter implements JsonSerializer<Restaurant> {

    @Override
    public JsonElement serialize(Restaurant restaurant, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("idresto", restaurant.getIdResto());
        jsonObject.addProperty("nom", restaurant.getNom());
        jsonObject.addProperty("siteweb", restaurant.getSiteweb());
        jsonObject.addProperty("longitude", restaurant.getLongitude());
        jsonObject.addProperty("latitude", restaurant.getLatitude());
        jsonObject.addProperty("description", restaurant.getDescription());
       // jsonObject.addProperty("specialite",restaurant.getSpecialite().getNom());
        jsonObject.addProperty("telephone", restaurant.getTelephone());
        jsonObject.addProperty("email", restaurant.getEmail());
         jsonObject.addProperty("horaireouverture", restaurant.getHorairehouverture().toString());
        jsonObject.addProperty("horairefermeture", restaurant.getHorairefermeture().toString());
        jsonObject.addProperty("ville", restaurant.getIdVille().getNom());
        jsonObject.addProperty("pays", restaurant.getIdVille().getPay().getNom());
        jsonObject.addProperty("image", restaurant.getImage());
           jsonObject.addProperty("imageMobile", restaurant.getImagemobile());

        return jsonObject;
    }
}
