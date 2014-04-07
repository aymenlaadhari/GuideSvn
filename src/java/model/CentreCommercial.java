package model;
// Generated Apr 2, 2014 11:37:33 AM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="centre_commercial"
    ,schema="public"
)
public class CentreCommercial  implements java.io.Serializable {


     private int id;
     private String telephone;
     private String email;
     private String nom;
     private String description;
     private String siteweb;
     private Long longitude;
     private Long latitude;
     private String categorie;

    public CentreCommercial() {
    }

	
    public CentreCommercial(int id) {
        this.id = id;
    }
    public CentreCommercial(int id, String telephone, String email, String nom, String description, String siteweb, Long longitude, Long latitude, String categorie) {
       this.id = id;
       this.telephone = telephone;
       this.email = email;
       this.nom = nom;
       this.description = description;
       this.siteweb = siteweb;
       this.longitude = longitude;
       this.latitude = latitude;
       this.categorie = categorie;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="telephone", length=25)
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
    @Column(name="email", length=25)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="nom", length=25)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="description", length=258)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="siteweb", length=25)
    public String getSiteweb() {
        return this.siteweb;
    }
    
    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    
    @Column(name="longitude")
    public Long getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    
    @Column(name="latitude")
    public Long getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    
    @Column(name="categorie", length=258)
    public String getCategorie() {
        return this.categorie;
    }
    
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }




}


