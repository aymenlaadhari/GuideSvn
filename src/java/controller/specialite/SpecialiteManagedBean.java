/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.specialite;


import dao.specialite.SpecialiteImpl;
import dao.specialite.SpecialiteInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import model.Specialite;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class SpecialiteManagedBean implements Serializable {

    private Specialite specialite;
    private DataModel listSpecialite;

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public DataModel getListSpecialite() {
        List<Specialite> list = new SpecialiteImpl().list();
        listSpecialite = new ListDataModel(list);

        return listSpecialite;
    }

    public String preparerAjout() {
        specialite = new Specialite();
        return "gestionSpecialite";
    }

    public String preparerModifier() {
        specialite = (Specialite) (listSpecialite.getRowData());
        return "gestionSpecialite";
    }

    public String supprimer() {
        Specialite specialiteTemp = (Specialite) (listSpecialite.getRowData());
        SpecialiteInterface cmi = new SpecialiteImpl();
        cmi.remove(specialiteTemp);
        return "indexSpecialite";
    }

    public String ajouter() {
        SpecialiteInterface cmi = new SpecialiteImpl();
        cmi.save(specialite);
        return "indexSpecialite";
    }

    public String modifier() {
        SpecialiteInterface cmi = new SpecialiteImpl();
        cmi.update(specialite);
        return "indexSpecialite";
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public SpecialiteManagedBean() {

        if (this.specialite == null) {
            this.specialite = new Specialite();
        }

    }

}
