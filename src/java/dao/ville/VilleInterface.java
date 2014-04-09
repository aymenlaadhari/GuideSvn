/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.ville;

import java.util.List;
import model.Ville;


/**
 *
 * @author hp
 */
public interface VilleInterface {

    public void save(Ville ville);

    public Ville getVille(int id);

    public List<Ville> getListVille();

    public void remove(Ville ville);

    public void update(Ville ville);

}
