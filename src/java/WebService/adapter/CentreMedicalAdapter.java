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
import model.CentreMedicale;


/**
 *
 * @author Administrator
 */
public class CentreMedicalAdapter implements JsonSerializer<CentreMedicale> {

    @Override
    public JsonElement serialize(CentreMedicale CentreMedicale, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("idcm", CentreMedicale.getIdCM());
        jsonObject.addProperty("nom", CentreMedicale.getNom());
        jsonObject.addProperty("siteweb", CentreMedicale.getSiteweb());
        jsonObject.addProperty("longitude", CentreMedicale.getLongitude());
        jsonObject.addProperty("latitude", CentreMedicale.getLatitude());
        jsonObject.addProperty("description", CentreMedicale.getDescription());
        jsonObject.addProperty("type", CentreMedicale.getType());
        jsonObject.addProperty("telephone", CentreMedicale.getTelephone());
        jsonObject.addProperty("email", CentreMedicale.getEmail());
        jsonObject.addProperty("ville", CentreMedicale.getIdVille().getNom());
        jsonObject.addProperty("pays", CentreMedicale.getIdVille().getPay().getNom());
        jsonObject.addProperty("image", CentreMedicale.getImage());
           jsonObject.addProperty("imageMobile", CentreMedicale.getImagemobile());

        return jsonObject;
    }
}
