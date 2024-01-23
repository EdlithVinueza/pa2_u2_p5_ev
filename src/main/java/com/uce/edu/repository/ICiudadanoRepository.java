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
	
	public Ciudadano seleccionarPorApellido(String apellido);
	
	//Funcionaliad que cuando sea el ciudadado de pichinca lo busque por nombre,
	//cuando sea de copopaxi, lo busque por apellido
	//cuando no sea ni de cotopaxi ni pichinca lo busque por cedula 
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);
	
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);

}
