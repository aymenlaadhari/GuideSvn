/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebService.adapter;

import com.google.gson.JsonSerializer;
import model.Pharmacie;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 *
 * @author Administrator
 */
public class PharmacieAdapter implements JsonSerializer<Pharmacie> {

    @Override
    public JsonElement serialize(Pharmacie pharmacie, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("idpharmacie", pharmacie.getIdPhar());
        jsonObject.addProperty("nom", pharmacie.getNom());
        jsonObject.addProperty("siteweb", pharmacie.getSiteweb());
        jsonObject.addProperty("longitude", pharmacie.getLongitude());
        jsonObject.addProperty("latitude", pharmacie.getLatitude());
        jsonObject.addProperty("description", pharmacie.getDescription());
        jsonObject.addProperty("type", pharmacie.getType());
        jsonObject.addProperty("telephone", pharmacie.getTelephone());
        jsonObject.addProperty("email", pharmacie.getEmail());
        jsonObject.addProperty("ville", pharmacie.getIdVille().getNom());
        jsonObject.addProperty("pays", pharmacie.getIdVille().getPay().getNom());
        jsonObject.addProperty("image", pharmacie.getImage());
           jsonObject.addProperty("imageMobile", pharmacie.getImagemobile());

        return jsonObject;
    }
}
