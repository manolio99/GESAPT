package com.miradorlacala.apt.beans;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ControlLanguagesBean {

	public void changeLanguage(String language) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
	}
	
}
