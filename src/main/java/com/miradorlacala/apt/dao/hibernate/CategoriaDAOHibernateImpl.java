package com.miradorlacala.apt.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miradorlacala.apt.HibernateHelper;
import com.miradorlacala.apt.bo.Categoria;
import com.miradorlacala.apt.dao.CategoriaDAO;

public class CategoriaDAOHibernateImpl implements CategoriaDAO {

	public List<Categoria> buscarTodos() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<Categoria> listaDeCategorias = session.createQuery(" from Categoria categoria").list();
		return listaDeCategorias;
	}
	
	public Categoria buscarPorClave(Integer id) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Query consulta = session.createQuery(" from Categoria c where c.id=:categoria");
		consulta.setString("categoria", Integer.toString(id));
		Categoria categoria = (Categoria) consulta.uniqueResult();
		return categoria;
	}
}
