package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {

	public Ciudadano seleccionar(Integer id);

	public void insertar(Ciudadano ciudadano);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);
	
	public Empleado seleccionarPorCedula(String cedula);
	
	public Ciudadano seleccionarPorCedulaCiudadano(String cedula);
	
	public Ciudadano seleccionarPorNacionaliad(String nacionalidad);

}
