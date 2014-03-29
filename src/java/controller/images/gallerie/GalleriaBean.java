/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.images.gallerie;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author hp
 */

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean
@ViewScoped
public class GalleriaBean implements Serializable{

    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();

        for(int i=1;i<=7;i++) {
            images.add("galleria" + i + ".jpg");
        }

      

    

   
    }

   
}