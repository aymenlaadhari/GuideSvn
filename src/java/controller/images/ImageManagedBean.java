/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.images;

import dao.images.ImageImpl;
import dao.images.ImageInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Image;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author hp
 */
@ManagedBean(name = "imageManagedBean")
@SessionScoped
public class ImageManagedBean implements Serializable{
private Image image;
    private DataModel listImage;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

   

   

    public DataModel getListGarde() {
        List<Image> list = new ImageImpl().list();
        listImage = new ListDataModel(list);

        return listImage;
    }
public void handleFileUpload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
   

    public String supprimer() {
        Image imageTemp = (Image) (listImage.getRowData());
        ImageInterface cmi = new ImageImpl();
        cmi.remove(imageTemp);
        return "indexImage";
    }

    public String ajouter() {
        ImageInterface cmi = new ImageImpl();
        cmi.save(image);
        return "indexImage";
    }

    public String modifier() {
        ImageInterface cmi = new ImageImpl();
        cmi.update(image);
        return "indexImage";
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public ImageManagedBean() {

        if (this.image == null) {
            this.image = new Image();
        }

    }
    
}
