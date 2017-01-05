package com.miradorlacala.apt.servicios.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.soap.SOAPException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.miradorlacala.apt.bo.Price;
import com.miradorlacala.apt.servicios.ServicePricesFromWeb;

@Service(value = "servicePricesFromWeb")
public class ServicePricesFromWebImpl implements ServicePricesFromWeb {

	private static final Logger log = Logger.getLogger(ServicePricesFromWebImpl.class);

	@Value("${url.apartmentManagement}")
	private String urlApartmentManagement;

	// TODO SACAR ESTO A UN SERVICIO WEB
	public List<Price> getPricesFromWeb() {
		List<Price> pricesFromWeb = new ArrayList<Price>();
		
		long timeRequest = new Date().getTime();

		String htmlView;
		try {
			htmlView = readURL(urlApartmentManagement, null, null);
			
			if (StringUtils.isEmpty(htmlView)) {
				htmlView = "<div style=\"margin: 0 auto; width: 600px\"><b>La web no esta disponible actualmente</b></div>";
			} else {
				log.info("EXTRAEMOS LA INFORMACION");
				htmlView = extractInfo(htmlView);
			}
			
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long timeResponse = new Date().getTime();
		log.info("TIEMPO PETICION [" + (timeResponse - timeRequest) + "]");

		Price price = new Price();
		pricesFromWeb.add(price);
		
		return pricesFromWeb;
	}

	private String readURL(String path, String warehouse, String language) throws SOAPException {
		Reader r = null;
		String htmlView = "";
		try {
			URL urlBase = new URL(path);

			URLConnection con = urlBase.openConnection();
			if (warehouse != null && language != null) {
				String myCookie = "shopId=" + warehouse + ";cookieLanguageHybris=" + language;
				con.setRequestProperty("Cookie", myCookie);
			}
			con.connect();
			Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
			Matcher m = p.matcher(con.getContentType());
			String charset = m.matches() ? m.group(1) : "UTF-8";
			r = new InputStreamReader(con.getInputStream(), charset);
			StringBuilder buf = new StringBuilder();
			while (true) {
				int ch = r.read();
				if (ch < 0) {
					break;
				}
				buf.append((char) ch);
			}

			htmlView = buf.toString();
		} catch (MalformedURLException e) {
			log.error("La URL es erronea", e);
			SOAPException exception = new SOAPException("La URL es erronea", e);
			throw exception;
		} catch (IOException e) {
			log.error("Excepcion E/S", e);
			return null;
		} catch (Exception e) {
			log.error("Excepcion generica", e);
			SOAPException exception = new SOAPException("Excepcion generica", e);
			throw exception;
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (IOException e) {
					log.error("Error al cerrar el recurso", e);
				}
			}
		}

		return htmlView;
	}

	private String extractInfo(String htmlView) {
		// PARSEAMOS
		Document doc = Jsoup.parse(htmlView);
		Elements prices = doc.select("#price");
		return prices.outerHtml();
	}

}
