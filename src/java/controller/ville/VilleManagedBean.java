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

/**
 *
 * @author hp
 */
@ManagedBean
@SessionScoped
public class VilleManagedBean implements Serializable {

    private Ville ville;
    private List<Ville> listVille;
     VilleInterface villeInterface;

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Ville> getListVille() {
        villeInterface = new VilleImpl();
        this.listVille = villeInterface.list();
        return listVille;
    }

    public void setListVille(List<Ville> listVille) {
        this.listVille = listVille;
    }

   

   

    public void ajoutEvent(ActionEvent actionEvent) {
        ville = new Ville();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ville supprimé"));
    }

    public void editEvent(long id) {
        System.out.print(id);
        villeInterface = new VilleImpl();
        ville = villeInterface.getVille(id);

    }

    public void edition(ActionEvent actionEvent) {
        villeInterface = new VilleImpl();
        villeInterface.update(ville);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Ville mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        villeInterface = new VilleImpl();
        villeInterface.save(ville);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ville ajouté"));
        ville = new Ville();
    }

    public void delet(Ville ville) {
        villeInterface = new VilleImpl();
        villeInterface.remove(ville);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Ville supprimé"));

    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public VilleManagedBean() {
        this.listVille = new ArrayList<>();

        if (this.ville == null) {
            this.ville = new Ville();
        }

    }

}
