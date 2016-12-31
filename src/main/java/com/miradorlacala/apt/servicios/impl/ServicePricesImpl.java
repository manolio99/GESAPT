package com.miradorlacala.apt.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miradorlacala.apt.bo.Price;
import com.miradorlacala.apt.dao.PricesDAO;
import com.miradorlacala.apt.servicios.ServicePrices;

@Service(value = "servicePrices")
public class ServicePricesImpl implements ServicePrices {
	private PricesDAO pricesDAO = null;

	@Transactional
	public List<Price> searchAll() {
		return pricesDAO.searchAll();
	}

	// GETTERS Y SETTERS

	public PricesDAO getPricesDAO() {
		return pricesDAO;
	}

	@Autowired
	public void setPricesDAO(PricesDAO pricesDAO) {
		this.pricesDAO = pricesDAO;
	}

}
