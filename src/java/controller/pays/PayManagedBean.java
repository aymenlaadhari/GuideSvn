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

/**
 *
 * @author hp
 */
@ManagedBean
@SessionScoped
public class PayManagedBean implements Serializable {

    private Pay pay;
    private List<Pay> listPay;
    PaysInterface paysInterface;

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public void setListPay(List<Pay> listPay) {
        this.listPay = listPay;
    }

    public List getListPay() {
        paysInterface = new PaysImpl();
        this.listPay = paysInterface.list();

        return listPay;
    }

    public void ajoutEvent(ActionEvent actionEvent) {
        pay = new Pay();

    }

    public void deletMessage(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pay supprimé"));
    }

    public void editEvent(long id) {
        System.out.print(id);
        paysInterface = new PaysImpl();
        pay = paysInterface.getPays(id);

    }

    public void edition(ActionEvent actionEvent) {
        paysInterface = new PaysImpl();
        paysInterface.update(pay);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Pay mise à jour"));
    }

    public void ajoutcc(ActionEvent actionEvent) {
        paysInterface = new PaysImpl();
        paysInterface.save(pay);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pay Evenement ajouté"));
        pay = new Pay();
    }

    public void delet(Pay pay) {
        paysInterface = new PaysImpl();
        paysInterface.remove(pay);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(" Pay supprimé"));

    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public PayManagedBean() {
        this.listPay = new ArrayList<>();

        if (this.pay == null) {
            this.pay = new Pay();
        }

    }

}
