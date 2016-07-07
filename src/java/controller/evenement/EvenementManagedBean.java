/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.evenement;

import dao.evenement.EvenementImpl;
import dao.evenement.EvenementInterface;
import dao.hotel.HotelImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Evenement;
import model.Pay;
import model.Ville;
import model.Hotel;
import org.primefaces.event.ToggleEvent;

@ManagedBean(name = "EvenementManagedBean")
@SessionScoped
public class EvenementManagedBean implements Serializable {

    EvenementInterface evenementInterface;
    private Evenement evenement;
    private List<Evenement> listEvenement;
    private Evenement selectEvenement;
    private String place="Choisir le lieu d'interet" ;
    private List<Pay> listPays;
    private List<Ville> listVille;
    private List<Hotel> listHotel;



    private String ville;
    private String pays;

    public List<Ville> getListVille() {
        listVille = new ArrayList<Ville>();
        HotelImpl paysInterface = new HotelImpl();
        listVille = paysInterface.getListAllVille(pays);

        System.err.println("getListVille idpays " + place + "  " + pays + "  " + listVille);

        return listVille;
    }
    public List<Hotel> getListHotel() {
        
        listHotel = new ArrayList<Hotel>();
        HotelImpl paysInterface = new HotelImpl();
        listHotel = paysInterface.getListAllHotel(pays,ville);

        System.err.println("getListHotel " + place + "  " + pays + "  " + ville+ " "+listHotel);

        return listHotel;
    }

    public void setListHotel(List<Hotel> listHotel) {
        this.listHotel = listHotel;
    }
    public void setListVille(List<Ville> listVille) {
        this.listVille = listVille;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    //get+set
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        System.out.println("ok" + place);
        this.place = place;
    }

    public Evenement getSelectEvenement() {
        return selectEvenement;
    }

    public void setSelectEvenement(Evenement selectEvenement) {
        this.selectEvenement = selectEvenement;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public List<Evenement> getListEvenement() {
        evenementInterface = new EvenementImpl();
        listEvenement = evenementInterface.getListEvenement();
        return listEvenement;
    }

    public List<Evenement> getListEvenementInvalide() {
        evenementInterface = new EvenementImpl();
        listEvenement = evenementInterface.getListEvenementInvalide();
        return listEvenement;
    }

    

    public void setListEvenement(List<Evenement> listEvenement) {
        this.listEvenement = listEvenement;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        evenement = new Evenement();

    }

    public void editEvent(int idEvent) {
        System.out.print(idEvent);
        evenementInterface = new EvenementImpl();
        evenement = evenementInterface.getEvenement(idEvent);

    }

    public void suppEvent(int idEvent) {
        System.out.print(idEvent);
        evenementInterface = new EvenementImpl();
        evenement = evenementInterface.getEvenement(idEvent);

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        evenementInterface = new EvenementImpl();
        evenementInterface.update(evenement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement mise à jour"));
    }

    public void ajoutevenement(ActionEvent actionEvent) {
        evenementInterface = new EvenementImpl();
        evenementInterface.save(evenement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement ajouté"));
        evenement = new Evenement();
    }

    public void delet(ActionEvent actionEvent) {
        evenementInterface = new EvenementImpl();
        evenementInterface.remove(evenement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Evenement supprimé"));

    }

    //methode pour l affichage de dialog de detail ("flech à gauche")
    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Ligne " + event.getVisibility(),
                "Nom :" + ((Evenement) event.getData()).getNom());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    ///methode de choisir le lieu l pays s'affichera 
    public void processPlace() {
        System.out.println("place" + place);
        pays="Choisir le pays";
        ville="Choisir la ville";
        
        if (place.equals("Hotel")) {
            getListPays();

        }
    }

    public void processPays() {
        getListVille();
    }

    public void processVille() {

    }
////

    public List<Pay> getListPays() {
        listPays = new ArrayList<Pay>();
        HotelImpl paysInterface = new HotelImpl();
        //  listPays = paysInterface.getListAllPaysHotel();
        listPays = paysInterface.getListAllPays();

        System.err.println("getListPay idpays " + place + "  " + listPays);
        return listPays;
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public EvenementManagedBean() {
        this.listEvenement = new ArrayList<Evenement>();

        if (this.evenement == null) {
            this.evenement = new Evenement();
        }

    }

}
