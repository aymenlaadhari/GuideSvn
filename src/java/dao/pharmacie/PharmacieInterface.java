/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pharmacie;

import java.util.List;
import model.Pharmacie;


/**
 *
 * @author hp
 */
public interface PharmacieInterface {

    public void save(Pharmacie pharmacie);
    public void remove(Pharmacie pharmacie);
    public void update(Pharmacie pharmacie);
    public Pharmacie getPharmacie(int id);
    public List<Pharmacie> getListPharmacie();//valide
    public List<Pharmacie> getListPharmacieInvalide();
    public List<Pharmacie> getListPharmacieArchive();

  
}
