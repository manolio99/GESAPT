package com.miradorlacala.apt.dao.jpa;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.miradorlacala.apt.bo.Language;
import com.miradorlacala.apt.dao.LanguagesDAO;

@Repository
public class LanguagesDAOJPAImpl extends GenericDAOJPAImpl<Language, String> implements LanguagesDAO {
	private static final Logger log = Logger.getLogger(LanguagesDAOJPAImpl.class);

	public Map<String, String> getMapLanguages() {
		// TODO hacer esto por aspectos (pensar si hacer esto en los DAOs o en Servicios)
		log.debug("GESAPT - LanguagesDAOJPAImpl.getMapLanguages() - INI");
		
		Map<String, String> mapLanguages = new LinkedHashMap<String, String>();
		
		List<Language> listLanguages = this.searchAll();
		for (Language lang : listLanguages) {
			mapLanguages.put(lang.getIdLanguage(), lang.getDescLanguage());
		}
		
		log.debug("GESAPT - LanguagesDAOJPAImpl.getMapLanguages() - END");		
		return mapLanguages;
	}
	
}
