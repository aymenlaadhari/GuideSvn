/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.evenement;

import dao.evenement.EvenementImpl;
import dao.evenement.EvenementInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Evenement;

@ManagedBean(name = "EvenementManagedBean")
@SessionScoped
public class EvenementManagedBean implements Serializable{

    EvenementInterface evenementInterface ;
    private Evenement evenement ;
    private List<Evenement> listEvenement;

    //get+set
    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public List<Evenement> getListEvenement() {
     evenementInterface = new EvenementImpl();
        listEvenement = evenementInterface.getListEvenement();
                return listEvenement;
    }

    public void setListEvenement(List<Evenement> listEvenement) {
        this.listEvenement = listEvenement;
    }
    

    
    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        evenement = new Evenement();

    }

    public void editEvent(int idEvent) {
        System.out.print(idEvent);
        evenementInterface = new EvenementImpl();
        evenement = evenementInterface.getEvenement(idEvent);

    }
public void suppEvent(int idEvent) {
        System.out.print(idEvent);
        evenementInterface = new EvenementImpl();
        evenement = evenementInterface.getEvenement(idEvent);

    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        evenementInterface = new EvenementImpl();
        evenementInterface.update(evenement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement mise à jour"));
    }

    public void ajoutevenement(ActionEvent actionEvent) {
        evenementInterface= new EvenementImpl();
        evenementInterface.save(evenement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement ajouté"));
        evenement = new Evenement();
    }

    public void delet(ActionEvent actionEvent) {
        evenementInterface = new EvenementImpl();
        evenementInterface.remove(evenement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement supprimé"));

    }
 


    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public EvenementManagedBean() {
        this.listEvenement= new ArrayList<>();

        if (this.evenement== null) {
            this.evenement = new Evenement();
        }

    }


}
