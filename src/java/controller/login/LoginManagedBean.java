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

/**
 *
 * @author hp
 */
@ManagedBean
@SessionScoped
public class LoginManagedBean implements Serializable{
    
    private Utilisateur utilisateur;
    private final UtilisateurInterface ui;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
    

    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
        this.ui = new UtilisateurImpl();
        
        if(this.utilisateur == null)
        {
            this.utilisateur = new Utilisateur();
        }
      
    }
    
    public void login(ActionEvent actionEvent) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg;
		boolean loggedIn;
                String path = "";
               
                this.utilisateur = this.ui.login(this.utilisateur);//tuto part 3 12:59
		
		if(this.utilisateur != null) {
			loggedIn = true;
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("hey", this.utilisateur.getNom());
			msg = new FacesMessage("Welcome  "+this.utilisateur.getNom());
		        path = "/PostgresEssail/faces/indexUtilisateur.xhtml";
                } else {
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "User or password are incorrect");
                        if(this.utilisateur == null)
                        {
                            this.utilisateur = new Utilisateur();
                        }
		}
                
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		context.addCallbackParam("loggedIn", loggedIn);
                context.addCallbackParam("ruta", path);
	}
    
    
     public void logout()
    {
        String path ="/PostgresEssail/faces/login.xhtml";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        httpSession.invalidate();
        context.addCallbackParam("loggetOut", true);
        context.addCallbackParam("ruta", path);
        
        
    }
    
   public String indexUtilisateur() {
        return "indexUtilisateur";
    }
    
}
