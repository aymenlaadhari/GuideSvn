/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ClientMobile"
    ,schema="public"
)
public class ClientMobile implements java.io.Serializable {

    private int idClientMobile; 
     private String nom;
     private String prenom;
     private String adresse;
     private String email;
     private String password;
     private String login;
     private String telephone; 
     private  String sexe;
   //  private Set<Hotel> hotels;
     
     
     

    public ClientMobile() {
    }


    public ClientMobile(int idClientMobile) {
        this.idClientMobile = idClientMobile;
    }
    public ClientMobile(int idClientMobile,String nom,String sexe, String prenom, String adresse, String email, String password, String login, String telephone) {
       this.idClientMobile = idClientMobile;
       this.nom = nom;
       this.prenom = prenom;
       this.adresse = adresse;
       this.email = email;
       this.password = password;
       this.login = login;
       this.telephone = telephone;
       this.sexe=sexe;
       
    }

//    public Set<Hotel> getHotels() {
//        return hotels;
//    }
//
//    public void setHotels(Set<Hotel> hotels) {
//        this.hotels = hotels;
//    }

    
     @Id 

    @Column(name="idClientMobile", unique=true, nullable=false)
    public int getIdClientMobile() {
        return this.idClientMobile;
    }
    
    public void setIdClientMobile(int idClientMobile) {
        this.idClientMobile = idClientMobile;
    }

    
    @Column(name="nom", length=258)
     //@NotNull(message = "Nom requis")
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="prenom", length=258)
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    @Column(name="adresse", length=258)
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
    @Column(name="email", length=258)

        public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
 @Column(name="sexe", length=258)
    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    
    @Column(name="password", length=258)
//    @NotNull(message = "Mot de passe requis")
//    @Size(min = 4, max = 25, message = "Mot de passe doit étre en 4 et 25 caractéres")
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="login", length=258)
//     @NotNull(message = "Login requis")
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="telephone", length=258)
    //@NotNull(message = "Telephone requis")
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
 

   

}
