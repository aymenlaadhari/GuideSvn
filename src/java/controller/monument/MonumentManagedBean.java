/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.monument;


import dao.monument.MonumentImpl;
import dao.monument.MonumentInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Monument;


/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class MonumentManagedBean implements Serializable {

    private Monument monument ;
    private List<Monument> listMonument;
    MonumentInterface monumentInterface;

    //getteur et setteur -->Monument
    public Monument getMonument() {
        return monument;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
    }
   

   //getteur -->listMonument
    
    public List getListMonument() {
       monumentInterface = new MonumentImpl();
       this.listMonument = monumentInterface.list(); 
        return listMonument;
    }
    

///les methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        monument = new Monument();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument supprimé"));
    }

    public void editEvent(long id) {
        System.out.print(id);
        monumentInterface = new MonumentImpl();
        monument = monumentInterface.getMonument(id);

    }

    public void edition(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
        monumentInterface.update(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Monument mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
        monumentInterface.save(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument Evenement ajouté"));
        monument = new Monument();
    }

    public void delet(Monument monument) {
        monumentInterface = new MonumentImpl();
        monumentInterface.remove(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Monument supprimé"));

    }
    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public MonumentManagedBean() {
        
        this.listMonument = new ArrayList<>();

        if (this.monument== null) {
            this.monument = new Monument();
        }

    }
    

}
