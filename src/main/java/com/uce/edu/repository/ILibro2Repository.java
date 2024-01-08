package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro2;

public interface ILibro2Repository {
	
	public Libro2 seleccionar(Integer id);
	public void insertar(Libro2 libro2);
	public void actualizar(Libro2 libro2);
	public void eliminar(Integer id);
	

}
