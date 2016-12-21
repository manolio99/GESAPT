package com.miradorlacala.apt.serviciosexternos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miradorlacala.apt.bo.Libro;
import com.miradorlacala.apt.servicios.ServicioLibros;
import com.miradorlacala.apt.serviciosexternos.LibroDTO;
import com.miradorlacala.apt.serviciosexternos.ServicioInformacionLibros;

@Service
@WebService(endpointInterface = "com.miradorlacala.apt.serviciosexternos.ServicioInformacionLibros")
public class ServicioInformacionLibrosCXF implements ServicioInformacionLibros {
	@Autowired
	private ServicioLibros servicioLibros;

	@WebMethod
	public List<LibroDTO> listaInformacionLibros() {
		List<Libro> listaLibros = servicioLibros.buscarTodosLosLibros();
		List<LibroDTO> listaDestino = new ArrayList<LibroDTO>();
		for (Libro libro : listaLibros) {
			LibroDTO libroExterno = new LibroDTO(libro.getIsbn(), libro.getTitulo(),
					libro.getCategoria().getDescripcion());
			listaDestino.add(libroExterno);
		}
		return listaDestino;
	}

}
