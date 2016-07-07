/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.feeds;

import dao.feeds.NewsImpl;
import dao.feeds.NewsInterface;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
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
import model.Feeds;
import model.Hotel;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author hp
 */
@ManagedBean(name = "newsManagedBean")
public class NewsManagedBean implements Serializable {

    NewsInterface newsInterface;
    private Feeds feeds;
    private List<Feeds> listFeeds;
    private Feeds selectFeed;
    private String namingtof;
    private String urltof;
    private String urlresize;
    private String urlMobile;

    public Feeds getFeeds() {
        return feeds;
    }

    public void setFeeds(Feeds feeds) {
        this.feeds = feeds;
    }

    public List<Feeds> getListFeeds() {
        return listFeeds;
    }

    public void setListFeeds(List<Feeds> listFeeds) {
        this.listFeeds = listFeeds;
    }

    public Feeds getSelectFeed() {
        return selectFeed;
    }

    public void setSelectFeed(Feeds selectFeed) {
        this.selectFeed = selectFeed;
    }

    public NewsManagedBean() {
        this.listFeeds = new ArrayList<Feeds>();
        if (this.feeds == null) {
            this.feeds = new Feeds();
        }
    }

    public List<Feeds> getListFeedses() {
        newsInterface = new NewsImpl();
        listFeeds = newsInterface.getListFeeds();
        System.err.println("e " + listFeeds);
        return listFeeds;
    }

    public void ajoutEvent(ActionEvent actionEvent) {
        feeds = new Feeds();

    }

    public void editEvent(int id) {
        System.out.print(id);
        newsInterface = new NewsImpl();
        feeds = newsInterface.getFeeds(id);

    }

    public void suppEvent(int id) {
        System.out.print(id);
        newsInterface = new NewsImpl();
        feeds = newsInterface.getFeeds(id);

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Feeds supprim�"));
    }

    public void edition(ActionEvent actionEvent) {
        newsInterface = new NewsImpl();
        newsInterface.update(feeds);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Feeds mise � jour"));
    }

    public void ajout(ActionEvent actionEvent) {
        newsInterface = new NewsImpl();
        newsInterface.save(feeds);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Feeds�tel ajout�"));
        feeds = new Feeds();
    }

    public void delet(ActionEvent actionEvent) {
        newsInterface = new NewsImpl();
        newsInterface.remove(feeds);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Feeds supprim�"));

    }

    //methode pour l affichage de dialog de detail ("flech à gauche")
    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Feeds :" + ((Feeds) event.getData()).getName(), "Ligne  " + event.getVisibility());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // function to upload image
    public void fileUploadImage(FileUploadEvent event) throws IOException {
        String path = FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("/");

        //change the local directory
        String supp = "\\build";
        path = path.replace(supp, "");
        //rename the file
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
        namingtof = fmt.format(new Date())
                + event.getFile().getFileName().substring(
                        event.getFile().getFileName().lastIndexOf('.'));

        // save the file uploaded in the resources/images/Hotel
        File file = new File(path + "resources\\images\\hotel" + namingtof);
        urltof = "http:\\faces\\resources\\images\\hotel" + namingtof;
        urlresize = path + "resources\\images\\hotel" + namingtof;

        feeds.setImage(urltof);

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
        namingtof = namingtof.replace(supp1, "");
        ImageIO.write(resizeImagePng, "png", new File(path + "resources\\images\\hotel" + namingtof + ".png"));

        urlMobile = "http://192.168.01.100:8080/resources/images/hotel" + namingtof + ".png";
        feeds.setProfilepic(urlMobile);

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

}
