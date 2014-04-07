/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.garde;



import dao.garde.GardeImpl;
import dao.garde.GardeInterface;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



import model.Garde;

/**
 *
 * @author hp
 */
@ManagedBean
@SessionScoped
public class GardeManagedBean implements Serializable {

    private Garde garde;
    private List<Garde> listGarde;
    GardeInterface gardeInterface;

    public Garde getGarde() {
        return garde;
    }

    public void setGarde(Garde garde) {
        this.garde = garde;
    }

   

    public List getListGarde() {
        gardeInterface = new GardeImpl();
        this.listGarde = gardeInterface.list();
        return listGarde;
    }

     public void ajoutEvent(ActionEvent actionEvent) {
        garde = new Garde();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Garde supprimé"));
    }

    public void editEvent(int id) {
        System.out.print(id);
        gardeInterface = new GardeImpl();
        garde = gardeInterface.getGarde(id);

    }

    public void edition(ActionEvent actionEvent) {
        gardeInterface = new GardeImpl();
        gardeInterface.update(garde);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Garde mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        gardeInterface = new GardeImpl();
        gardeInterface.save(garde);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Centre Evenement ajouté"));
        garde = new Garde();
    }

    public void delet(Garde garde) {
        gardeInterface = new GardeImpl();
        gardeInterface.remove(garde);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Garde supprimé"));

    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public GardeManagedBean() {
        
        this.listGarde = new ArrayList<>();

        if (this.garde == null) {
            this.garde = new Garde();
        }

    }

}
