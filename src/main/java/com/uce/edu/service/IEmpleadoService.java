package com.uce.edu.service;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {

	public Empleado buscar(Integer id);

	public void guardar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void borrar(Integer id);

}
