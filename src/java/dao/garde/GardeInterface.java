/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.garde;

import java.util.List;
import model.Garde;


/**
 *
 * @author hp
 */
public interface GardeInterface {

    public void save(Garde garde);
    public List<Garde> getListGarde();
    public void remove(Garde garde);
    public void update(Garde garde);
    public Garde getGarde(int id);
   
     

}
