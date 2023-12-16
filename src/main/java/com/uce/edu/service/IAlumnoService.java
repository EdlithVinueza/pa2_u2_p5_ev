package com.uce.edu.service;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoService {
	
	public Alumno buscar(Integer id);

	public void guardar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void borrar(Integer id);

}
