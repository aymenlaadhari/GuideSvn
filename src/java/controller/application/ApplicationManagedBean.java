/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.application;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;


import javax.faces.bean.SessionScoped;

/**
 *
 * @author hp
 */


@ManagedBean
public class ApplicationManagedBean implements Serializable{

   public String gestionCommercial()
   {
       return "gestion";
   }
    public String indexCommercial()
   {
       return "index";
   }
    
   
    public String indexMedical()
   {
       return "indexCentreMedicale";
   }
    
    public String gestionGarde()
   {
       return "gestionGarde";
   }
    public String indexgarde()
   {
       return "indexGarde";
   }
    
    public String gestionPay()
   {
       return "gestionPay";
   }
    public String indexPay()
   {
       return "indexPay";
   }
    
    public String gestionPharmacie()
   {
       return "gestionPharmacie";
   }
    public String indexPharmacie()
   {
       return "indexPharmacie";
   }
    
    public String gestionRestaurant()
   {
       return "gestionRestaurant";
   }
    public String indexRestaurant()
   {
       return "indexRestaurant";
   }
    
    public String gestionSpecialite()
   {
       return "gestionSpecialite";
   }
    public String indexSpecialite()
   {
       return "indexSpecialite";
   }
    
      public String gestionVille()
   {
       return "gestionVille";
   }
    public String indexVille()
   {
       return "indexVille";
   }
    
    public String logout()
    {
        return "login";
    }
   
    public ApplicationManagedBean() {
        
    }
    
}
