/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.centreCommercial;

import dao.centreCommercial.CentreCommercialImp;
import dao.centreCommercial.CentreInt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.CentreCommercial;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class CentrecommercialeManagedBean implements Serializable{
    private CentreCommercial centreCommercial;
    private DataModel listCentre;
    //private List<CentreCommercial> centreCommercials;

   /* public List<CentreCommercial> getCentreCommercials() {
        CentreInt ci = new CentreCommercialImp();
        this.centreCommercials = ci.list();
        return centreCommercials;
    }

    public void setCentreCommercials(List<CentreCommercial> centreCommercials) {
        this.centreCommercials = centreCommercials;
    }*/
    
    

    public CentreCommercial getCentreCommercial() {
        return centreCommercial;
    }

    public void setCentreCommercial(CentreCommercial centreCommercial) {
        this.centreCommercial = centreCommercial;
    }

    public DataModel getListCentre() {
         List<CentreCommercial> list = new CentreCommercialImp().list();
        listCentre = new ListDataModel(list);
        
        return listCentre;
    }

   public String preparerAjout()
   {
       centreCommercial = new CentreCommercial();
       return "gestion";
   }
   
   public String preparerModifier()
   {
       centreCommercial = (CentreCommercial)(listCentre.getRowData());
       return "gestion";
   }
    
    public String supprimer()
    {
        CentreCommercial centreCommercialTemp = (CentreCommercial)(listCentre.getRowData());
        CentreInt ci = new CentreCommercialImp();
        ci.remove(centreCommercialTemp);
        return "index";
    }
    
    public String ajouter()
    {
        CentreInt ci = new CentreCommercialImp();
        ci.save(centreCommercial);
        return "index";
    }
    
    public String modifier()
    {
        CentreInt ci = new CentreCommercialImp();
        ci.update(centreCommercial);
        return "index";
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public CentrecommercialeManagedBean() {
        //this.centreCommercials = new ArrayList<>();
        
        if(this.centreCommercial == null)
        {
        this.centreCommercial = new CentreCommercial();
        }
          
        
    }
    
}
