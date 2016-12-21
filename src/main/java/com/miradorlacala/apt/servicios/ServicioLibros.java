package com.miradorlacala.apt.servicios;

import java.util.List;

import com.miradorlacala.apt.bo.Categoria;
import com.miradorlacala.apt.bo.Libro;

public interface ServicioLibros {
	public void insertarLibro(Libro libro);

	public void salvarLibro(Libro libro);

	public void borrarLibro(Libro libro);

	public List<Libro> buscarTodosLosLibros();

	public List<Categoria> buscarCategoriasLibros();

	public Libro buscarLibroPorClave(String isbn);

	public Categoria buscarCategoriaPorClave(int id);

	public List<Libro> buscarLibrosPorCategoria(int categoria);
}
