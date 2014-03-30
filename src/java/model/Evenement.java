package model;
// Generated Mar 29, 2014 12:56:35 PM by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Evenement generated by hbm2java
 */
@Entity
@Table(name="evenement"
    ,schema="public"
)
public class Evenement  implements java.io.Serializable {


     private int idEvent;
     private String type;
     private String inscription;
     private Integer prix;
     private Date date;

    public Evenement() {
    }

	
    public Evenement(int idEvent) {
        this.idEvent = idEvent;
    }
    public Evenement(int idEvent, String type, String inscription, Integer prix, Date date) {
       this.idEvent = idEvent;
       this.type = type;
       this.inscription = inscription;
       this.prix = prix;
       this.date = date;
    }
   
     @Id @GeneratedValue

    
    @Column(name="id_event", unique=true, nullable=false)
    public int getIdEvent() {
        return this.idEvent;
    }
    
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    
    @Column(name="type", length=254)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    
    @Column(name="inscription", length=254)
    public String getInscription() {
        return this.inscription;
    }
    
    public void setInscription(String inscription) {
        this.inscription = inscription;
    }

    
    @Column(name="prix")
    public Integer getPrix() {
        return this.prix;
    }
    
    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date", length=13)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }




}


