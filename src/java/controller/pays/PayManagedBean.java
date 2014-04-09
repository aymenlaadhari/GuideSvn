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




import model.Pay;
@ManagedBean(name = "PayManagedBean")
@SessionScoped
public class PayManagedBean implements Serializable{

   PaysInterface  paysInterface ;
    private Pay pay;
    private List<Pay> listPay;
//get+set
    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
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

    public void ajoutcc(ActionEvent actionEvent) {
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
        this.listPay= new ArrayList<>();

        if (this.pay == null) {
            this.pay = new Pay();
        }

    }

}
