/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.images;

import dao.images.ImageInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Image;

import org.primefaces.event.FileUploadEvent;

@ManagedBean(name="uploadImageMonument")
@RequestScoped
public class uploadImageMonument {

   //Primitives
    private static final int BUFFER_SIZE = 6124;
    private String url;
    private String name;
    ImageInterface imageInterface;
    private Image image;
  
    
    public uploadImageMonument() {
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    File file = new File(path + "resources\\images\\Monument\\monum" + name);
   
    url = path + "resources\\images\\Monument\\monum" + name;
    
    InputStream is = event.getFile().getInputstream();
    OutputStream out = new FileOutputStream(file);
    byte buf[] = new byte[1024];
    int len;
    while ((len = is.read(buf)) > 0)
        out.write(buf, 0, len);
    is.close();
    out.close();
    
    // save the url of the uploaded image in the database
//    imageInterface = new ImageImpl();
//    image = new Image();
//    image.setData(url);
//    image.setDescription("thanx");
//    image.setNom("monum"+name);
//    imageInterface.save(image);
     FacesMessage msg
                    = new FacesMessage("The file was uploaded and saved succefully.");
     
                FacesContext.getCurrentInstance().addMessage(null, msg);

}
}