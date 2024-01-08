package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibro2Repository;
import com.uce.edu.repository.modelo.Libro2;

@Service
public class Libro2ServiceImpl implements ILibro2Service {

	@Autowired
	private ILibro2Repository iLibro2Repository;
	
	@Override
	public Libro2 buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iLibro2Repository.seleccionar(id);
	}

	
	@Override
	public void guardar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.iLibro2Repository.insertar(libro2);

	}


	@Override
	public void actualizar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.iLibro2Repository.actualizar(libro2);
		
	}


	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iLibro2Repository.eliminar(id);
		
	}

}
