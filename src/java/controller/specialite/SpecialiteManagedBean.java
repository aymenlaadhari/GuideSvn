/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.specialite;


import dao.specialite.SpecialiteImpl;
import dao.specialite.SpecialiteInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import model.Specialite;

/**
 *
 * @author hp
 */
@ManagedBean(name = "SpecialiteManagedBean")
@SessionScoped
public class SpecialiteManagedBean implements Serializable{

    SpecialiteInterface specialiteInterface ;
    private Specialite specialite  ;
    private List<Specialite> listSpecialite;

    //get+set
    
 public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public List<Specialite> getListSpecialite() {
        specialiteInterface = new SpecialiteImpl();
        listSpecialite = specialiteInterface.getListSpecialite();
       
        return listSpecialite;
    }

    public void setListSpecialite(List<Specialite> listSpecialite) {
        this.listSpecialite = listSpecialite;
    }
    
    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        specialite= new Specialite();

    }

    public void editEvent(int id) {
        System.out.print(id);
        specialiteInterface = new SpecialiteImpl();
        specialite = specialiteInterface.getSpecialite(id);

    }
public void suppEvent(int id) {
         System.out.print(id);
        specialiteInterface = new SpecialiteImpl();
        specialite = specialiteInterface.getSpecialite(id);

    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Specialite supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        specialiteInterface = new SpecialiteImpl();
        specialiteInterface.update(specialite);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Specialite mise à jour"));
    }

    public void ajouts(ActionEvent actionEvent) {
       specialiteInterface = new SpecialiteImpl();
        specialiteInterface.save(specialite);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Specialite ajouté"));
        specialite= new Specialite();
    }

    public void delet(ActionEvent actionEvent) {
        specialiteInterface = new SpecialiteImpl();
        specialiteInterface.remove(specialite);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Specialite supprimé"));

    }


    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public SpecialiteManagedBean() {
        this.listSpecialite = new ArrayList<>();

        if (this.specialite == null) {
            this.specialite = new Specialite();
        }

    }

}