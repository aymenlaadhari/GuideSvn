/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ville;



import dao.ville.VilleImpl;
import dao.ville.VilleInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


import model.Ville;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class VilleManagedBean implements Serializable {

    private Ville ville;
    private DataModel listVille;

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

   

    public DataModel getListVille() {
        List<Ville> list = new VilleImpl().list();
        listVille = new ListDataModel(list);

        return listVille;
    }

    public String preparerAjout() {
        ville = new Ville();
        return "gestionVille";
    }

    public String preparerModifier() {
        ville = (Ville) (listVille.getRowData());
        return "gestionVille";
    }

    public String supprimer() {
        Ville villeTemp = (Ville) (listVille.getRowData());
        VilleInterface cmi = new VilleImpl();
        cmi.remove(villeTemp);
        return "indexVille";
    }

    public String ajouter() {
        VilleInterface cmi = new VilleImpl();
        cmi.save(ville);
        return "indexVille";
    }

    public String modifier() {
        VilleInterface cmi = new VilleImpl();
        cmi.update(ville);
        return "indexVille";
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public VilleManagedBean() {

        if (this.ville == null) {
            this.ville = new Ville();
        }

    }

}
