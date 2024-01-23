package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAutorRepository;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.Libro;
@Service
public class AutorServiceImpl implements IAutorService{
	@Autowired
	private IAutorRepository autorRepository;

	@Override
	public Autor2 buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionar(id);
	}

	@Override
	public void guardar(Autor2 autor2) {
		// TODO Auto-generated method stub
		this.autorRepository.insertar(autor2);
		
	}

	@Override
	public void actualizar(Autor2 autor2) {
		// TODO Auto-generated method stub
		this.autorRepository.actualizar(autor2);
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.autorRepository.eliminar(id);
		
	}

	@Override
	public List<Autor> buscarPorNacionalidad(String nacionaliad) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorNacionalidad(nacionaliad);
	}

	@Override
	public Autor buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorNombre(nombre);
	}

	@Override
	public List<Libro> buscarLibroPorAutor(String nombreAutor) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibroPorAutor(nombreAutor);
	}

	@Override
	public List<Libro> buscarLibrosPorAutor(String nombreAutor) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosPorAutor(nombreAutor);
	}

}
