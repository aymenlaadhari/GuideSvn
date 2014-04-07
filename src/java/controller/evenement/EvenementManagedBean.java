/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.evenement;

import dao.evenement.EvenementImpl;
import dao.evenement.EvenementInterface;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Evenement;



/**
 *
 * @author hp
 */
@ManagedBean
@SessionScoped
public class EvenementManagedBean implements Serializable {

    private Evenement evenement;
    private List<Evenement> evenements;
    EvenementInterface evenementInterface;

    //getteur et setteur -->Monument
    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    //getteur -->listEvenement
    public List<Evenement> getEvenements() {
        evenementInterface = new EvenementImpl();
        this.evenements = evenementInterface.list();
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
  
    
      

///les methodes
   public void ajoutEvent(ActionEvent actionEvent) {
        evenement = new Evenement();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement supprimé"));
    }

    public void editEvent(int id) {
        System.out.print(id);
        evenementInterface = new EvenementImpl();
        evenement = evenementInterface.getEvenement(id);

    }

    public void edition(ActionEvent actionEvent) {
        evenementInterface = new EvenementImpl();
        evenementInterface.update(evenement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        evenementInterface = new EvenementImpl();
        evenementInterface.save(evenement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement ajouté"));
        evenement = new Evenement();
    }

    public void delet(Evenement evenement) {
        evenementInterface = new EvenementImpl();
        evenementInterface.remove(evenement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement supprimé"));

    }
    
    /**
     * Creates a new instance of EvenementManagedBean
     */
    public EvenementManagedBean() {
        
        this.evenements = new ArrayList<>();

        if (this.evenement== null) {
            this.evenement = new Evenement();
        }

    }
    

}
