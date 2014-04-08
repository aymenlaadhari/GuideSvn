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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Monument;


@ManagedBean(name = "MonumentManagedBean")
@SessionScoped
public class MonumentManagedBean implements Serializable{

   MonumentInterface monumentInterface;
    private Monument monument;
    private List<Monument> listMonument;

    //get+set
   
 public Monument getMonument() {
        return monument;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
    }

    public List<Monument> getListMonument() {
        monumentInterface= new MonumentImpl();
        listMonument = monumentInterface.getListMonument();
        return listMonument;
    }

    public void setListMonument(List<Monument> listMonument) {
        this.listMonument = listMonument;
    }
   

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        monument = new Monument();

    }

    public void editEvent(int id) {
        System.out.print(id);
        monumentInterface = new MonumentImpl();
        monument = monumentInterface.getMonument(id);

    }
 public void suppEvent(int id) {
        System.out.print(id);
        monumentInterface = new MonumentImpl();
        monument = monumentInterface.getMonument(id);

    }    
    

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("tMonument supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
        monumentInterface.updateMonument(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument mise à jour"));
    }

    public void ajoutm(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
        monumentInterface.addMonument(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument ajouté"));
        monument = new Monument();
    }

    public void delet(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
          monumentInterface.deletMonument(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument supprimé"));

    }


    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public MonumentManagedBean() {
        this.listMonument = new ArrayList<>();

        if (this.monument == null) {
            this.monument = new Monument();
        }

    }

}
