/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ville;



import dao.pays.PaysImpl;
import dao.pays.PaysInterface;
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
import javax.faces.model.SelectItem;
import model.Pay;



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

    public void editEvent(int idVille) {
        System.out.print(idVille);
        villeInterface = new VilleImpl();
        ville = villeInterface.getVille(idVille);

    }
public void suppEvent(int idVille) {
        System.out.print(idVille);
        villeInterface = new VilleImpl();
        ville = villeInterface.getVille(idVille);

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
 
///
  public List<SelectItem> getAllPays()
          {
              List<SelectItem> items = new ArrayList<SelectItem>();
              PaysInterface paysInter = new PaysImpl();
              List<Pay> paysList = paysInter.getListPays();
              for(Pay pay : paysList)
              {
                  items.add(new SelectItem (pay.getNom()));
              }
              
              return  items;
          }
  ///list pays dans ville
  public List<Pay> getAllPaysVille()
          {
              PaysInterface paysInter = new PaysImpl();
              List<Pay> paysList = paysInter.getListPays();
              
              
              return  paysList;
          }
    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public VilleManagedBean() {
        this.listVille = new ArrayList<Ville>();

        if (this.ville== null) {
            this.ville = new Ville();
        }

    }

}

