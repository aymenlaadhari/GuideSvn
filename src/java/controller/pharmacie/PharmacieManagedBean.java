/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pharmacie;

import dao.pharmacie.PharmacieImpl;
import dao.pharmacie.PharmacieInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Pay;
import model.Pharmacie;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class PharmacieManagedBean implements Serializable {

    private Pharmacie pharmacie;
    private List<Pharmacie> listPharmacie;
    PharmacieInterface pharmacieInterface;

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public List<Pharmacie> getListPharmacie() {
        pharmacieInterface = new PharmacieImpl();
        this.listPharmacie = pharmacieInterface.list();
                
        return listPharmacie;
    }

    public void setListPharmacie(List<Pharmacie> listPharmacie) {
        this.listPharmacie = listPharmacie;
    }

   

    public void ajoutEvent(ActionEvent actionEvent) {
        pharmacie = new Pharmacie();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie supprimé"));
    }

    public void editEvent(long id) {
        System.out.print(id);
        pharmacieInterface = new PharmacieImpl();
        pharmacie = pharmacieInterface.getPharmacie(id);

    }

    public void edition(ActionEvent actionEvent) {
        pharmacieInterface = new PharmacieImpl();
        pharmacieInterface.update(pharmacie);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Pharmacie mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        pharmacieInterface = new PharmacieImpl();
        pharmacieInterface.save(pharmacie);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie ajouté"));
        pharmacie = new Pharmacie();
    }

    public void delet(Pay pay) {
        pharmacieInterface = new PharmacieImpl();
        pharmacieInterface.remove(pharmacie);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Pharmacie supprimé"));

    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public PharmacieManagedBean() {
        this.listPharmacie = new  ArrayList<>();
        if (this.pharmacie == null) {
            this.pharmacie = new Pharmacie();
        }

    }

}
