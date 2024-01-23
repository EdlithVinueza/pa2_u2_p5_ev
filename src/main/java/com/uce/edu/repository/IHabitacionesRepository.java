package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacionesRepository {

	public Habitacion seleccionar(Integer id);

	public void insertar(Habitacion habitacion);

	public void actualizar(Habitacion habitacion);

	public void eliminar(Integer id);
	
	public List<Habitacion> seleccionarPorClase (String tipoClase);
	

}
