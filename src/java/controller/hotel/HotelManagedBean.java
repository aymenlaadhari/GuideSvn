/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.hotel;

import dao.hotel.HotelImpl;
import dao.hotel.HotelInterface;
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
import javax.imageio.ImageIO;
import model.Hotel;
import model.Ville;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;

@ManagedBean(name = "hotelManagedBean")
@SessionScoped
public class HotelManagedBean implements Serializable {

    HotelInterface hotelInterface;
    private Hotel hotel;
    private List<Hotel> listHotel;
    private Hotel selectHotel;
    private Ville ville;
    private String name;
    private String url;
    private String urlresize;

    public String getUrlresize() {
        return urlresize;
    }

    public void setUrlresize(String urlresize) {
        this.urlresize = urlresize;
    }

    private String urlMobile;

    //get+set
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

    public Hotel getSelectHotel() {
        return selectHotel;
    }

    public void setSelectHotel(Hotel selectHotel) {
        this.selectHotel = selectHotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Hotel> getListHotel() {
        hotelInterface = new HotelImpl();
        listHotel = hotelInterface.getListHotel();
        System.err.println("e " + listHotel);
        return listHotel;
    }

    public List<Hotel> getListHotelInvalide() {
        hotelInterface = new HotelImpl();
        listHotel = hotelInterface.getListHotelInvalide();
        return listHotel;
    }

    public List<Hotel> getListHotelArchive() {
        hotelInterface = new HotelImpl();
        listHotel = hotelInterface.getListHotelArchive();
        return listHotel;
    }

    public void setListHotel(List<Hotel> listHotel) {
        this.listHotel = listHotel;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        hotel = new Hotel();

    }

    public void editEvent(int id) {
        System.out.print(id);
        hotelInterface = new HotelImpl();
        hotel = hotelInterface.getHotel(id);

    }

    public void suppEvent(int id) {
        System.out.print(id);
        hotelInterface = new HotelImpl();
        hotel = hotelInterface.getHotel(id);

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Hôtel supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        hotelInterface = new HotelImpl();
        hotelInterface.update(hotel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Hôtel mise à jour"));
    }

    public void ajoutho(ActionEvent actionEvent) {
        hotelInterface = new HotelImpl();
        hotelInterface.save(hotel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Hôtel ajouté"));
        hotel = new Hotel();
    }

    public void delet(ActionEvent actionEvent) {
        hotelInterface = new HotelImpl();
        hotelInterface.remove(hotel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Hôtel supprimé"));

    }

    //methode pour l affichage de dialog de detail ("flech à gauche")
    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Hôtel :" + ((Hotel) event.getData()).getNomH(), "Ligne  " + event.getVisibility());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //Map
    public void onPointSelectLatitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Point séléctionné", "Latitude:" + latlng.getLat() + ", Longitude:" + latlng.getLng()));

    }

    public void onPointSelectLatitudeLongitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        Double lat = latlng.getLat();
        Double lng = latlng.getLng();
        DecimalFormat df = new DecimalFormat("##0.000000");
        hotel.setLatitude(Double.parseDouble(df.format(lat)));
        hotel.setLongitude(Double.parseDouble(df.format(lng)));

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
    public void fileUploadHotel(FileUploadEvent event) throws IOException {
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

        // save the file uploaded in the resources/images/Hotel
        File file = new File(path + "resources\\images\\hotel" + name);
        url = "http:\\faces\\resources\\images\\hotel" + name;
        urlresize = path + "resources\\images\\hotel" + name;

        hotel.setImage(url);

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
        ImageIO.write(resizeImagePng, "png", new File(path + "resources\\images\\hotel" + name + ".png"));

        urlMobile = "http://192.168.01.100:8080/resources/images/hotel" + name+".png";
        hotel.setImagemobile(urlMobile);

        // save the url of the uploaded image in the database
//    imageInterface = new ImageImpl();
//    image = new Image();
//    image.setData(url);
//    image.setDescription("thanx");
//    image.setNom("monum"+name);
//    imageInterface.save(image);
        FacesMessage msg = new FacesMessage("Le téléchargement de l'image a été effectué avec succés");

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
    public HotelManagedBean() {
        this.listHotel = new ArrayList<Hotel>();

        if (this.hotel == null) {
            this.hotel = new Hotel();
        }

    }

}
