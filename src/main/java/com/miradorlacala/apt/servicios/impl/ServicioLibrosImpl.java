package com.miradorlacala.apt.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miradorlacala.apt.bo.Categoria;
import com.miradorlacala.apt.bo.Libro;
import com.miradorlacala.apt.dao.CategoriaDAO;
import com.miradorlacala.apt.dao.LibroDAO;
import com.miradorlacala.apt.servicios.ServicioLibros;

@Service(value = "servicioLibros")
public class ServicioLibrosImpl implements ServicioLibros {
	private LibroDAO libroDAO = null;
	private CategoriaDAO categoriaDAO = null;

	@Transactional
	public void insertarLibro(Libro libro) {
		libroDAO.insertar(libro);
	}

	@Transactional
	public void salvarLibro(Libro libro) {
		libroDAO.salvar(libro);
	}

	@Transactional
	public void borrarLibro(Libro libro) {
		libroDAO.borrar(libro);
	}

	@Transactional
	public List<Libro> buscarTodosLosLibros() {
		return libroDAO.buscarTodos();
	}

	@Transactional
	public List<Categoria> buscarCategoriasLibros() {
		return categoriaDAO.buscarTodos();
	}

	@Transactional
	public Libro buscarLibroPorClave(String isbn) {
		return libroDAO.buscarPorClave(isbn);
	}

	@Transactional
	public Categoria buscarCategoriaPorClave(int id) {
		return categoriaDAO.buscarPorClave(id);
	}

	@Transactional
	public List<Libro> buscarLibrosPorCategoria(int id) {
		Categoria categoria = categoriaDAO.buscarPorClave(id);
		return libroDAO.buscarPorCategoria(categoria);
	}

	// GETTERS Y SETTERS

	public LibroDAO getLibroDAO() {
		return libroDAO;
	}

	@Autowired
	public void setLibroDAO(LibroDAO libroDAO) {
		this.libroDAO = libroDAO;
	}

	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}

	@Autowired
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

}
