/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.centreCommercial;

import dao.centreCommercial.CentreCommercialImp;
import dao.centreCommercial.CentreInt;
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
import model.CentreCommercial;
import model.Ville;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;

@ManagedBean(name = "centrecommercialeManagedBean")
@SessionScoped
public class CentrecommercialeManagedBean implements Serializable {

    CentreInt centreInt;
    private CentreCommercial centreCommercial;
    private List<CentreCommercial> listCentreCommerciale;
    private CentreCommercial selectCentre;
    private Ville ville;
    private String name;
    private String url;
    private String urlMobile;
    private String urlsize;

    public String getUrlsize() {
        return urlsize;
    }

    public void setUrlsize(String urlsize) {
        this.urlsize = urlsize;
    }
    
    
    

    int boutique = 0;
    int cafe = 0;

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

    public CentreCommercial getSelectCentre() {
        return selectCentre;
    }

    public void setSelectCentre(CentreCommercial selectCentre) {
        this.selectCentre = selectCentre;
    }

    public CentreCommercial getCentreCommercial() {
        return centreCommercial;
    }

    public void setCentreCommercial(CentreCommercial centreCommercial) {
        this.centreCommercial = centreCommercial;
    }

    public List<CentreCommercial> getListCentreCommerciale() {
        centreInt = new CentreCommercialImp();
        listCentreCommerciale = centreInt.getListCentreCommercial();
        return listCentreCommerciale;
    }

    public List<CentreCommercial> getListCentreCommercialeInvalide() {
        centreInt = new CentreCommercialImp();
        listCentreCommerciale = centreInt.getListCentreCommercialInvalide();
        return listCentreCommerciale;
    }

    public List<CentreCommercial> getListCentreCommercialeArchive() {
        centreInt = new CentreCommercialImp();
        listCentreCommerciale = centreInt.getListCentreCommercialArchive();
        return listCentreCommerciale;
    }

   

   
    public void setListCentreCommerciale(List<CentreCommercial> listCentreCommerciale) {
        this.listCentreCommerciale = listCentreCommerciale;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        centreCommercial = new CentreCommercial();

    }

    public void editEvent(int idCC) {
        System.out.print(idCC);
        centreInt = new CentreCommercialImp();
        centreCommercial = centreInt.getCentreCommercial(idCC);

    }

    public void suppEvent(int idCC) {
        System.out.print(idCC);
        centreInt = new CentreCommercialImp();
        centreCommercial = centreInt.getCentreCommercial(idCC);

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        centreInt = new CentreCommercialImp();
        centreInt.updateCentreCommercial(centreCommercial);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        centreInt = new CentreCommercialImp();
        centreInt.addCentreCommercial(centreCommercial);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale ajouté"));
        centreCommercial = new CentreCommercial();
    }

    public void delet(ActionEvent actionEvent) {
        centreInt = new CentreCommercialImp();
        centreInt.deletCentreCommercial(centreCommercial);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale supprimé"));

    }

//methode pour l affichage de dialog de detail ("flech à gauche")
    public void onRowToggle(ToggleEvent event) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//                "Ligne  " + event.getVisibility(),
//                "Nom :" + ((CentreCommercial) event.getData()).getNom());
//
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    
 

    //Map
    public void onPointSelectLatitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Point Sélectionné", "Latitude:" + latlng.getLat() + ", Longitude:" + latlng.getLng()));

    }

    public void onPointSelectLatitudeLongitude(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
          Double lat = latlng.getLat();
        Double lng = latlng.getLng();
        DecimalFormat df = new DecimalFormat("##0.000000");
        centreCommercial.setLatitude(Double.parseDouble(df.format(lat)));
        centreCommercial.setLongitude(Double.parseDouble(df.format(lng)));

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
        File file = new File(path + "resources\\images\\centrecommercial" + name);
        url = "http:\\faces\\resources\\images\\centrecommercial" + name;
        urlsize = path + "resources\\images\\centrecommercial" + name;
        centreCommercial.setImage(url);
        
        InputStream is = event.getFile().getInputstream();
        OutputStream out = new FileOutputStream(file);
        byte buf[] = new byte[1024];
        int len;
        while ((len = is.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        is.close();
        out.close();

        // save the url of the uploaded image in the database
//    imageInterface = new ImageImpl();
//    image = new Image();
//    image.setData(url);
//    image.setDescription("thanx");
//    image.setNom("monum"+name);
//    imageInterface.save(image);
        
         BufferedImage originalImage = ImageIO.read(new File(urlsize));
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        BufferedImage resizeImagePng = resizeImage(originalImage, type);
          String supp1 = ".jpg";
        name = name.replace(supp1,"");
        ImageIO.write(resizeImagePng, "png", new File(path + "resources\\images\\centrecommercial"+name+".png"));
        urlMobile = "http://172.16.0.11:8084/resources/images/centrecommercial" + name+".png";
        centreCommercial.setImagemobile(urlMobile);
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
    public CentrecommercialeManagedBean() {
        this.listCentreCommerciale = new ArrayList<CentreCommercial>();

        if (this.centreCommercial == null) {
            this.centreCommercial = new CentreCommercial();
        }

    }

}
