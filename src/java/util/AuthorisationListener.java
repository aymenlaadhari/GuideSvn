/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class AuthorisationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext faceContext = event.getFacesContext();
        String currentPage = faceContext.getViewRoot().getViewId();
        boolean isLoginPage = (currentPage.indexOf("login.xhtml") > -1);
        HttpSession session = (HttpSession) faceContext.getExternalContext().getSession(true);
        Object utilisateur = session.getAttribute("Utilisateur");
        if (!isLoginPage && utilisateur == null) {
            NavigationHandler nh = faceContext.getApplication().getNavigationHandler();
            nh.handleNavigation(faceContext, null, "/Views/login.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
