package com.miradorlacala.apt.dao.jpa;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.miradorlacala.apt.bo.Categoria;
import com.miradorlacala.apt.dao.CategoriaDAO;

@Repository
public class CategoriaDAOJPAImpl extends GenericDAOJPAImpl2<Categoria, Integer> implements CategoriaDAO {
	private static final Logger log = Logger.getLogger(CategoriaDAOJPAImpl.class.getPackage().getName());
	
}
