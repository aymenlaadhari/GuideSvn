/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.centreMedicale;

import dao.centreMedical.CentreMedicalImpl;
import dao.centreMedical.CentreMedicaleInterface;
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

import model.CentreMedicale;
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
@ManagedBean(name = "centreMedicaleManagedBean")
@SessionScoped
public class CentreMedicaleManagedBean implements Serializable {

    CentreMedicaleInterface medicaleInterface;
    private CentreMedicale centreMedicale;
    private List<CentreMedicale> listCentreMedicale;
    private CentreMedicale selectCentreMedicale;
    private Ville ville;
    private String url;
    private String name;
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

    //get+set
    public CentreMedicale getCentreMedicale() {
        return centreMedicale;
    }

    public void setCentreMedicale(CentreMedicale centreMedicale) {
        this.centreMedicale = centreMedicale;
    }

    public List<CentreMedicale> getListCentreMedicale() {
        medicaleInterface = new CentreMedicalImpl();
        listCentreMedicale = medicaleInterface.getListCentreMedicale();
        System.err.println("e " + listCentreMedicale);
        return listCentreMedicale;
    }

    public List<CentreMedicale> getListCentreMedicaleInvalide() {
        medicaleInterface = new CentreMedicalImpl();
        listCentreMedicale = medicaleInterface.getListCentreMedicaleInvalide();
        return listCentreMedicale;
    }

    public List<CentreMedicale> getListCentreMedicaleArchive() {
        medicaleInterface = new CentreMedicalImpl();
        listCentreMedicale = medicaleInterface.getListCentreMedicaleArchive();
        return listCentreMedicale;
    }

    public void setListCentreMedicale(List<CentreMedicale> listCentreMedicale) {
        this.listCentreMedicale = listCentreMedicale;
    }

    public CentreMedicale getSelectCentreMedicale() {
        return selectCentreMedicale;
    }

    public void setSelectCentreMedicale(CentreMedicale selectCentreMedicale) {
        this.selectCentreMedicale = selectCentreMedicale;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        centreMedicale = new CentreMedicale();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Medical supprimé"));
    }

    public void editEvent(int id) {
        System.out.print(id);
        medicaleInterface = new CentreMedicalImpl();
        centreMedicale = medicaleInterface.getCentreMedicale(id);

    }

    public void suppEvent(int id) {
        System.out.print(id);
        medicaleInterface = new CentreMedicalImpl();
        centreMedicale = medicaleInterface.getCentreMedicale(id);
    }

    public void edition(ActionEvent actionEvent) {
        medicaleInterface = new CentreMedicalImpl();
        medicaleInterface.updateCentreMedicale(centreMedicale);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Medical mise à jour"));
    }

    public void ajoutcm(ActionEvent actionEvent) {
        medicaleInterface = new CentreMedicalImpl();
        medicaleInterface.addCentreMedicale(centreMedicale);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Medical ajouté"));
        centreMedicale = new CentreMedicale();
    }

    public void delet(ActionEvent actionEvent) {
        medicaleInterface = new CentreMedicalImpl();
        medicaleInterface.deletCentreMedicale(centreMedicale);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Medical supprimé"));

    }

    //methode pour l affichage de dialog de detail ("flech à gauche")
    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Centre médical :" + ((CentreMedicale) event.getData()).getNom(), "Ligne  " + event.getVisibility());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //Map
    public void onPointSelectLatitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Point Selectionné", "Latitude:" + latlng.getLat() + ", Longitude:" + latlng.getLng()));

    }

    public void onPointSelectLatitudeLongitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        Double lat = latlng.getLat();
        Double lng = latlng.getLng();
        DecimalFormat df = new DecimalFormat("##0.000000");
        centreMedicale.setLatitude(Double.parseDouble(df.format(lat)));
        centreMedicale.setLongitude(Double.parseDouble(df.format(lng)));

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
        File file = new File(path + "resources\\images\\centremedical" + name);
        url = "http:\\faces\\resources\\images\\centremedical" + name;
        urlresize = path + "resources\\images\\centremedical" + name;

        centreMedicale.setImage(url);

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
        ImageIO.write(resizeImagePng, "png", new File(path + "resources\\images\\centremedical" + name + ".png"));
        urlMobile = "http://172.16.0.11:8084/resources/images/centremedical" + name+".png";
        centreMedicale.setImagemobile(urlMobile);

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

    public CentreMedicaleManagedBean() {
        this.listCentreMedicale = new ArrayList<CentreMedicale>();

        if (this.centreMedicale == null) {
            this.centreMedicale = new CentreMedicale();
        }

    }
}
