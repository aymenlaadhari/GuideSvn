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
import model.Hotel;

/**
 *
 * @author Administrator
 */
public class HotelAdapter implements JsonSerializer<Hotel> {

    @Override
    public JsonElement serialize(Hotel hotel, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("idhotel", hotel.getIdHotel());
        jsonObject.addProperty("nomh", hotel.getNomH());
        jsonObject.addProperty("sitewebh", hotel.getSitewebH());
        jsonObject.addProperty("longitude", hotel.getLongitude());
        jsonObject.addProperty("latitude", hotel.getLatitude());
        jsonObject.addProperty("description", hotel.getDescription());
        jsonObject.addProperty("nbreetoile", hotel.getNbreetoile());
        jsonObject.addProperty("telephoneh", hotel.getTelephoneH());
        jsonObject.addProperty("emailh", hotel.getEmailH());
        jsonObject.addProperty("ville", hotel.getIdVille().getNom());
        jsonObject.addProperty("pays", hotel.getIdVille().getPay().getNom());
        jsonObject.addProperty("image", hotel.getImage());
        jsonObject.addProperty("imageMobile", hotel.getImagemobile());

        return jsonObject;
    }
}
