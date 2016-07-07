/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pays;

import dao.pays.PaysImpl;
import dao.pays.PaysInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;




import model.Pay;
import model.Ville;
@ManagedBean(name = "PayManagedBean")
@SessionScoped
public class PayManagedBean implements Serializable{

    PaysInterface  paysInterface ;
    private Pay pay;
    private Pay selectPay;
    private List<Pay> listPay;
    private List<Ville> listVille;

    private int idpays;
    private Ville ville;

//get+set
   

    
    public int getIdpays() {
        return idpays;
    }

    public void setIdpays(int idpays) {
        this.idpays = idpays;
        System.out.println("setIdpays "+idpays );
    }

   /* public List<Ville> getListVille() {
        return listVille;
    }*/

    public void setListVille(List<Ville> listVille) {
        this.listVille = listVille;
    }
    
    public void processScat() {
        getSubCategoryName();
        getListVille();
    }
   
    @SuppressWarnings("unchecked")
    public List<SelectItem> getSubCategoryName() {
        List<SelectItem> subcat = new ArrayList<SelectItem>();
        //if (catname != null && !catname.equals("")) {            
        try {
            System.err.println("getSubCategoryName idpays "+idpays);
            List<Ville> listPay1 = getListVille();
            for(Ville temp:listPay1)
            {
                subcat.add(new SelectItem(temp.getNom()));
            }
            
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // }
        return subcat;
    }
//////
    public List<Ville> getListVille() {
        listVille=new ArrayList<Ville>();
        PaysImpl paysInterface = new PaysImpl();
        listVille = paysInterface.getListVille(idpays);
        System.err.println("getListVille idpays "+idpays);
        return listVille;
    }
    public Pay getSelectPay() {
        return selectPay;
    }

    public void setSelectPay(Pay selectPay) {
        this.selectPay = selectPay;
    }
    
    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }
    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
    public List<Pay> getListPay() {
         paysInterface = new PaysImpl();
        listPay = paysInterface.getListPays();
        return listPay;
    }

    public void setListPay(List<Pay> listPay) {
        this.listPay = listPay;
    }

    //Methodes
    public void ajoutEvent(ActionEvent actionEvent) {
        pay = new Pay();

    }

    public void editEvent(int id) {
        System.out.print(id);
        paysInterface = new PaysImpl();
        pay = paysInterface.getPays(id);

    }
public void suppEvent(int id) {
        System.out.print(id);
        paysInterface = new PaysImpl();
        pay = paysInterface.getPays(id);
    }
    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pay supprimé"));
    }

    public void edition(ActionEvent actionEvent) {
        paysInterface = new PaysImpl();
       paysInterface.update(pay);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pay mise à jour"));
    }

    public void ajoutpays(ActionEvent actionEvent) {
        paysInterface = new PaysImpl();
       paysInterface.save(pay);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pay ajouté"));
        pay = new Pay();
    }

    public void delet(ActionEvent actionEvent) {
        paysInterface = new PaysImpl();
       paysInterface.remove(pay);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pay supprimé"));

    }
 


    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public PayManagedBean() {
        this.listPay= new ArrayList<Pay>();

        if (this.pay == null) {
            this.pay = new Pay();
        }

    }

}
