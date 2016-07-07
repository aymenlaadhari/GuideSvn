package model;
// Generated Apr 2, 2014 11:37:33 AM by Hibernate Tools 3.6.0


import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="specialite"
    ,schema="public"
)
public class Specialite  implements java.io.Serializable {


     private int idSpec;
     private String nom;
     private String description;
//     private Set<Restaurant> restaurant; 
//   
    public Specialite() {
    }

	
    public Specialite(int idSpec) {
        this.idSpec = idSpec;
    }
    public Specialite(int idSpec,String nom, String description) {
       this.idSpec = idSpec;
       this.nom = nom;
       this.description = description;
      
    }
   
     @Id 

    
    @Column(name="idSpec", unique=true, nullable=false)
   public int getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(int idSpec) {
        this.idSpec = idSpec;
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

//     @OneToMany(mappedBy = "restaurant")  
//    public Set<Restaurant> getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Set<Restaurant> restaurant) {
//        this.restaurant = restaurant;
//    }
    
    
//     @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 31 * hash + this.idSpec;
//        hash = 31 * hash + (this.nom != null ? this.nom.hashCode() : 0);
//       hash = 31 * hash + (this.description != null ? this.description.hashCode() : 0);
//     //   hash = 31 * hash + (this.ville != null ? this.ville.hashCode() : 0);
//        return hash;
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
//        final Specialite other = (Specialite) obj;
//        if (this.idSpec != other.idSpec) {
//            return false;
//        }
//        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
//            return false;
//        }
//        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
//            return false;
//        }
//      //  if (this.ville != other.ville && (this.ville == null || !this.ville.equals(other.ville))) {
//       //     return false;
//      //  }
//        return true;
//    }

  }


