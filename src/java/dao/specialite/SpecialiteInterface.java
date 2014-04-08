/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.specialite;

import java.util.List;
import model.Specialite;


/**
 *
 * @author hp
 */
public interface SpecialiteInterface {

    public void save(Specialite specialite);

    public List<Specialite> getListSpecialite();

    public void remove(Specialite specialite);

    public void update(Specialite specialite);

    public Specialite getSpecialite(int id);

   // public Specialite findBySpecialite(Specialite specialite);

}
