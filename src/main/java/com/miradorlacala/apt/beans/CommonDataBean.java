package com.miradorlacala.apt.beans;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CommonDataBean {
	
//	@ManagedProperty("#{serviceCommon}")
//	private ServicePrices serviceCommon;

	private Map<String, String> mapLanguages;
	
	@PostConstruct
	public void initialize() {
		loadMapLanguages();
	}

	private void loadMapLanguages() {
		// TODO recuperar de messages properties y segun idioma
		mapLanguages = new LinkedHashMap<String, String>();
		mapLanguages.put("es", "Espa�ol");
		mapLanguages.put("en", "Ingl�s");
		mapLanguages.put("fr", "Franc�s");
	}
	
	// GETTERS Y SETTERS

	public Map<String, String> getMapLanguages() {
		return mapLanguages;
	}

	public void setMapLanguages(Map<String, String> mapLanguages) {
		this.mapLanguages = mapLanguages;
	}
	
}
