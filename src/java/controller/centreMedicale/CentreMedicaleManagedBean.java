/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.centreMedicale;

import dao.centreMedical.CentreMedicalImpl;
import dao.centreMedical.CentreMedicaleInterface;
import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import model.CentreMedicale;

/**
 *
 * @author hp
 */
@ManagedBean(name = "centreMedicaleManagedBean")
@SessionScoped
public class CentreMedicaleManagedBean  implements Serializable{

    CentreMedicaleInterface medicaleInterface ;
    private CentreMedicale centreMedicale ;
    private List<CentreMedicale> listCentreMedicale;

    //get+set
   
 public CentreMedicale getCentreMedicale() {
        return centreMedicale;
    }

    public void setCentreMedicale(CentreMedicale centreMedicale) {
        this.centreMedicale = centreMedicale;
    }

    public List<CentreMedicale> getListCentreMedicale() {
       medicaleInterface= new CentreMedicalImpl();
        listCentreMedicale = medicaleInterface.getListCentreMedicale();
        return listCentreMedicale;
    }

    public void setListCentreMedicale(List<CentreMedicale> listCentreMedicale) {
        this.listCentreMedicale = listCentreMedicale;
    }
   
    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        centreMedicale = new CentreMedicale();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Medicale supprimé"));
    }

    public void editEvent(int id) {
        System.out.print(id);
        medicaleInterface = new CentreMedicalImpl();
        centreMedicale = medicaleInterface.getCentreMedicale(id);

    }
    public void suppEvent(int id) {
        System.out.print(id);
        medicaleInterface = new CentreMedicalImpl();
        centreMedicale = medicaleInterface.getCentreMedicale(id);
    }
    

    public void edition(ActionEvent actionEvent) {
       medicaleInterface = new CentreMedicalImpl();
        medicaleInterface.updateCentreMedicale(centreMedicale);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Medicale mise à jour"));
    }

    public void ajoutcm(ActionEvent actionEvent) {
        medicaleInterface = new CentreMedicalImpl();
        medicaleInterface.addCentreMedicale(centreMedicale);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Medicale ajouté"));
        centreMedicale = new CentreMedicale();
    }

    public void delet(ActionEvent actionEvent) {
        medicaleInterface = new CentreMedicalImpl();
        medicaleInterface.deletCentreMedicale(centreMedicale);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Medicale supprimé"));

    }
 /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public CentreMedicaleManagedBean() {
        this.listCentreMedicale = new ArrayList<>();

        if (this.centreMedicale== null) {
            this.centreMedicale = new CentreMedicale();
        }

    }
}

