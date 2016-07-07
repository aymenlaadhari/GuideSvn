/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.evenement;

import java.util.List;
import model.Evenement;





public interface EvenementInterface {

    public void save(Evenement evenement);
    public void remove(Evenement evenement);
    public void update(Evenement evenement);
    public Evenement getEvenement(int idEvent);
    public List<Evenement> getListEvenement();//valide
    public List<Evenement> getListEvenementInvalide();
    
    
}
