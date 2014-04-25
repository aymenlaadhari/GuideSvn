/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.application;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;




/**
 *
 * @author hp
 */
@ManagedBean

public class ApplicationManagedBean implements Serializable {

   

    public String indexCommercial() {
        return "/faces/Views/index.xhtml";
    }

    public String indexMedical() {
        return "/faces/Views/indexCentreMedicale.xhtml";
    }

    
    public String indexgarde() {
        return "/faces/Views/indexGarde.xhtml";
    }

    

    public String indexPay() {
        return "/faces/Views/indexPay.xhtml";
    }

    
    public String indexPharmacie() {
        return "/faces/Views/indexPharmacie.xhtml";
    }

    

    public String indexRestaurant() {
        return "/faces/Views/indexRestaurant.xhtml";
    }

   

    public String indexSpecialite() {
        return "/faces/Views/indexSpecialite.xhtml";
    }

    

    public String indexVille() {
        return "/faces/Views/indexVille.xhtml";
    }

    
    public String logout() {
        return "/faces/Views/login.xhtml";
    }

    public String indexImage() {
        return "/faces/Views/indexImage.xhtml";
    }

    

    public String indexUtilisateur() {
        return "/faces/Views/indexUtilisateur.xhtml";
    }

    
    
    
     public String indexEvenement() {
        return "/faces/Views/indexEvenement.xhtml";
    }

    
    
      public String indexHotel() {
        return "/faces/Views/indexHotel.xhtml";
    }

    
        public String indexMonument() {
        return "/faces/Views/indexMonument.xhtml";
    }
        


    public ApplicationManagedBean() {

    }

}
