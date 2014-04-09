/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.utilisateur;

import java.util.List;
import model.Utilisateur;

/**
 *
 * @author hp
 */
public interface UtilisateurInterface 
{
    public void save(Utilisateur utilisateur );
    public List<Utilisateur> getListUtilisateur();
    public void remove(Utilisateur utilisateur);
    public void update(Utilisateur utilisateur);
    public Utilisateur getUtilisateur(int id);
    public Utilisateur login(Utilisateur utilisateur);
    public Utilisateur findByUtilisateur(Utilisateur utilisateur) ;
}
