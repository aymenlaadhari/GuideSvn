/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebService.adapter;

import model.CentreCommercial;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 *
 * @author Administrator
 */
public class CentreCommAdapter implements JsonSerializer<CentreCommercial> {

    @Override
    public JsonElement serialize(CentreCommercial centreCommercial, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("idcc", centreCommercial.getIdCC());
        jsonObject.addProperty("nom", centreCommercial.getNom());
        jsonObject.addProperty("siteweb", centreCommercial.getSiteweb());
        jsonObject.addProperty("longitude", centreCommercial.getLongitude());
        jsonObject.addProperty("latitude", centreCommercial.getLatitude());
        jsonObject.addProperty("description", centreCommercial.getDescription());
        jsonObject.addProperty("type", centreCommercial.getType());
        jsonObject.addProperty("telephone", centreCommercial.getTelephone());
        jsonObject.addProperty("email", centreCommercial.getEmail());
        jsonObject.addProperty("ville", centreCommercial.getIdVille().getNom());
        jsonObject.addProperty("pays", centreCommercial.getIdVille().getPay().getNom());
        jsonObject.addProperty("image", centreCommercial.getImage());
        jsonObject.addProperty("imageMobile", centreCommercial.getImagemobile());

        return jsonObject;
    }
}
