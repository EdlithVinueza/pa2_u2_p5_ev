package com.uce.edu.service;

import com.uce.edu.repository.modelo.Libro2;

public interface ILibro2Service {
	
	
	public Libro2 buscar(Integer id);

	public void guardar(Libro2 libro2);
	
	public void actualizar(Libro2 libro2);
	
	public void borrar(Integer id);
}
