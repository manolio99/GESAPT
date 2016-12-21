package com.miradorlacala.apt.serviciosexternos;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ServicioInformacionLibros {

	@WebMethod
	public List<LibroDTO> listaInformacionLibros();

}
