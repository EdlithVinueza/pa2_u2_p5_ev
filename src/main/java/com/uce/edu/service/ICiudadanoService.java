package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {

	public Ciudadano buscar(Integer id);

	public void guardar(Ciudadano ciudadano);

	public void actualizar(Ciudadano ciudadano);

	public void borrar(Integer id);
	
	public Empleado buscarPorCedula(String cedula);
	
	public Ciudadano buscarPorCedulaCiudadano(String cedula);

}
