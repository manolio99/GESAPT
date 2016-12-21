package com.miradorlacala.apt.dao;

import java.util.List;

import com.miradorlacala.apt.bo.Categoria;

public interface CategoriaDAO {

	public abstract List<Categoria> buscarTodos();

	public abstract Categoria buscarPorClave(Integer id);
	
}
