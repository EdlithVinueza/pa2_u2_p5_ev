package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroRepository iLibroRepository;
	
	@Override
	public Libro buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionar(id);
	}

	
	@Override
	public void guardar(Libro libro) {
		// TODO Auto-generated method stub
		this.iLibroRepository.insertar(libro);

	}


	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.iLibroRepository.actualizar(libro);
		
	}


	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iLibroRepository.eliminar(id);
		
	}


	@Override
	public void guardar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.iLibroRepository.insertar(libro2);
	}


	@Override
	public Libro buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorNombre(nombre);
	}


	@Override
	public List<Libro> buscarPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorFechaPublicacion(fecha);
	}


	@Override
	public Libro buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorTitulo(titulo);
	}


	@Override
	public List<Libro> buscarPorFechaPubli(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorFecha(fecha);
	}


	@Override
	public Libro buscarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorTituloNamed(titulo);
	}


	@Override
	public List<Libro> bucarPorFechaNamed(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorFechaNamed(fechaPublicacion);
	}


	@Override
	public Libro seleccioanrPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccioanrPorTitulo(titulo);
	}

	@Override
	public List<Libro> buscarLibroPorPalabraClave(String palabraClave) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarLibroPorPalabraClave(palabraClave);
	}


	@Override
	public List<Libro> buscarLibrosProgramacionPorAño(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarLibrosProgramacionPorAño(fecha);
	}


	
}
