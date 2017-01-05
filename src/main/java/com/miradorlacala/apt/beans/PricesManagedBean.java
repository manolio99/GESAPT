package com.miradorlacala.apt.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.util.StringUtils;

import com.miradorlacala.apt.bo.Price;
import com.miradorlacala.apt.bo.Request;
import com.miradorlacala.apt.servicios.ServicePrices;
import com.miradorlacala.apt.servicios.ServicePricesFromWeb;
import com.miradorlacala.apt.util.JsfUtils;

@ManagedBean
@ViewScoped
public class PricesManagedBean {

	private static final String PREFIX_LANGUAGE = "language.";

	private List<Price> prices;

	@ManagedProperty("#{commonDataBean}")
	private CommonDataBean cdb;
	
	@ManagedProperty("#{servicePrices}")
	private ServicePrices servicePrices;
	
	@ManagedProperty("#{servicePricesFromWeb}")
	private ServicePricesFromWeb servicePricesFromWeb;

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
		loadDescLanguagesFromPropertyFile(mapLanguages);
	}

	private void loadDescLanguagesFromPropertyFile(Map<String, String> languages) {
		for (Map.Entry<String, String> lang : languages.entrySet()) {
			String descLang = JsfUtils.getMessageResourceString(PREFIX_LANGUAGE + lang.getKey());
			if (!StringUtils.isEmpty(descLang)) {
				lang.setValue(descLang);
			}
		}
	}

	private void loadPrices() {
		prices = servicePrices.searchAll();
		extractInfoModificationDate(prices);
		extractInfoOfferMsg(prices);
	}

	private void extractInfoModificationDate(List<Price> prices2) {
		modificationDate = JsfUtils.getMessageResourceString("prices.modificationDate", new Object[] { "01/01/2016" });
	}

	private void extractInfoOfferMsg(List<Price> prices2) {
		offerMsg = JsfUtils.getMessageResourceString("prices.offer.msg",
				new Object[] { "01/01/2016", "01/01/2017", "300" });
	}

	private void loadRequest() {
		request = new Request();
	}

	private void loadEmail() {
		email = null;
	}

	public void updatePrices() {
		// call the service that retrieve data from the website
		prices = servicePricesFromWeb.getPricesFromWeb();
		
		// TODO guardar en bbdd
		
		// loadPrices();
	}

	public void searchAvailability() {
		// TODO construir email
		email = email + "s";
	}

	// GETTERS Y SETTERS

	public List<Price> getPrices() {
		return prices;
	}

	public void setCdb(CommonDataBean cdb) {
		this.cdb = cdb;
	}
	
	public void setServicePrices(ServicePrices servicePrices) {
		this.servicePrices = servicePrices;
	}
	
	public void setServicePricesFromWeb(ServicePricesFromWeb servicePricesFromWeb) {
		this.servicePricesFromWeb = servicePricesFromWeb;
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
