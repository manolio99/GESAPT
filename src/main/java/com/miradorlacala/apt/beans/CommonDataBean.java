package com.miradorlacala.apt.beans;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.miradorlacala.apt.servicios.ServiceCommon;

@ManagedBean
@SessionScoped
public class CommonDataBean {
	
	@ManagedProperty("#{serviceCommon}")
	private ServiceCommon serviceCommon;

	private Map<String, String> mapLanguages;
		
	@PostConstruct
	public void initialize() {
		loadMapLanguages();
	}

	private void loadMapLanguages() {
		mapLanguages = serviceCommon.getMapLanguages();
	}
	
	// GETTERS Y SETTERS
	
	public void setServiceCommon(ServiceCommon serviceCommon) {
		this.serviceCommon = serviceCommon;
	}

	public Map<String, String> getMapLanguages() {
		return mapLanguages;
	}
	
}
