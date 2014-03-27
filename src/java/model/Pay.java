package model;
// Generated 26 mars 2014 16:28:09 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pay generated by hbm2java
 */
@Entity
@Table(name="pay"
    ,schema="public"
)
public class Pay  implements java.io.Serializable {


     private int id;
     private String nom;

    public Pay() {
    }

	
    public Pay(int id) {
        this.id = id;
    }
    public Pay(int id, String nom) {
       this.id = id;
       this.nom = nom;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="nom")
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }




}

