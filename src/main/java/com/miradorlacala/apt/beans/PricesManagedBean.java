package com.miradorlacala.apt.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.miradorlacala.apt.bo.Price;
import com.miradorlacala.apt.bo.Request;
import com.miradorlacala.apt.servicios.ServicePrices;
import com.miradorlacala.apt.util.Utils;

@ManagedBean
@ViewScoped
public class PricesManagedBean {
	private List<Price> prices;

	@ManagedProperty("#{servicePrices}")
	private ServicePrices servicePrices;
	
	@ManagedProperty("#{commonDataBean}")
	private CommonDataBean cdb;

	private String modificationDate;

	private String offerMsg;

	private Request request;
	
	private String email;
	
	private Map<String, String> mapLanguages;
	
	@PostConstruct
	public void initialize() {
		loadMapLanguages();
		loadPrices();
		loadRequest();
		loadEmail();
	}

	private void loadMapLanguages() {
		mapLanguages = cdb.getMapLanguages();
	}

	private void loadPrices() {
		prices = servicePrices.searchAll();
		extractInfoModificationDate(prices);
		extractInfoOfferMsg(prices);
	}

	private void extractInfoModificationDate(List<Price> prices2) {
		modificationDate = Utils.getMessageResourceString("prices.modificationDate", new Object[] { "01/01/2016" });		
	}

	private void extractInfoOfferMsg(List<Price> prices2) {
		offerMsg = Utils.getMessageResourceString("prices.offer.msg",
				new Object[] { "01/01/2016", "01/01/2017", "300" });
	}
	
	private void loadRequest() {
		request = new Request();
	}
	
	private void loadEmail() {
		email = null;
	}
	
	public void updatePrices() {
		// TODO llamar al servicio que recupera los datos de la web rentalia 
		// TODO guardar en bbdd 
		loadPrices();
	}
	
	public void searchAvailability() {
		// TODO construir email
		email = email + "s";
	}
	
	// GETTERS Y SETTERS

	public List<Price> getPrices() {
		return prices;
	}

	public void setServicePrices(ServicePrices servicePrices) {
		this.servicePrices = servicePrices;
	}
	
	public void setCdb(CommonDataBean cdb) {
		this.cdb = cdb;
	}

	public String getModificationDate() {
		return modificationDate;
	}

	public String getOfferMsg() {
		return offerMsg;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getEmail() {
		return email;
	}

	public Map<String, String> getMapLanguages() {
		return mapLanguages;
	}

	public void setMapLanguages(Map<String, String> mapLanguages) {
		this.mapLanguages = mapLanguages;
	}
	
}
