package com.miradorlacala.apt.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miradorlacala.apt.HibernateHelper;
import com.miradorlacala.apt.bo.Categoria;
import com.miradorlacala.apt.bo.Libro;
import com.miradorlacala.apt.dao.LibroDAO;

public class LibroDAOHibernateImpl implements LibroDAO {
	private static final Logger log = Logger.getLogger(LibroDAOHibernateImpl.class.getPackage().getName());

	public void insertar(Libro libro) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.save(libro);
		session.getTransaction().commit();
	}

	public void borrar(Libro libro) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(libro);
		session.getTransaction().commit();
	}

	public void salvar(Libro libro) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(libro);
		session.getTransaction().commit();
	}

	public List<Libro> buscarTodos() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<Libro> listaDeLibros = session.createQuery(" from Libro libro right join fetch libro.categoria").list();
		session.close();
		return listaDeLibros;
	}

	public Libro buscarPorClave(String isbn) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Libro libro = (Libro) session.get(Libro.class, isbn);
		session.close();
		return libro;
	}

	public List<Libro> buscarPorCategoria(Categoria categoria) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Query consulta = session.createQuery(" from Libro libro where libro.categoria=:categoria");
		consulta.setString("categoria", Integer.toString(categoria.getId()));
		List<Libro> listaDeLibros = consulta.list();
		session.close();
		return listaDeLibros;
	}

}