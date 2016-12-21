package com.miradorlacala.apt.serviciosexternos;

public class LibroDTO {
	private String isbn;
	private String titulo;
	private String categoria;

	public LibroDTO() {
	}

	public LibroDTO(String isbn, String titulo, String categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
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

}
