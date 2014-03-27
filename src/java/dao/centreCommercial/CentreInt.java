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

    public void save(CentreCommercial centreCommercial);

    public List<CentreCommercial> list();

    public void remove(CentreCommercial centreCommercial);

    public void update(CentreCommercial centreCommercial);

    public CentreCommercial getCentre(long id);

   // public CentreCommercial findByCentre(CentreCommercial centreCommercial);

}
