/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.utilisateur;

import dao.utilisateur.UtilisateurImpl;
import dao.utilisateur.UtilisateurInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Utilisateur;

@ManagedBean(name = "UtilisateurManagedBean")
@SessionScoped
public class UtilisateurManagedBean implements Serializable{

    UtilisateurInterface utilisateurInterface;
    private Utilisateur utilisateur;
    private List<Utilisateur> listUtilisateur;

    

    //get+set
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
   
 public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
        this.listUtilisateur = listUtilisateur;
    }
   
 public List<Utilisateur> getListUtilisateur() {
        utilisateurInterface = new UtilisateurImpl();
        listUtilisateur = utilisateurInterface.getListUtilisateur();
        return listUtilisateur;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        utilisateur = new Utilisateur();

    }

    public void editEvent(int id) {
        System.out.print(id);
        utilisateurInterface = new UtilisateurImpl();
        utilisateur= utilisateurInterface.getUtilisateur(id);

    }
public void suppEvent(int id) {
        System.out.print(id);
        utilisateurInterface = new UtilisateurImpl();
        utilisateur= utilisateurInterface.getUtilisateur(id);

    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Utilisateur supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        utilisateurInterface = new UtilisateurImpl();
        utilisateurInterface.update(utilisateur);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Utilisateur mise à jour"));
    }

    public void ajoutu(ActionEvent actionEvent) {
        utilisateurInterface = new UtilisateurImpl();
        utilisateurInterface.save(utilisateur);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Utilisateur  ajouté"));
        utilisateur = new Utilisateur();
    }

    public void delet(ActionEvent actionEvent) {
       utilisateurInterface = new UtilisateurImpl();
        utilisateurInterface.remove(utilisateur);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Utilisateur  supprimé"));

    }
 


    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public UtilisateurManagedBean() {
        this.listUtilisateur = new ArrayList<>();

        if (this.utilisateur== null) {
            this.utilisateur = new Utilisateur();
        }

    }

}
