/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.garde;

import dao.garde.GardeImpl;
import dao.garde.GardeInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Garde;
import org.primefaces.event.ToggleEvent;

@ManagedBean(name = "GardeManagedBean")
@SessionScoped
public class GardeManagedBean implements Serializable {

    GardeInterface gardeInterface;
    private Garde garde;
    private List<Garde> listGarde;
    private Garde selectGarde;

    //get+set
    
    public Garde getSelectGarde() {
        return selectGarde;
    }

    public void setSelectGarde(Garde selectGarde) {
        this.selectGarde = selectGarde;
    }
    
    public Garde getGarde() {
        return garde;
    }

    public void setGarde(Garde garde) {
        this.garde = garde;
    }

    public void setListGarde(List<Garde> listGarde) {
        this.listGarde = listGarde;
    }

    public List<Garde> getListGarde() {
        gardeInterface = new GardeImpl();
        listGarde = gardeInterface.getListGarde();
        return listGarde;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        garde = new Garde();

    }

    public void editEvent(int id) {
        System.out.print(id);
        gardeInterface = new GardeImpl();
        garde = gardeInterface.getGarde(id);

    }

    public void suppEvent(int id) {
        System.out.print(id);
        gardeInterface = new GardeImpl();
        garde = gardeInterface.getGarde(id);

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Garde supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        gardeInterface = new GardeImpl();
        gardeInterface.update(garde);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Garde mise à jour"));
    }

    public void ajoutgarde(ActionEvent actionEvent) {
        gardeInterface = new GardeImpl();
        gardeInterface.save(garde);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Garde ajouté"));
        garde = new Garde();
    }

    public void delet(ActionEvent actionEvent) {
        gardeInterface = new GardeImpl();
        gardeInterface.remove(garde);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Garde supprimé"));

    }
    //methode pour l affichage de dialog de detail ("flech à gauche")
  public void onRowToggle(ToggleEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
                                            "Ligne  " + event.getVisibility(),  
                                            "Nom :" + ((Garde) event.getData()).getId());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public GardeManagedBean() {
        this.listGarde = new ArrayList<>();

        if (this.garde == null) {
            this.garde= new Garde();
        }

    }

}
