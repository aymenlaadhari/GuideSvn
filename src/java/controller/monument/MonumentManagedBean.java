/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.monument;


import dao.monument.MonumentImpl;
import dao.monument.MonumentInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Monument;
import org.primefaces.event.ToggleEvent;



@ManagedBean(name = "MonumentManagedBean")
@SessionScoped
public class MonumentManagedBean implements Serializable{

   MonumentInterface monumentInterface;
    private Monument monument;
    private List<Monument> listMonument;
     private Monument selectedMonument;

    //get+set
   
 public Monument getSelectedMonument() {
        return selectedMonument;
    }

    public void setSelectedMonument(Monument selectedMonument) {
        this.selectedMonument = selectedMonument;
    }
   
 public Monument getMonument() {
        return monument;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
    }

    public List<Monument> getListMonument() {
        monumentInterface= new MonumentImpl();
        listMonument = monumentInterface.getListMonument();
        return listMonument;
    }

    public void setListMonument(List<Monument> listMonument) {
        this.listMonument = listMonument;
    }
   

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        monument = new Monument();

    }

    public void editEvent(int id) {
        System.out.print(id);
        monumentInterface = new MonumentImpl();
        monument = monumentInterface.getMonument(id);

    }
 public void suppEvent(int id) {
        System.out.print(id);
        monumentInterface = new MonumentImpl();
        monument = monumentInterface.getMonument(id);

    }    
    

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("tMonument supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
        monumentInterface.updateMonument(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument mise à jour"));
    }

    public void ajoutm(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
        monumentInterface.addMonument(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument ajouté"));
        monument = new Monument();
    }

    public void delet(ActionEvent actionEvent) {
        monumentInterface = new MonumentImpl();
          monumentInterface.deletMonument(monument);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Monument supprimé"));

    }
//methode pour l affichage de dialog de detail ("flech à gauche")
  public void onRowToggle(ToggleEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
                                            "Ligne  " + event.getVisibility(),  
                                            "Nom :" + ((Monument) event.getData()).getNomM());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public MonumentManagedBean() {
        this.listMonument = new ArrayList<>();

        if (this.monument == null) {
            this.monument = new Monument();
        }

    }

}
