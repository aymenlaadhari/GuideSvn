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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Pharmacie;
import org.primefaces.event.ToggleEvent;

@ManagedBean(name = "PharmacieManagedBean")
@SessionScoped
public class PharmacieManagedBean implements Serializable{

    PharmacieInterface  pharmacieInterface;
    private Pharmacie pharmacie ;
    private List<Pharmacie> listPharmacie;
    private Pharmacie selectPharmacie ;

    //get+set
    
    public Pharmacie getSelectPharmacie() {
        return selectPharmacie;
    }

    public void setSelectPharmacie(Pharmacie selectPharmacie) {
        this.selectPharmacie = selectPharmacie;
    }
    
    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }
 public List<Pharmacie> getListPharmacie() {
        pharmacieInterface = new PharmacieImpl();
        listPharmacie = pharmacieInterface.getListPharmacie();
        return listPharmacie;
    }

    public void setListPharmacie(List<Pharmacie> listPharmacie) {
        this.listPharmacie = listPharmacie;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        pharmacie= new Pharmacie();

    }

    public void editEvent(int id) {
        System.out.print(id);
        pharmacieInterface = new PharmacieImpl();
        pharmacie = pharmacieInterface.getPharmacie(id);

    }
public void suppEvent(int id) {
        System.out.print(id);
        pharmacieInterface = new PharmacieImpl();
        pharmacie = pharmacieInterface.getPharmacie(id);

    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        pharmacieInterface = new PharmacieImpl();
        pharmacieInterface.update(pharmacie);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie mise à jour"));
    }

    public void ajoutph(ActionEvent actionEvent) {
        pharmacieInterface = new PharmacieImpl();
        pharmacieInterface.save(pharmacie);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie ajouté"));
        pharmacie= new Pharmacie();
    }

    public void delet(ActionEvent actionEvent) {
        pharmacieInterface = new PharmacieImpl();
        pharmacieInterface.remove(pharmacie);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pharmacie supprimé"));

    }

//methode pour l affichage de dialog de detail ("flech à gauche")
  public void onRowToggle(ToggleEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
                                            "Ligne " + event.getVisibility(),  
                                            "Nom :" + ((Pharmacie) event.getData()).getNom());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public PharmacieManagedBean() {
        this.listPharmacie = new ArrayList<>();

        if (this.pharmacie == null) {
            this.pharmacie = new Pharmacie();
        }

    }

}