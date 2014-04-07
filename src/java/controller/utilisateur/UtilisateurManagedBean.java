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
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Utilisateur;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class UtilisateurManagedBean implements Serializable{
    
    private Utilisateur utilisateur;
    private List<Utilisateur> listUtlisateur;
    UtilisateurInterface utilisateurInterface;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Utilisateur> getListUtlisateur() {
        utilisateurInterface = new UtilisateurImpl();
        this.listUtlisateur = utilisateurInterface.list();
        return listUtlisateur;
    }

    public void setListUtlisateur(List<Utilisateur> listUtlisateur) {
        this.listUtlisateur = listUtlisateur;
    }

   
     public void ajoutEvent(ActionEvent actionEvent) {
        utilisateur = new Utilisateur();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Utilisateur supprimé"));
    }

    public void editEvent(long id) {
        System.out.print(id);
        utilisateurInterface = new UtilisateurImpl();
        utilisateur = utilisateurInterface.getUtilisateur(id);

    }

    public void edition(ActionEvent actionEvent) {
        utilisateurInterface = new UtilisateurImpl();
        utilisateurInterface.update(utilisateur);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Utilisateur mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        utilisateurInterface = new UtilisateurImpl();
        utilisateurInterface.save(utilisateur);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Utilisateur ajouté "));
        utilisateur = new Utilisateur();
    }

    public void delet(Utilisateur utilisateur) {
        utilisateurInterface = new UtilisateurImpl();
        utilisateurInterface.remove(utilisateur);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Utilisateur supprimé"));

    }

    /**
     * Creates a new instance of UtilisateurManagedBean
     */
    public UtilisateurManagedBean() {
        this.listUtlisateur = new ArrayList<>();
         if (this.utilisateur == null) {
            this.utilisateur = new Utilisateur();
        }
    }
    
}
