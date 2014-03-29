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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Image;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
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

    public String preparerAjout() {
        image = new Image();
        return "gestionImage";
    }

    public String preparerModifier() {
        image = (Image) (listImage.getRowData());
        return "gestionImage";
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
