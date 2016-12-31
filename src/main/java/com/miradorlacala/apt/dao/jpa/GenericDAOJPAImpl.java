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
	private Class<T> persistenceClass;

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl() {
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public T searchById(Id id) {
		return getManager().find(persistenceClass, id);
	}

	@Transactional(readOnly = true)
	public List<T> searchAll() {
		List<T> allObjects = null;
		TypedQuery<T> query = manager.createQuery("select o from " + persistenceClass.getSimpleName() + " o",
				persistenceClass);
		allObjects = query.getResultList();
		return allObjects;
	}

	@Transactional
	public void delete(T objet) {
		getManager().remove(getManager().merge(objet));
	}

	@Transactional
	public void save(T objet) {
		getManager().merge(objet);
	}

	@Transactional
	public void insert(T objet) {
		getManager().persist(objet);
	}
	
	// GETTERS Y SETTERS

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
}
