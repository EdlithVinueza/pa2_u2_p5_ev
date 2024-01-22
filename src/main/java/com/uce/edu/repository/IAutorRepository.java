package com.uce.edu.repository;

import java.util.List;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Autor2;

public interface IAutorRepository {
	
	public Autor2 seleccionar(Integer id);
	public void insertar(Autor2 autor2);
	public void actualizar(Autor2 autor2);
	public void eliminar(Integer id);
	public List<Autor> seleccionarPorNacionalidad(String nacionaliad);
	public Autor seleccionarPorNombre(String nombre);
	public List<Libro> seleccionarLibroPorAutor(String nombreAutor);
}
