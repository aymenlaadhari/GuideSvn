/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.garde;



import dao.garde.GardeImpl;
import dao.garde.GardeInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


import model.Garde;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class GardeManagedBean implements Serializable {

    private Garde garde;
    private DataModel listGarde;

    public Garde getGarde() {
        return garde;
    }

    public void setGarde(Garde garde) {
        this.garde = garde;
    }

   

    public DataModel getListGarde() {
        List<Garde> list = new GardeImpl().list();
        listGarde = new ListDataModel(list);

        return listGarde;
    }

    public String preparerAjout() {
        garde = new Garde();
        return "gestionGarde";
    }

    public String preparerModifier() {
        garde = (Garde) (listGarde.getRowData());
        return "gestionGarde";
    }

    public String supprimer() {
        Garde gardeTemp = (Garde) (listGarde.getRowData());
        GardeInterface cmi = new GardeImpl();
        cmi.remove(gardeTemp);
        return "indexGarde";
    }

    public String ajouter() {
        GardeInterface cmi = new GardeImpl();
        cmi.save(garde);
        return "indexGarde";
    }

    public String modifier() {
        GardeInterface cmi = new GardeImpl();
        cmi.update(garde);
        return "indexGarde";
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public GardeManagedBean() {

        if (this.garde == null) {
            this.garde = new Garde();
        }

    }

}
