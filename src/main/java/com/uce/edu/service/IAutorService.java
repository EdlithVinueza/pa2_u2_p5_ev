package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {
	
	public Autor2 buscar(Integer id);
	public void guardar(Autor2 autor2);
	public void actualizar(Autor2 autor2);
	public void borrar(Integer id);
	
	public List<Autor> buscarPorNacionalidad(String nacionaliad);
	public Autor buscarPorNombre(String nombre);
	public List<Libro> buscarLibroPorAutor(String nombreAutor);
	
	public List<Libro> buscarLibrosPorAutor(String nombreAutor);
	
}
