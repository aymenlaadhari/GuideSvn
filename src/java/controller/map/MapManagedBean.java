/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.map;

import java.nio.channels.FileChannel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.map.Circle;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class MapManagedBean {

    private final double DISTANCE_MM = 2800;
    private final double DISTANCE_METERS = 1852;
    private String centerCoords = "6.920833, 103.578611";
    private final MapModel mapModel;
    
    public MapManagedBean() {
        mapModel = new DefaultMapModel();
        LatLng coordl = new LatLng(6.920833, 103.578611);
        Circle circle = new Circle(coordl, DISTANCE_METERS);
        circle.setFillColor("#FFFFF66");
        circle.setFillColor("FFFFF66");
        circle.setFillOpacity(0.2);
        mapModel.addOverlay(circle);
        
        //Airport Coordinates
        LatLng coord2 = new LatLng(3.1357, 101.6880);
        mapModel.addOverlay(new  Marker(coord2, "uala Lampur International Airport", "http://maps.gogle.com/mapfiles/ms/micons/yellow-dot.png"));
    }
    
}
