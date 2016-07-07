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


    public String indexPay() {
        return "/faces/Views/indexPay.xhtml";
    }
    public String indexHelp() {
        return "/faces/Views/help.xhtml";
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

    public String indexImage() {
        return "/faces/Views/indexImage.xhtml";
    }

    public String acceuil() {
        return "/faces/Views/Acceuil.xhtml";
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
    public String indexFeeds() {
        return "/faces/Views/indexFeeds.xhtml";
    }

    public String Statistique() {
        return "/faces/Views/statistique.xhtml";
    }

    public String indexMonument() {
        return "/faces/Views/indexMonument.xhtml";
    }

    public String validationMonument() {
        return "/faces/Views/validationMonument.xhtml";
    }

    public String archiveMonument() {
        return "/faces/Views/ArchiveMonument.xhtml";
    }
    
 public String validationRestaurant() {
        return "/faces/Views/validationRestaurant.xhtml";
    }

    public String archiveRestaurant() {
        return "/faces/Views/archiveRestaurant.xhtml";
    }
    
 public String validationHotel() {
        return "/faces/Views/validationHotel.xhtml";
    }

    public String archiveHotel() {
        return "/faces/Views/archiveHotel.xhtml";
    }
 public String validationPharmacie() {
        return "/faces/Views/validationPharmacie.xhtml";
    }

    public String archivePharmacie() {
        return "/faces/Views/archivePharmacie.xhtml";
    }
 public String validationEvenement() {
        return "/faces/Views/validationEvenement.xhtml";
    }

    public String archiveEvenement() {
        return "/faces/Views/archiveEvent.xhtml";
    }
    
 public String validationCentreComm() {
        return "/faces/Views/validationCentreComm.xhtml";
    }

    public String archiveCentreComm() {
        return "/faces/Views/archiveCentreComm.xhtml";
    }
 public String validationCentreMedical() {
        return "/faces/Views/validationCentreMedical.xhtml";
    }

    public String archiveCentreMedical() {
        return "/faces/Views/archiveCentreMedical.xhtml";
    }
   
    
    
    public ApplicationManagedBean() {

    }

}
