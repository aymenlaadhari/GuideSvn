package model;
// Generated Apr 2, 2014 11:37:33 AM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="utilisateur"
    ,schema="public"
)
public class Utilisateur  implements java.io.Serializable {


     private int id;
     private String nom;
     private String prenom;
     private String adresse;
     private String email;
     private String password;
     private String login;
     private String telephone;

    public Utilisateur() {
    }

	
    public Utilisateur(int id) {
        this.id = id;
    }
    public Utilisateur(int id, String nom, String prenom, String adresse, String email, String password, String login, String telephone) {
       this.id = id;
       this.nom = nom;
       this.prenom = prenom;
       this.adresse = adresse;
       this.email = email;
       this.password = password;
       this.login = login;
       this.telephone = telephone;
    }
   
     @Id 

    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="nom", length=25)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="prenom", length=25)
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    @Column(name="adresse", length=25)
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
    @Column(name="email", length=25)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="password", length=25)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="login", length=258)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="telephone", length=258)
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }




}


