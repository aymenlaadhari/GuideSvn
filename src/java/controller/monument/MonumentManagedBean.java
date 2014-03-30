/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.monument;


import dao.monument.MonumentImpl;
import dao.monument.MonumentInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Monument;


/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class MonumentManagedBean implements Serializable {

    private Monument monument ;
    private DataModel listMonument;

    //getteur et setteur -->Monument
    public Monument getMonument() {
        return monument;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
    }
   

   //getteur -->listMonument
    
    public DataModel getListMonument() {
        List<Monument> list = new MonumentImpl().list();
       listMonument = new ListDataModel(list); 
        return listMonument;
    }
    

///les methodes
    public String preparerAjout() {
        monument = new Monument();
        return "gestionMonument";
    }

    public String preparerModifier() {
        monument = (Monument) (listMonument.getRowData());
        return "gestionMonument";
    }


    public String ajouter() {
        MonumentInterface mi = new MonumentImpl();
        mi.save(monument);
        return "indexMonument";
    }

    public String modifier() {
       MonumentInterface mi = new MonumentImpl();
        mi.update(monument);
        return "indexMonument";
    }
     public String supprimer() {
        Monument monumentTemp = (Monument) (listMonument.getRowData());
        MonumentInterface mi = new MonumentImpl();
        mi.remove(monumentTemp);
        return "indexMonument";
    }
    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public MonumentManagedBean() {

        if (this.monument== null) {
            this.monument = new Monument();
        }

    }
    

}
