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
@ManagedBean
@SessionScoped
public class CentreMedicaleManagedBean implements Serializable{

    private CentreMedicale centreMedicale;
    private List<CentreMedicale> centreMedicales;
    CentreMedicaleInterface centreMedicaleInterface;

    public CentreMedicale getCentreMedicale() {
        return centreMedicale;
    }

    public void setCentreMedicale(CentreMedicale centreMedicale) {
        this.centreMedicale = centreMedicale;
    }

    public List<CentreMedicale> getCentreMedicales() {
         centreMedicaleInterface = new CentreMedicalImpl();
        this.centreMedicales = centreMedicaleInterface.list();
        return centreMedicales;
    }

    public void setCentreMedicales(List<CentreMedicale> centreMedicales) {
        this.centreMedicales = centreMedicales;
    }

   


public void ajoutEvent(ActionEvent actionEvent) {
        centreMedicale = new CentreMedicale();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale supprimé"));
    }

    public void editEvent(int id) {
        System.out.print(id);
        centreMedicaleInterface = new CentreMedicalImpl();
        centreMedicale = centreMedicaleInterface.getCentreMedicale(id);

    }

    public void edition(ActionEvent actionEvent) {
        centreMedicaleInterface = new CentreMedicalImpl();
        centreMedicaleInterface.update(centreMedicale);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Medicale mis à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        centreMedicaleInterface = new CentreMedicalImpl();
        centreMedicaleInterface.save(centreMedicale);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale ajouté"));
        centreMedicale = new CentreMedicale();
    }

    public void delet(CentreMedicale centreMedicale) {
        centreMedicaleInterface = new CentreMedicalImpl();
        centreMedicaleInterface.remove(centreMedicale);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre CentreMedicale supprimé"));

    }
    
    public void refresh()
    {
        this.centreMedicales = centreMedicaleInterface.list();
    }
    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public CentreMedicaleManagedBean() {
        
        this.centreMedicales = new ArrayList<>();

        if (this.centreMedicale == null) {
            this.centreMedicale = new CentreMedicale();
        }

    }

}
