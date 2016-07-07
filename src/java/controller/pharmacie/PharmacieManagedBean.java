/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pharmacie;

import dao.pharmacie.PharmacieImpl;
import dao.pharmacie.PharmacieInterface;
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

import model.Pharmacie;
import model.Ville;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;

@ManagedBean(name = "PharmacieManagedBean")
@SessionScoped
public class PharmacieManagedBean implements Serializable {

    PharmacieInterface pharmacieInterface;
    private Pharmacie pharmacie;
    private List<Pharmacie> listPharmacie;
    private Pharmacie selectPharmacie;
    private Ville ville;
    private String url;
    private String name;
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

    public Pharmacie getSelectPharmacie() {
        return selectPharmacie;
    }

    public void setSelectPharmacie(Pharmacie selectPharmacie) {
        this.selectPharmacie = selectPharmacie;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public List<Pharmacie> getListPharmacie() {
        pharmacieInterface = new PharmacieImpl();
        listPharmacie = pharmacieInterface.getListPharmacie();
        System.err.println("e " + listPharmacie);
        return listPharmacie;
    }

    public List<Pharmacie> getListPharmacieInvalide() {
        pharmacieInterface = new PharmacieImpl();
        listPharmacie = pharmacieInterface.getListPharmacieInvalide();
        return listPharmacie;
    }

    public List<Pharmacie> getListPharmacieArchive() {
        pharmacieInterface = new PharmacieImpl();
        listPharmacie = pharmacieInterface.getListPharmacieArchive();
        return listPharmacie;
    }

    public void setListPharmacie(List<Pharmacie> listPharmacie) {
        this.listPharmacie = listPharmacie;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        pharmacie = new Pharmacie();

    }

    public void editEvent(int id) {
        System.out.print(id);
        pharmacieInterface = new PharmacieImpl();
        pharmacie = pharmacieInterface.getPharmacie(id);

    }

    public void suppEvent(int id) {
        System.out.print(id);
        pharmacieInterface = new PharmacieImpl();
        pharmacie = pharmacieInterface.getPharmacie(id);

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        pharmacieInterface = new PharmacieImpl();
        pharmacieInterface.update(pharmacie);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie mise à jour"));
    }

    public void ajoutph(ActionEvent actionEvent) {
        pharmacieInterface = new PharmacieImpl();
        pharmacieInterface.save(pharmacie);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie ajouté"));
        pharmacie = new Pharmacie();
    }

    public void delet(ActionEvent actionEvent) {
        pharmacieInterface = new PharmacieImpl();
        pharmacieInterface.remove(pharmacie);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie supprimé"));

    }

//methode pour l affichage de dialog de detail ("flech à gauche")
    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Pharmacie :" + ((Pharmacie) event.getData()).getNom(), "Ligne " + event.getVisibility());

        FacesContext.getCurrentInstance().addMessage(null, msg);
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
        pharmacie.setLatitude(Double.parseDouble(df.format(lat)));
        pharmacie.setLongitude(Double.parseDouble(df.format(lng)));

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
        File file = new File(path + "resources\\images\\pharmacie" + name);
        url = "http:\\faces\\resources\\images\\pharmacie" + name;
      
        pharmacie.setImage(url);
       
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
        ImageIO.write(resizeImagePng, "png", new File(path + "resources\\images\\pharmacie" + name + ".png"));
          urlMobile = "http://172.16.0.11:8084/resources/images/pharmacie" + name+".png";
           pharmacie.setImagemobile(urlMobile);

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

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public PharmacieManagedBean() {
        this.listPharmacie = new ArrayList<Pharmacie>();

        if (this.pharmacie == null) {
            this.pharmacie = new Pharmacie();
        }

    }

}
