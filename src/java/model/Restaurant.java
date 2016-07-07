package model;
// Generated Apr 2, 2014 11:37:33 AM by Hibernate Tools 3.6.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="restaurant"
    ,schema="public"
)
public class Restaurant  implements java.io.Serializable {


     private int idResto;
     private String telephone;
     private String email;
     private String siteweb;
     private Double longitude;
     private Double latitude;
     private String nom;
     private String description;
     private Date horairehouverture;
     private Date horairefermeture;
     private String image;
     private boolean archive;
     private boolean validation;
//   private Specialite specialite;
     private Ville idVille;
      private String imagemobile;

    public String getImagemobile() {
        return imagemobile;
    }

    public void setImagemobile(String imagemobile) {
        this.imagemobile = imagemobile;
    }
    
//     public Specialite getSpecialite() {
//        return specialite;
//    }
//
//    public void setSpecialite(Specialite specialite) {
//        this.specialite = specialite;
//    }
    
public Ville getIdVille() {
        return idVille;
    }

    public void setIdVille(Ville ville) {
        this.idVille = ville;
    }
    public Restaurant() {
    }

	
    public Restaurant(int idResto) {
        this.idResto = idResto;
    }
    public Restaurant(int idResto,String image,Ville ville, String telephone, String email, String siteweb, Double longitude, Double latitude, String nom, String description, Date horairehouverture, Date horairefermeture) {
       this.idResto = idResto;
     this.idVille=ville;
       this.image=image;
       this.telephone = telephone;
       this.email = email;
       this.siteweb = siteweb;
       this.longitude = longitude;
       this.latitude = latitude;
       this.nom = nom;
       this.description = description;
       this.horairehouverture = horairehouverture;
       this.horairefermeture = horairefermeture;
    }
   
     @Id 
    @Column(name="idResto", unique=true, nullable=false)
    public int getIdResto() {
        return this.idResto;
    }
    
    public void setIdResto(int idResto) {
        this.idResto = idResto;
    }

    
    @Column(name="telephone", length=258)
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
    @Column(name="email", length=258)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="siteweb", length=258)
    public String getSiteweb() {
        return this.siteweb;
    }
    
    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    
    @Column(name="longitude")
    public Double getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    
    @Column(name="latitude")
    public Double getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    
    @Column(name="nom", length=258)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="description", length=10000)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
  
    @Temporal(TemporalType.DATE)
    @Column(name="horairehouverture", length=258)
    public Date getHorairehouverture() {
        return this.horairehouverture;
    }
    
    public void setHorairehouverture(Date horairehouverture) {
        this.horairehouverture = horairehouverture;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="horairefermeture", length=258)
    public Date getHorairefermeture() {
        return this.horairefermeture;
    }
    
    public void setHorairefermeture(Date horairefermeture) {
        this.horairefermeture = horairefermeture;
    }

        
  @Column(name="image", length=258)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


  @Column(name="validation")
    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    @Column(name="archive")
    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

   
//    ////////////specialité
//     @Override
//    public int hashCode() {
//        int hash = 0;
//        if(hash == 5)
//        {
//        hash = 23 * hash + this.idResto;
////        hash = 23 * hash + (this.telephone != null ? this.telephone.hashCode() : 0);
//        hash = 23 * hash + (this.nom != null ? this.nom.hashCode() : 0);
////        hash = 23 * hash + (this.email != null ? this.email.hashCode() : 0);
////        hash = 23 * hash + (this.siteweb != null ? this.siteweb.hashCode() : 0);
//        hash = 23 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);        
//        hash = 23 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
//        hash = 23 * hash + (this.description != null ? this.description.hashCode() : 0);
////        hash = 23 * hash + (this.horairehouverture != null ? this.horairehouverture.hashCode() : 0);
////        hash = 23 * hash + (this.horairefermeture != null ? this.horairefermeture.hashCode() : 0);
////        hash = 23 * hash + (this.image != null ? this.image.hashCode() : 0);
////        hash = 23 * hash + (this.validation != null ? this.pay.hashCode() : 0);
////        hash = 23 * hash + (this.archive != null ? this.pay.hashCode() : 0);
////        
//        }
//      else
//       if(hash == 7)
//       {
//            
//        hash = 17 * hash + (this.nom != null ? this.nom.hashCode() : 0);
//        hash = 17 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
//        hash = 17 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
//       }
//        return hash;
//    
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Restaurant other = (Restaurant) obj;
//        if (this.idResto != other.idResto) {
//            return false;
//        }
////        if ((this.telephone == null) ? (other.telephone != null) : !this.telephone.equals(other.telephone)) {
////            return false;
////        }
//        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
//            return false;
//        }
////        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
////            return false;
////        }
////        
////     if (this.siteweb != other.siteweb && (this.siteweb == null || !this.siteweb.equals(other.siteweb))) {
////            return false;
////        }
//     if ((this.latitude == null) ? (other.latitude != null) : !this.latitude.equals(other.latitude)) {
//            return false;
//        }
//        if ((this.longitude == null) ? (other.longitude != null) : !this.longitude.equals(other.longitude)) {
//            return false;
//        }
////        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
////            return false;
////        }
////        
////     if (this.image != other.image && (this.image == null || !this.image.equals(other.image))) {
////            return false;
////        }
////      if (this.horairefermeture != other.horairefermeture && (this.horairefermeture == null || !this.horairefermeture.equals(other.horairefermeture))) {
////            return false;
////        }
////       if (this.horairehouverture != other.horairehouverture && (this.horairehouverture == null || !this.horairehouverture.equals(other.horairehouverture))) {
////            return false;
////        }
//  
////        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
////            return false;
////        }
////        if (this.longitude != other.longitude && (this.longitude == null || !this.longitude.equals(other.longitude))) {
////            return false;
////        }
////        if (this.latitude != other.latitude && (this.latitude == null || !this.latitude.equals(other.latitude))) {
////            return false;
////        }
//        return true;
//    }
//
    ///////////Ville
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.nom != null ? this.nom.hashCode() : 0);
        hash = 17 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 17 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 17 * hash + (this.telephone != null ? this.telephone.hashCode() : 0);
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
        final Restaurant other = (Restaurant) obj;
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        if (this.longitude != other.longitude && (this.longitude == null || !this.longitude.equals(other.longitude))) {
            return false;
        }
        if (this.latitude != other.latitude && (this.latitude == null || !this.latitude.equals(other.latitude))) {
            return false;
        }
        if (this.telephone != other.telephone && (this.telephone == null || !this.telephone.equals(other.telephone))) {
            return false;
        }
        return true;
    }

    


}


