/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pays;





import dao.pays.PaysImpl;
import dao.pays.PaysInterface;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;



import model.Pay;

/**
 *
 * @author hp
 */
@ManagedBean
@RequestScoped
public class PayManagedBean implements Serializable {

    private Pay pay;
    private DataModel listPay;

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

   

   

    public DataModel getListPay() {
        List<Pay> list = new PaysImpl().list();
        listPay = new ListDataModel(list);

        return listPay;
    }

    public String preparerAjout() {
        pay = new Pay();
        return "gestionPay";
    }

    public String preparerModifier() {
        pay = (Pay) (listPay.getRowData());
        return "gestionPay";
    }

    public String supprimer() {
        Pay payTemp = (Pay) (listPay.getRowData());
        PaysInterface cmi = new PaysImpl();
        cmi.remove(payTemp);
        return "indexPay";
    }

    public String ajouter() {
        PaysInterface cmi = new PaysImpl();
        cmi.save(pay);
        return "indexPay";
    }

    public String modifier() {
        PaysInterface cmi = new PaysImpl();
        cmi.update(pay);
        return "indexPay";
    }

    /**
     * Creates a new instance of CentremedicaleManagedBean
     */
    public PayManagedBean() {

        if (this.pay == null) {
            this.pay = new Pay();
        }

    }

}
