/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.evenement;

import dao.evenement.EvenementImpl;
import dao.evenement.EvenementInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Evenement;



/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class EvenementManagedBean implements Serializable {

    private Evenement evenement;
    private DataModel listEvenement;

    //getteur et setteur -->Monument
    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
    

   //getteur -->listEvenement
  
    public DataModel getListEvenement() {
        List<Evenement> list = new EvenementImpl().list();
        listEvenement = new ListDataModel(list); 
        return listEvenement;
    }
      

///les methodes
    public String preparerAjout() {
       evenement = new Evenement();
        return "gestionEvenement";
    }

    public String preparerModifier() {
        evenement = (Evenement) (listEvenement.getRowData());
        return "gestionEvenement";
    }


    public String ajouter() {
        EvenementInterface ei = new EvenementImpl();
        ei.save(evenement);
        return "indexEvenement";
    }

    public String modifier() {
       EvenementInterface ei = new  EvenementImpl();
        ei.update(evenement);
        return "indexEvenement";
    }
     public String supprimer() {
        Evenement evenementTemp = (Evenement) (listEvenement.getRowData());
        EvenementInterface ei = new EvenementImpl();
        ei.remove(evenementTemp);
        return "indexEvenement";
    }
    /**
     * Creates a new instance of EvenementManagedBean
     */
    public EvenementManagedBean() {

        if (this.evenement== null) {
            this.evenement = new Evenement();
        }

    }
    

}
