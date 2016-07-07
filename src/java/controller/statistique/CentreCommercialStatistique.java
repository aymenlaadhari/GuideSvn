/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.statistique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.CentreCommercial;


/**
 *
 * @author Administrator
 */
@ManagedBean(name = "centreCommercialStatistique")
@SessionScoped
public class CentreCommercialStatistique implements Serializable {
    private List<CentreCommercial> centres;  
  
    public  CentreCommercialStatistique() {  
        centres = new ArrayList<CentreCommercial>();  
        centres.add(new CentreCommercial("Boutique",200)); 
        centres.add(new CentreCommercial("Cafe",300)); 
         
    }  
  
    public List<CentreCommercial> getCentreCommercials() {  
        return centres;  
    }  
}  
    
    

