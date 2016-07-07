/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.restaurant;

import dao.restaurant.RestaurantImpl;
import dao.restaurant.RestaurantInterface;
import dao.specialite.SpecialiteImpl;
import dao.specialite.SpecialiteInterface;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;
import model.Restaurant;
import model.Specialite;
import model.Ville;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;

/**
 *
 * @author hp
 */
@ManagedBean(name = "RestaurantManagedBean")
@SessionScoped
public class RestaurantManagedBean implements Serializable {

    RestaurantInterface restaurantInterface;
    private Restaurant restaurant;
    private List<Restaurant> listRestaurant;
    private Restaurant selectResto;
    private Ville ville;
    private String name;
    private String url;
    private String urlresize;

    private String urlMobile;

    //get+set
    public String getUrlresize() {
        return urlresize;
    }

    public void setUrlresize(String urlresize) {
        this.urlresize = urlresize;
    }

    public String getUrlMobile() {
        return urlMobile;
    }

    public void setUrlMobile(String urlMobile) {
        this.urlMobile = urlMobile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Ville getVille() {
        return ville;
    }

    public Restaurant getSelectResto() {
        return selectResto;
    }

    public void setSelectResto(Restaurant selectResto) {
        this.selectResto = selectResto;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Restaurant> getListRestaurant() {
        restaurantInterface = new RestaurantImpl();
        listRestaurant = restaurantInterface.getlistResto();
        return listRestaurant;
    }

    public List<Restaurant> getListRestaurantInvaide() {
        restaurantInterface = new RestaurantImpl();
        listRestaurant = restaurantInterface.getlistRestoInvalide();
        System.err.println("e " + listRestaurant);
        return listRestaurant;
    }

    public List<Restaurant> getListRestaurantArchive() {
        restaurantInterface = new RestaurantImpl();
        listRestaurant = restaurantInterface.getlistRestoArchive();
        return listRestaurant;
    }

    public void setListRestaurant(List<Restaurant> listRestaurant) {
        this.listRestaurant = listRestaurant;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        restaurant = new Restaurant();

    }

    public void editEvent(int idresto) {
        System.out.print(idresto);
        restaurantInterface = new RestaurantImpl();
        restaurant = restaurantInterface.getRestaurant(idresto);

    }

    public void suppEvent(int idresto) {
        System.out.print(idresto);
        restaurantInterface = new RestaurantImpl();
        restaurant = restaurantInterface.getRestaurant(idresto);

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        restaurantInterface = new RestaurantImpl();
        restaurantInterface.update(restaurant);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant mise à jour"));
    }

    public void ajoutr(ActionEvent actionEvent) {
        restaurantInterface = new RestaurantImpl();
        restaurantInterface.save(restaurant);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant ajouté"));
        restaurant = new Restaurant();
    }

    public void delet(ActionEvent actionEvent) {
        restaurantInterface = new RestaurantImpl();
        restaurantInterface.remove(restaurant);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Restaurant supprimé"));

    }

//methode pour l affichage de dialog de detail ("flech à gauche")
    public void onRowToggle(ToggleEvent event) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
//                                            "Ligne  " + event.getVisibility(),  
//                                            "Nom :" + ((Restaurant) event.getData()).getNom());  
//          
//        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }

    ///
    public List<SelectItem> getAllSpecialites() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        SpecialiteInterface specialiteInter = new SpecialiteImpl();
        List<Specialite> specialiteList = specialiteInter.getListSpecialite();
        for (Specialite specialite : specialiteList) {
            items.add(new SelectItem(specialite.getNom()));
        }

        return items;
    }

    ///list pays dans ville
    public List<Specialite> getAllSpecialiteRestaurant() {
        SpecialiteInterface specialiteInter = new SpecialiteImpl();
        List<Specialite> specialiteList = specialiteInter.getListSpecialite();
        return specialiteList;
    }

    //Map
    public void onPointSelectLatitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Point sélectionné", "Latitude:" + latlng.getLat() + ", Longitude:" + latlng.getLng()));

    }

    public void onPointSelectLatitudeLongitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        Double lat = latlng.getLat();
        Double lng = latlng.getLng();
        DecimalFormat df = new DecimalFormat("##0.000000");
        restaurant.setLatitude(Double.parseDouble(df.format(lat)));
        restaurant.setLongitude(Double.parseDouble(df.format(lng)));

    }

    public void onStateChange(StateChangeEvent event) {
        LatLngBounds bounds = event.getBounds();
        int zoomLevel = event.getZoomLevel();

//        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Zoom Level", String.valueOf(zoomLevel)));
//        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Center", event.getCenter().toString()));
//        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "NorthEast", bounds.getNorthEast().toString()));
//        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "SouthWest", bounds.getSouthWest().toString()));
    }

    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // function to upload image
    public void fileUpload(FileUploadEvent event) throws IOException {
        String path = FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("/");

        //change the local directory
        String supp = "\\build";
        path = path.replace(supp, "");
        //rename the file
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
        name = fmt.format(new Date())
                + event.getFile().getFileName().substring(
                        event.getFile().getFileName().lastIndexOf('.'));

        // save the file uploaded in the ressource/images/monument
        File file = new File(path + "resources\\images\\restaurant" + name);
        url = "http:\\faces\\resources\\images\\restaurant" + name;
        urlresize = path + "resources\\images\\restaurant";

        restaurant.setImage(url);

        InputStream is = event.getFile().getInputstream();
        OutputStream out = new FileOutputStream(file);
        byte buf[] = new byte[1024];
        int len;
        while ((len = is.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        is.close();
        out.close();
        BufferedImage originalImage = ImageIO.read(new File(urlresize));
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        BufferedImage resizeImagePng = resizeImage(originalImage, type);
        String supp1 = ".jpg";
        name = name.replace(supp1, "");
        ImageIO.write(resizeImagePng, "png", new File(path + "resources\\images\\restaurant" + name + ".png"));

        urlMobile = "http://172.16.0.11:8084/resources/images/restaurant" + name + ".png";
        restaurant.setImagemobile(urlMobile);
        FacesMessage msg = new FacesMessage("Le téléchargement de l'image a été effectué avec succés.");

        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(365, 256, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 365, 256, null);
        g.dispose();

        return resizedImage;
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public RestaurantManagedBean() {
        this.listRestaurant = new ArrayList<Restaurant>();

        if (this.restaurant == null) {
            this.restaurant = new Restaurant();

        }
    }
}
