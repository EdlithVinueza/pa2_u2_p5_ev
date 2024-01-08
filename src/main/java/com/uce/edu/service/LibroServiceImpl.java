package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;

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

}
