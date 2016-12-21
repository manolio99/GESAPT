package com.miradorlacala.apt.beans;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.miradorlacala.apt.bo.Categoria;
import com.miradorlacala.apt.bo.Libro;
import com.miradorlacala.apt.servicios.ServicioLibros;

@ManagedBean
@SessionScoped
public class FormularioLibroManagedBean {
	private String isbn;
	private String titulo;
	private String categoria;
	private List<Categoria> listaDeCategorias;
	private List<Libro> listaDeLibros;

	@ManagedProperty("#{servicioLibros}")
	private ServicioLibros servicioLibros;

	@PostConstruct
	public void iniciar() {
		listaDeLibros = getServicioLibros().buscarTodosLosLibros();
		listaDeCategorias = getServicioLibros().buscarCategoriasLibros();
	}

	public void insertar(ActionEvent evento) {
		getServicioLibros().insertarLibro(new Libro(isbn, titulo, new Categoria(Integer.parseInt(categoria))));
		listaDeLibros = getServicioLibros().buscarTodosLosLibros();
		categoria = "0";
	}

	public void borrar(String isbn) {
		getServicioLibros().borrarLibro(new Libro(isbn));
		listaDeLibros = getServicioLibros().buscarTodosLosLibros();
	}

	public void filtrar(ValueChangeEvent evento) {
		int idCategoria = Integer.parseInt(evento.getComponent().getAttributes().get("value").toString());
		if (idCategoria != 0) {
			listaDeLibros = getServicioLibros().buscarLibrosPorCategoria(idCategoria);
		} else {
			listaDeLibros = getServicioLibros().buscarTodosLosLibros();
		}
	}

	public void editar(String isbn) {
		Libro libro = getServicioLibros().buscarLibroPorClave(isbn);
		isbn = libro.getIsbn();
		titulo = libro.getTitulo();
	}

	public void formularioInsertar(ActionEvent evento) {
		isbn = "";
		titulo = "";
	}

	public void salvar(ActionEvent evento) {
		getServicioLibros().salvarLibro(new Libro(isbn, titulo, new Categoria(Integer.parseInt(categoria))));
		listaDeLibros = getServicioLibros().buscarTodosLosLibros();
		categoria = "0";
	}

	// GETTERS Y SETTERS

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaDeCategorias() {
		return listaDeCategorias;
	}

	public void setListaDeCategorias(List<Categoria> listaDeCategorias) {
		this.listaDeCategorias = listaDeCategorias;
	}

	public List<Libro> getListaDeLibros() {
		return listaDeLibros;
	}

	public void setListaDeLibros(List<Libro> listaDeLibros) {
		this.listaDeLibros = listaDeLibros;
	}

	public ServicioLibros getServicioLibros() {
		return servicioLibros;
	}

	public void setServicioLibros(ServicioLibros servicioLibros) {
		this.servicioLibros = servicioLibros;
	}

}
