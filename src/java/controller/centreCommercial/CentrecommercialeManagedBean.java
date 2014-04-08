/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.centreCommercial;

import dao.centreCommercial.CentreCommercialImp;
import dao.centreCommercial.CentreInt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.CentreCommercial;

@ManagedBean(name = "centrecommercialeManagedBean")
@SessionScoped
public class CentrecommercialeManagedBean implements Serializable{

    CentreInt centreInt;
    private CentreCommercial centreCommercial;
    private List<CentreCommercial> listCentreCommerciale;

    //get+set
    public CentreCommercial getCentreCommercial() {
        return centreCommercial;
    }

    public void setCentreCommercial(CentreCommercial centreCommercial) {
        this.centreCommercial = centreCommercial;
    }
 public List<CentreCommercial> getListCentreCommerciale() {
        centreInt = new CentreCommercialImp();
        listCentreCommerciale = centreInt.getListCentreCommercial();
        return listCentreCommerciale;
    }

    public void setListCentreCommerciale(List<CentreCommercial> listCentreCommerciale) {
        this.listCentreCommerciale = listCentreCommerciale;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        centreCommercial = new CentreCommercial();

    }

    public void editEvent(int id) {
        System.out.print(id);
        centreInt = new CentreCommercialImp();
        centreCommercial = centreInt.getCentreCommercial(id);

    }
public void suppEvent(int id) {
        System.out.print(id);
        centreInt = new CentreCommercialImp();
        centreCommercial = centreInt.getCentreCommercial(id);

    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        centreInt = new CentreCommercialImp();
        centreInt.updateCentreCommercial(centreCommercial);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        centreInt = new CentreCommercialImp();
        centreInt.addCentreCommercial(centreCommercial);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale ajouté"));
        centreCommercial = new CentreCommercial();
    }

    public void delet(ActionEvent actionEvent) {
        centreInt = new CentreCommercialImp();
        centreInt.deletCentreCommercial(centreCommercial);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Commerciale supprimé"));

    }
 


    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public CentrecommercialeManagedBean() {
        this.listCentreCommerciale = new ArrayList<>();

        if (this.centreCommercial == null) {
            this.centreCommercial = new CentreCommercial();
        }

    }

}
