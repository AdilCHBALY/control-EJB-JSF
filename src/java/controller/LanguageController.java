/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author adil-
 */
@ManagedBean(name = "languageController")
@RequestScoped
public class LanguageController {
    
    public void changeLanguage(String selectedL){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(selectedL));
    }
    
}
