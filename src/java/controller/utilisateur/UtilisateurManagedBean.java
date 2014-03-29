/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.utilisateur;

import dao.utilisateur.UtilisateurImpl;
import dao.utilisateur.UtilisateurInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Utilisateur;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class UtilisateurManagedBean implements Serializable{
    
    private Utilisateur utilisateur;
    private DataModel listUtlisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public DataModel getListUtlisateur() {
        List<Utilisateur> list = new UtilisateurImpl().list();
        listUtlisateur = new ListDataModel(list);
        return listUtlisateur;
    }
    
     public String preparerAjout() {
        utilisateur = new Utilisateur();
        return "gestionUtilisateur";
    }
    
     public String preparerModifier() {
        utilisateur = (Utilisateur) (listUtlisateur.getRowData());
        return "gestionUtilisateur";
    }
     
      public String supprimer() {
        Utilisateur utilistaeurTemp = (Utilisateur) (listUtlisateur.getRowData());
          UtilisateurInterface cmi = new UtilisateurImpl();
        cmi.remove(utilistaeurTemp);
        return "indexUtilisateur";
    }
      
       public String ajouter() {
        UtilisateurInterface cmi = new UtilisateurImpl();
        cmi.save(utilisateur);
        return "indexUtilisateur";
    }
     
       
        public String modifier() {
        UtilisateurInterface cmi = new UtilisateurImpl();
        cmi.update(utilisateur);
        return "indexUtilisateur";
    }

    /**
     * Creates a new instance of UtilisateurManagedBean
     */
    public UtilisateurManagedBean() {
         if (this.utilisateur == null) {
            this.utilisateur = new Utilisateur();
        }
    }
    
}
