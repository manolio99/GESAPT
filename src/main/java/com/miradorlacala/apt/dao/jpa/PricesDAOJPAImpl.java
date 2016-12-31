package com.miradorlacala.apt.dao.jpa;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.miradorlacala.apt.bo.Price;
import com.miradorlacala.apt.dao.PricesDAO;

@Repository
public class PricesDAOJPAImpl extends GenericDAOJPAImpl<Price, Integer> implements PricesDAO {
	private static final Logger log = Logger.getLogger(PricesDAOJPAImpl.class.getPackage().getName());

}
