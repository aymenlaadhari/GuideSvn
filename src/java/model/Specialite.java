package model;
// Generated 26 mars 2014 16:28:09 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Specialite generated by hbm2java
 */
@Entity
@Table(name="specialite"
    ,schema="public"
)
public class Specialite  implements java.io.Serializable {


     private int id;
     private String nom;
     private String description;

    public Specialite() {
    }

	
    public Specialite(int id) {
        this.id = id;
    }
    public Specialite(int id, String nom, String description) {
       this.id = id;
       this.nom = nom;
       this.description = description;
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

    
    @Column(name="description", length=25)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


