/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ClientWeb"
    ,schema="public"
)
public class ClientWeb implements java.io.Serializable {

    private int idClientWeb; 
     private String nom;
     private String prenom;
     private String adresse;
     private String email;
     private String password;
     private String login;
     private String telephone; 
     private  String sexe;
     private String message;
     

    public ClientWeb() {
    }


    public ClientWeb(int idClientWeb) {
        this.idClientWeb = idClientWeb;
    }
    public ClientWeb(int idClientWeb,String message, String nom,String sexe, String prenom, String adresse, String email, String password, String login, String telephone) {
       this.idClientWeb = idClientWeb;
       this.nom = nom;
       this.prenom = prenom;
       this.adresse = adresse;
       this.email = email;
       this.password = password;
       this.login = login;
       this.telephone = telephone;
       this.sexe=sexe;
       this.message=message;
    }
    
     @Id 

    @Column(name="idClientWeb", unique=true, nullable=false)
    public int getIdClientWeb() {
        return this.idClientWeb;
    }
    
    public void setIdClientWeb(int idClientWeb) {
        this.idClientWeb = idClientWeb;
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
 @Column(name="message", length=10000)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   

}
