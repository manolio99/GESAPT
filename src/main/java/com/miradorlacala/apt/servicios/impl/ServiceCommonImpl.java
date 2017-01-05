package com.miradorlacala.apt.servicios.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miradorlacala.apt.dao.LanguagesDAO;
import com.miradorlacala.apt.servicios.ServiceCommon;

@Service(value = "serviceCommon")
public class ServiceCommonImpl implements ServiceCommon {

	private LanguagesDAO languagesDAO = null;

	@Value("#{T(com.miradorlacala.apt.util.ConfigurationReader).propsToMap(gesaptProperties, '^(testPropertiesToMap.*)', 'testPropertiesToMap.')}")
	private Map<String, String> configurationTest;

	@Transactional
	public Map<String, String> getMapLanguages() {
		return languagesDAO.getMapLanguages();
	}

	// GETTERS Y SETTERS

	public LanguagesDAO getLanguagesDAO() {
		return languagesDAO;
	}

	@Autowired
	public void setLanguagesDAO(LanguagesDAO languagesDAO) {
		this.languagesDAO = languagesDAO;
	}

	public Map<String, String> getConfigurationTest() {
		return configurationTest;
	}

	public void setConfigurationTest(Map<String, String> configurationTest) {
		this.configurationTest = configurationTest;
	}

}
