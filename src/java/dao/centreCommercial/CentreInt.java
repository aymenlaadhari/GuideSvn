/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.centreCommercial;

import java.util.List;
import model.CentreCommercial;


/**
 *
 * @author hp
 */
public interface CentreInt {

    public void addCentreCommercial(CentreCommercial centreCommercial);
    public void updateCentreCommercial(CentreCommercial centreCommercial);
    public void deletCentreCommercial(CentreCommercial centreCommercial);
    public CentreCommercial getCentreCommercial(int idCC);
    public List<CentreCommercial> getListCentreCommercial();//valide
    public List<CentreCommercial> getListCentreCommercialInvalide();
    public List<CentreCommercial> getListCentreCommercialArchive();

    
         

}
