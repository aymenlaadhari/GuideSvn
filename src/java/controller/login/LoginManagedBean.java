/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import dao.utilisateur.UtilisateurImpl;
import dao.utilisateur.UtilisateurInterface;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Utilisateur;
import org.primefaces.context.RequestContext;

@ManagedBean (name="LoginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private Utilisateur utilisateur;
    private final UtilisateurInterface ui;
    
    public Utilisateur getUtilisateur() 
    {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) 
    {
        this.utilisateur = utilisateur;
    }

    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() 
    {
        this.ui = new UtilisateurImpl();

        if (this.utilisateur == null) {
            this.utilisateur = new Utilisateur();
        }

    }

    public void login(ActionEvent actionEvent)
    {

        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg ;  
        boolean loggedIn ; 
       
        String url = "";

        this.utilisateur = this.ui.login(this.utilisateur);

        if (this.utilisateur != null) {
           
            loggedIn = true;  
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Utilisateur",this.utilisateur.getNom());
          //  msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenue", this.utilisateur.getNom());
            url = "/faces/Views/Acceuil.xhtml";
        } else {
            loggedIn = false;             
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Authentification  Erronée", "Identifiant ou mot de passe incorrect!!!");
             this.utilisateur = new Utilisateur();

        }
    
     //FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("maha", url);
    }

    public void logout() 
    {
       
    RequestContext context = RequestContext.getCurrentInstance();
    String url = "/faces/Views/login.xhtml"; 
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
    httpSession.invalidate();
    context.addCallbackParam("loggetOut", true);
    context.addCallbackParam("aymen", url);
        
    }
    

    

}
