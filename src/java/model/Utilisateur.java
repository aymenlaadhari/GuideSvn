package model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="utilisateur"
    ,schema="public"
)
public class Utilisateur implements java.io.Serializable {


     private int idUser; 
     private String nom;
     private String prenom;
     private String adresse;
     private String email;
     private String password;
     private String login;
     private String telephone;
     private String sexe;
     private String passCrypt; 
     MessageDigest md;

    public Utilisateur() {
    }


    public Utilisateur(int idUser) {
        this.idUser = idUser;
    }
    public Utilisateur(int idUser, String nom, String prenom,String sexe, String adresse, String email, String password, String login, String telephone) {
       this.idUser = idUser;
       this.nom = nom;
       this.prenom = prenom;
       this.adresse = adresse;
       this.email = email;
       this.password = password;
       this.login = login;
       this.telephone = telephone;
       this.sexe=sexe;
    }
    
     @Id 
    @Column(name="idUser", unique=true, nullable=false)
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    
    @Column(name="nom", length=258)
     //@NotNull(message = "Nom requis")
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="prenom", length=258)
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    @Column(name="adresse", length=258)
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
    @Column(name="email", length=258)

        public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="sexe", length=258)
    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

            
    @Column(name="password", length=258)
//    @NotNull(message = "Mot de passe requis")
//    @Size(min = 4, max = 25, message = "Mot de passe doit étre en 4 et 25 caractéres")
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="login", length=258)
//     @NotNull(message = "Login requis")
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="telephone", length=258)
    //@NotNull(message = "Telephone requis")
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassCrypt() throws NoSuchAlgorithmException
    {
        
  md = MessageDigest.getInstance("MD5");
  md.update(password.getBytes());
  byte[] digest = md.digest();
  StringBuilder sb = new StringBuilder();
  for (byte b : digest) 
  {
   sb.append(String.format("%02x", b & 0xff));
  }
                passCrypt = sb.toString();
         
                return passCrypt;
    }

    public void setPassCrypt(String passCrypt) {
        this.passCrypt = passCrypt;
    }




}

