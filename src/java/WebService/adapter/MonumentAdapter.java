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
import model.Monument;
import java.lang.reflect.Type;

/**
 *
 * @author Administrator
 */
public class MonumentAdapter implements JsonSerializer<Monument> {

    @Override
    public JsonElement serialize(Monument monument, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("idmonument", monument.getIdMonument());
        jsonObject.addProperty("nomm", monument.getNomM());
        jsonObject.addProperty("longitude", monument.getLongitude());
        jsonObject.addProperty("latitude", monument.getLatitude());
        jsonObject.addProperty("description", monument.getDescription());
        jsonObject.addProperty("type", monument.getType());
        jsonObject.addProperty("dateconstruction", monument.getDescription());
        jsonObject.addProperty("image", monument.getImage());
           jsonObject.addProperty("imageMobile", monument.getImagemobile());
                jsonObject.addProperty("ville", monument.getIdVille().getNom());
        jsonObject.addProperty("pays", monument.getIdVille().getPay().getNom());
     


        return jsonObject;
    }
}
