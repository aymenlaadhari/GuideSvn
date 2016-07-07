/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.monument;

import dao.monument.MonumentImpl;
import dao.monument.MonumentInterface;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Monument;
import model.Ville;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.imageio.ImageIO;

@ManagedBean(name = "MonumentManagedBean")
@SessionScoped
public class MonumentManagedBean implements Serializable {

    MonumentInterface monumentInterface;
    private Monument monument;
    private List<Monument> listMonument;
    private Monument selectedMonument;
    private Ville ville;
    private String url;
    private String urlresize;
    private String name;
    private String urlMobile;

    //get+set
    public String getUrlMobile() {
        return urlMobile;
    }

    public String getUrlresize() {
        return urlresize;
    }

    public void setUrlresize(String urlresize) {
        this.urlresize = urlresize;
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

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Monument getSelectedMonument() {
        return selectedMonument;
    }

    public void setSelectedMonument(Monument selectedMonument) {
        this.selectedMonument = selectedMonument;
    }

    public Monument getMonument() {
        return monument;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
    }

    public List<Monument> getListMonument() {
        monumentInterface = new MonumentImpl();
        listMonument = monumentInterface.getListMonument();
        System.err.println("e " + listMonument);
        return listMonument;
    }

    public void setListMonument(List<Monument> listMonument) {
        this.listMonument = listMonument;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        monument = new Monument();

    }

    public void editEvent(int id) {
        System.out.print(id);
        monumentInterface = new MonumentImpl();
        monument = monumentInterface.getMonument(id);

    }

    public void suppEvent(int id) {
        System.out.print(id);
        monumentInterface = new MonumentImpl();
        monument = monumentInterface.getMonument(id);

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
        monumentInterface.updateMonument(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument mise à jour"));
    }

    public void ajoutm(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
        monumentInterface.addMonument(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument ajouté"));
        monument = new Monument();
        System.err.println("eeeee");
    }

    public void delet(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
        monumentInterface.deletMonument(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument supprimé"));
        System.err.println("eeeee");

    }
//methode pour l affichage de dialog de detail ("flech à gauche")

    public void onRowToggle(ToggleEvent event) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
//                                            "Ligne  " + event.getVisibility(),  
//                                            "Nom :" + ((Monument) event.getData()).getNomM());  
//          
//        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }

    //Map
    public void onPointSelectLatitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        Double lat = latlng.getLat();
//        DecimalFormat df = new DecimalFormat("##0.0000000");
//        String a = (String)df.format(lat);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Point séléctionné", "Latitude:" + lat + ", Longitude:" + latlng.getLng()));
//addMessage(new FacesMessage("Point séléctionné","Latitude:" + latlng.getLat() + ", Longitude:" + latlng.getLng()));
    }

    public void onPointSelectLatitudeLongitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        Double lat = latlng.getLat();
        Double lng = latlng.getLng();
        DecimalFormat df = new DecimalFormat("##0.000000");


        System.out.println("ceci est le test de formatage");
        monument.setLatitude(Double.parseDouble(df.format(lat)));
        monument.setLongitude(Double.parseDouble(df.format(lng)));

    }

    public void onStateChange(StateChangeEvent event) {
        LatLngBounds bounds = event.getBounds();
        int zoomLevel = event.getZoomLevel();

    }

//    public void addMessage(FacesMessage message) {
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//   
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
        File file = new File(path + "resources\\images\\monument" + name);
        url = "http:\\faces\\resources\\images\\monument" + name;
        urlresize = path + "resources\\images\\monument" + name;

        
        monument.setImage(url);
        
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
        name = name.replace(supp1,"");
        ImageIO.write(resizeImagePng, "png", new File(path + "resources\\images\\monument"+name+".png"));
       
        urlMobile = "http://192.168.1.100:8080/resources/images/monument" + name+".png";
        monument.setImagemobile(urlMobile);

        // save the url of the uploaded image in the database
//    imageInterface = new ImageImpl();
//    image = new Image();
//    image.setData(url);
//    image.setDescription("thanx");
//    image.setNom("monum"+name);
//    imageInterface.save(image);
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
    public MonumentManagedBean() {
        this.listMonument = new ArrayList<Monument>();
        System.err.println("eeeeeee");
        if (this.monument == null) {
            this.monument = new Monument();
        }

    }

}
