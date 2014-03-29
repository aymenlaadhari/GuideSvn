package model;
// Generated 26 mars 2014 16:28:09 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ville generated by hbm2java
 */
@Entity
@Table(name="ville"
    ,schema="public"
)
public class Ville  implements java.io.Serializable {


     private int id;
     private String gouvernorat;
     private String nom;
     private String rue;

    public Ville() {
    }

	
    public Ville(int id) {
        this.id = id;
    }
    public Ville(int id, String gouvernorat, String nom, String rue) {
       this.id = id;
       this.gouvernorat = gouvernorat;
       this.nom = nom;
       this.rue = rue;
    }
   
     @Id @GeneratedValue

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="gouvernorat", length=25)
    public String getGouvernorat() {
        return this.gouvernorat;
    }
    
    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    
    @Column(name="nom", length=25)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="rue", length=25)
    public String getRue() {
        return this.rue;
    }
    
    public void setRue(String rue) {
        this.rue = rue;
    }




}


