/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ville;



import dao.ville.VilleImpl;
import dao.ville.VilleInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;



import model.Ville;
import org.primefaces.event.ToggleEvent;

@ManagedBean(name = "VilleManagedBean")
@SessionScoped
public class VilleManagedBean implements Serializable{

    VilleInterface villeInterface;
    private Ville ville;
    private Ville selectVille;
            
    private List<Ville> listVille;

    //get+set
    
    public Ville getSelectVille() {
        return selectVille;
    }

    public void setSelectVille(Ville selectVille) {
        this.selectVille = selectVille;
    }
    
    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Ville> getListVille() {
        villeInterface = new VilleImpl();
        listVille = villeInterface.getListVille();
        return listVille;
    }

    public void setListVille(List<Ville> listVille) {
        this.listVille = listVille;
    }

    

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        ville = new Ville();

    }

    public void editEvent(int id) {
        System.out.print(id);
        villeInterface = new VilleImpl();
        ville = villeInterface.getVille(id);

    }
public void suppEvent(int id) {
        System.out.print(id);
        villeInterface = new VilleImpl();
        ville = villeInterface.getVille(id);

    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ville supprimée"));
    }

    public void edition(ActionEvent actionEvent) {
        villeInterface = new VilleImpl();
        villeInterface.update(ville);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ville mise à jour"));
    }

    public void ajoutville(ActionEvent actionEvent) {
        villeInterface = new VilleImpl();
        villeInterface.save(ville);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ville ajouté"));
        ville = new Ville();
    }

    public void delet(ActionEvent actionEvent) {
        villeInterface = new VilleImpl();
        villeInterface.remove(ville);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ville supprimée"));

    }
    //methode pour l affichage de dialog de detail ("flech à gauche")
  public void onRowToggle(ToggleEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
                                            "Ligne  " + event.getVisibility(),  
                                            "Nom :" + ((Ville) event.getData()).getNom());  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
 


    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public VilleManagedBean() {
        this.listVille = new ArrayList<>();

        if (this.ville== null) {
            this.ville = new Ville();
        }

    }

}

