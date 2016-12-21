package com.miradorlacala.apt.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miradorlacala.apt.bo.Categoria;
import com.miradorlacala.apt.bo.Libro;
import com.miradorlacala.apt.dao.LibroDAO;

@Repository
public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, String> implements LibroDAO {
	private static final Logger log = Logger.getLogger(LibroDAOJPAImpl.class.getPackage().getName());

	@Transactional(readOnly = true)
	public List<Libro> buscarPorCategoria(Categoria categoria) {
		TypedQuery<Libro> consulta = getManager()
				.createQuery("Select l from Libro l JOIN FETCH l.categoria where l.categoria=?1", Libro.class);
		consulta.setParameter(1, categoria);
		return consulta.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Libro> buscarTodos() {
		TypedQuery<Libro> consulta = getManager().createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria",
				Libro.class);
		return consulta.getResultList();
	}

}