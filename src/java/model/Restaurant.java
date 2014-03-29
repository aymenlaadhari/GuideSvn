package model;
// Generated 26 mars 2014 16:28:09 by Hibernate Tools 3.6.0


import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Restaurant generated by hbm2java
 */
@Entity
@Table(name="restaurant"
    ,schema="public"
)
public class Restaurant  implements java.io.Serializable {


     private int id;
     private String telephone;
     private String email;
     private String siteweb;
     private Long longitude;
     private Long latitude;
     

    public Restaurant() {
    }

	
    public Restaurant(int id) {
        this.id = id;
    }
    public Restaurant(int id, String telephone, String email, String siteweb, Long longitude, Long latitude) {
       this.id = id;
       this.telephone = telephone;
       this.email = email;
       this.siteweb = siteweb;
       this.longitude = longitude;
       this.latitude = latitude;
    }
   
     @Id @GeneratedValue

    
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

   

   
    
    




}


