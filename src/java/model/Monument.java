package model;
// Generated Apr 2, 2014 11:37:33 AM by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Monument generated by hbm2java
 */
@Entity
@Table(name="monument"
    ,schema="public"
)
public class Monument  implements java.io.Serializable {


     private int idMonument;
     private String image;
     private String nomM;
     private Double longitude;
     private Double latitude;
     private String description;
     private String type;
     private Date dateconstruction;
         
     private Ville idVille;
      private String imagemobile;

    public String getImagemobile() {
        return imagemobile;
    }

    public void setImagemobile(String imagemobile) {
        this.imagemobile = imagemobile;
    }

    public Ville getIdVille() {
        return idVille;
    }

    public void setIdVille(Ville ville) {
        this.idVille = ville;
    }
    
   

    public Monument() {
    }

	
    public Monument(int idMonument) {
        this.idMonument = idMonument;
    }
    public Monument(int idMonument,String image, String nomM, Ville ville,Double longitude, Double latitude, String description, String type, Date dateconstruction) {
       this.idMonument = idMonument;
       this.image=image;
       this.nomM = nomM;
       this.idVille=ville;
       this.longitude = longitude;
       this.latitude = latitude;
       this.description = description;
       this.type = type;
       this.dateconstruction = dateconstruction;
      
    }
   
     @Id 

    
    @Column(name="id_monument", unique=true, nullable=false)
    public int getIdMonument() {
        return this.idMonument;
    }
    
    public void setIdMonument(int idMonument) {
        this.idMonument = idMonument;
    }

    
    @Column(name="nom_m", length=258)
    public String getNomM() {
        return this.nomM;
    }
    
    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    @Column(name="longitude", precision=20, scale=20)
    public Double getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    
    @Column(name="latitude", precision=20, scale=20)
    public Double getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    
    @Column(name="description", length=1000)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="type", length=258)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dateconstruction", length=258)
    public Date getDateconstruction() {
        return this.dateconstruction;
    }
    
    public void setDateconstruction(Date dateconstruction) {
        this.dateconstruction = dateconstruction;
    }

  
    
  @Column(name="image", length=258)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.nomM != null ? this.nomM.hashCode() : 0);
        hash = 17 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 17 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
     final Monument other = (Monument) obj;
        if ((this.nomM == null) ? (other.nomM != null) : !this.nomM.equals(other.nomM)) {
            return false;
        }
        if (this.longitude != other.longitude && (this.longitude == null || !this.longitude.equals(other.longitude))) {
            return false;
        }
        if (this.latitude != other.latitude && (this.latitude == null || !this.latitude.equals(other.latitude))) {
            return false;
        }
        return true;
    }

    


}


