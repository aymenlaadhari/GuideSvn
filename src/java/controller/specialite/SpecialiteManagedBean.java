/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.specialite;


import dao.specialite.SpecialiteImpl;
import dao.specialite.SpecialiteInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Restaurant;


import model.Specialite;
import org.hibernate.Session;
import org.primefaces.event.ToggleEvent;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
@ManagedBean(name = "SpecialiteManagedBean")
@SessionScoped
public class SpecialiteManagedBean implements Serializable{

    SpecialiteInterface specialiteInterface ;
    private Specialite specialite  ;
    private List<Specialite> listSpecialite;
     private Specialite selectSpecialite  ;

    //get+set
    
 public Specialite getSelectSpecialite() {
        return selectSpecialite;
    }

    public void setSelectSpecialite(Specialite selectSpecialite) {
        this.selectSpecialite = selectSpecialite;
    }
    
 public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public List<Specialite> getListSpecialite() {
        specialiteInterface = new SpecialiteImpl();
        listSpecialite = specialiteInterface.getListSpecialite();
       
        return listSpecialite;
    }

    public void setListSpecialite(List<Specialite> listSpecialite) {
        this.listSpecialite = listSpecialite;
    }
    
    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        specialite= new Specialite();

    }

    public void editEvent(int idspec) {
        System.out.print(idspec);
        specialiteInterface = new SpecialiteImpl();
        specialite = specialiteInterface.getSpecialite(idspec);

    }
public void suppEvent(int idspec) {
         System.out.print(idspec);
        specialiteInterface = new SpecialiteImpl();
        specialite = specialiteInterface.getSpecialite(idspec);

    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Specialite supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        specialiteInterface = new SpecialiteImpl();
        specialiteInterface.update(specialite);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Specialite mise à jour"));
    }

    public void ajouts(ActionEvent actionEvent) {
       specialiteInterface = new SpecialiteImpl();
        specialiteInterface.save(specialite);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Specialite ajouté"));
        specialite= new Specialite();
    }

    public void delet(ActionEvent actionEvent) {
        specialiteInterface = new SpecialiteImpl();
        specialiteInterface.remove(specialite);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Specialite supprimé"));

    }
    //methode pour l affichage de dialog de detail ("flech à gauche")
  public void onRowToggle(ToggleEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
                                            "Ligne " + event.getVisibility(),  
                                            "Nom :" + ((Specialite) event.getData()).getNom());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
   
    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public SpecialiteManagedBean() {
        this.listSpecialite = new ArrayList<Specialite>();

        if (this.specialite == null) {
            this.specialite = new Specialite();
        }

    }

}