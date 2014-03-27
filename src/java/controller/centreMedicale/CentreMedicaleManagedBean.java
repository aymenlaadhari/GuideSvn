/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.centreMedicale;

import dao.centreMedical.CentreMedicalImpl;
import dao.centreMedical.CentreMedicaleInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import model.CentreMedicale;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class CentreMedicaleManagedBean implements Serializable {

    private CentreMedicale centreMedicale;
    private DataModel listCentre;

    public CentreMedicale getCentreMedicale() {
        return centreMedicale;
    }

    public void setCentreMedicale(CentreMedicale centreMedicale) {
        this.centreMedicale = centreMedicale;
    }

    public DataModel getListCentre() {
        List<CentreMedicale> list = new CentreMedicalImpl().list();
        listCentre = new ListDataModel(list);

        return listCentre;
    }

    public String preparerAjout() {
        centreMedicale = new CentreMedicale();
        return "gestionCentreMedicale";
    }

    public String preparerModifier() {
        centreMedicale = (CentreMedicale) (listCentre.getRowData());
        return "gestionCentreMedicale";
    }

    public String supprimer() {
        CentreMedicale centreMedicaleTemp = (CentreMedicale) (listCentre.getRowData());
        CentreMedicaleInterface cmi = new CentreMedicalImpl();
        cmi.remove(centreMedicaleTemp);
        return "indexCentreMedicale";
    }

    public String ajouter() {
        CentreMedicaleInterface cmi = new CentreMedicalImpl();
        cmi.save(centreMedicale);
        return "indexCentreMedicale";
    }

    public String modifier() {
        CentreMedicaleInterface cmi = new CentreMedicalImpl();
        cmi.update(centreMedicale);
        return "indexCentreMedicale";
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public CentreMedicaleManagedBean() {

        if (this.centreMedicale == null) {
            this.centreMedicale = new CentreMedicale();
        }

    }

}
