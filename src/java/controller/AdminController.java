package controller;

import entities.Admin;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import domaine.AdminFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "adminController")
@SessionScoped
public class AdminController implements Serializable {

    String username;
    String password;
    Admin loggedInAdmin;
    
    @EJB
    AdminFacade adminFacade;
    
    
    
    public String login(){
        loggedInAdmin = adminFacade.findLoginByUserNameAndPass(username, password);
        if(loggedInAdmin!=null){
             return "Stats.xhtml?faces-redirect=true";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid credentials"));
            return null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin getLoggedInAdmin() {
        return loggedInAdmin;
    }

    public void setLoggedInAdmin(Admin loggedInAdmin) {
        this.loggedInAdmin = loggedInAdmin;
    }

    public AdminFacade getAdminFacade() {
        return adminFacade;
    }

    public void setAdminFacade(AdminFacade adminFacade) {
        this.adminFacade = adminFacade;
    }

    
    

}
