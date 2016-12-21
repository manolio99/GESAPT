package com.miradorlacala.apt.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miradorlacala.apt.dao.GenericDAO;

@Repository
public abstract class GenericDAOJPAImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {
	private Class<T> claseDePersistencia;

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl() {
		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public T buscarPorClave(Id id) {
		return getManager().find(claseDePersistencia, id);
	}

	@Transactional(readOnly = true)
	public List<T> buscarTodos() {
		List<T> listaDeObjetos = null;
		TypedQuery<T> consulta = manager.createQuery("select o from " + claseDePersistencia.getSimpleName() + " o",
				claseDePersistencia);
		listaDeObjetos = consulta.getResultList();
		return listaDeObjetos;
	}

	@Transactional
	public void borrar(T objeto) {
		getManager().remove(getManager().merge(objeto));
	}

	@Transactional
	public void salvar(T objeto) {
		getManager().merge(objeto);
	}

	@Transactional
	public void insertar(T objeto) {
		getManager().persist(objeto);
	}

	// GETTERS Y SETTERS

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
}
