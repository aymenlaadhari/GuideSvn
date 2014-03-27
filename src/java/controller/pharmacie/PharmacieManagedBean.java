/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pays;

import dao.pays.PaysImpl;
import dao.pays.PaysInterface;
import dao.pharmacie.PharmacieImpl;
import dao.pharmacie.PharmacieInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import model.Pay;
import model.Pharmacie;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class PharmacieManagedBean implements Serializable {

    private Pharmacie pharmacie;
    private DataModel listPharmacie;

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public DataModel getListPharmacie() {
        List<Pharmacie> list = new PharmacieImpl().list();
        listPharmacie = new ListDataModel(list);

        return listPharmacie;
    }

    public String preparerAjout() {
        pharmacie = new Pharmacie();
        return "gestionPharmacie";
    }

    public String preparerModifier() {
        pharmacie = (Pharmacie) (listPharmacie.getRowData());
        return "gestionPharmacie";
    }

    public String supprimer() {
        Pharmacie pharmacieTemp = (Pharmacie) (listPharmacie.getRowData());
        PharmacieInterface cmi = new PharmacieImpl();
        cmi.remove(pharmacieTemp);
        return "indexPharmacie";
    }

    public String ajouter() {
        PharmacieInterface cmi = new PharmacieImpl();
        cmi.save(pharmacie);
        return "indexPharmacie";
    }

    public String modifier() {
        PharmacieInterface cmi = new PharmacieImpl();
        cmi.update(pharmacie);
        return "indexPharmacie";
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public PharmacieManagedBean() {

        if (this.pharmacie == null) {
            this.pharmacie = new Pharmacie();
        }

    }

}
