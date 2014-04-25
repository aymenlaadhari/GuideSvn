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
import org.primefaces.event.ToggleEvent;


@ManagedBean(name = "centrecommercialeManagedBean")
@SessionScoped
public class CentrecommercialeManagedBean implements Serializable{

    CentreInt centreInt;
    private CentreCommercial centreCommercial;
    private List<CentreCommercial> listCentreCommerciale;
    private CentreCommercial selectCentre;

    public CentreCommercial getSelectCentre() {
        return selectCentre;
    }

    public void setSelectCentre(CentreCommercial selectCentre) {
        this.selectCentre = selectCentre;
    }

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
    
  
//methode pour l affichage de dialog de detail ("flech à gauche")
  public void onRowToggle(ToggleEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
                                            "Ligne  " + event.getVisibility(),  
                                            "Nom :" + ((CentreCommercial) event.getData()).getNom());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
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
