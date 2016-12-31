package com.miradorlacala.apt.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, Id extends Serializable> {

	public T searchById(Id id);

	public List<T> searchAll();

	public void save(T objeto);

	public void delete(T objeto);
	
	public void insert(T objeto);

}