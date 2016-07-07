package model;
// Generated Apr 2, 2014 11:37:33 AM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "centre_commercial", schema = "public"
)
public class CentreCommercial implements java.io.Serializable {

    private int idCC;
    private String telephone;
    private String email;
    private String nom;
    private String description;
    private String siteweb;
    private Double longitude;
    private Double latitude;
    private String type;
    private String image;
    
    private boolean validation;
    private boolean archive;
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

    public CentreCommercial() {
    }
     public CentreCommercial(String type,int idCC) {
         this.idCC=idCC;
         this.type=type;
    }


    public CentreCommercial(int idCC) {
        this.idCC = idCC;
    }

    public CentreCommercial(int idCC, String image, Ville ville,String telephone, String email, String nom, String description, String siteweb, Double longitude, Double latitude) {
        this.idCC = idCC;
        this.image = image;
        this.telephone = telephone;
        this.email = email;
        this.nom = nom;
        this.description = description;
        this.siteweb = siteweb;
        this.longitude = longitude;
        this.latitude = latitude;
        this.idVille = ville;
    }

    @Id

    @Column(name = "idCC", unique = true, nullable = false)
    public int getIdCC() {
        return this.idCC;
    }

    public void setIdCC(int idCC) {
        this.idCC = idCC;
    }

    @Column(name = "telephone", length = 258)
    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "email", length = 258)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "nom", length = 258)
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "description", length = 1000)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "siteweb", length = 258)
    public String getSiteweb() {
        return this.siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    @Column(name = "longitude")
    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Column(name = "latitude")
    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "type", length = 258)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "image", length = 258)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "validation")
    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    @Column(name = "archive")
    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.nom != null ? this.nom.hashCode() : 0);
        hash = 17 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 17 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 17 * hash + (this.telephone != null ? this.telephone.hashCode() : 0);
          hash = 17 * hash + (this.type != null ? this.type.hashCode() : 0);
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
        final CentreCommercial other = (CentreCommercial) obj;
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
        if (this.type != other.type && (this.type == null || !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

}
