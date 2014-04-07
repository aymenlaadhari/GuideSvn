/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.images;

import dao.images.ImageImpl;
import dao.images.ImageInterface;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Image;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author hp
 */
@ManagedBean(name = "uploadImage")
@SessionScoped
public class UploadImage implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private Image image;
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
 
    public void upload() {
        System.out.println("sssss");
        if (file != null) {
            System.out.println("heheheheh");
            try {
               System.out.println(file.getFileName());
                InputStream fin2 = file.getInputstream();
                //Connection con = Database.getConnection();
                System.out.println("okokokok");
                ImageInterface cmi = new ImageImpl();
               // PreparedStatement pre = con.prepareStatement("INSERT INTO image (nom, data) values(?,?);");
                image.setData(IOUtils.toByteArray(fin2));
                cmi.save(image);
               // pre.setString(1, file.getFileName().toString());
                //pre.setBinaryStream(2, fin2, file.getSize());
               // pre.executeUpdate();
                System.out.println("Inserting Successfully!");
               // pre.close();
                FacesMessage msg = new FacesMessage( file.getFileName(),"is succesful is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
 
            } catch (Exception e) {
                System.out.println("Exception-File Upload." + e.getMessage());
            }
        }
        else{
        FacesMessage msg = new FacesMessage("Please select image!!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
