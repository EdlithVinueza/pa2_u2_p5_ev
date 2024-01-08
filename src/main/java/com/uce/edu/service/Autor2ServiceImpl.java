package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAutor2Repository;
import com.uce.edu.repository.modelo.Autor2;
@Service
public class Autor2ServiceImpl implements IAutor2Service{
	@Autowired
	private IAutor2Repository autor2Repository;

	@Override
	public Autor2 buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.autor2Repository.seleccionar(id);
	}

	@Override
	public void guardar(Autor2 autor2) {
		// TODO Auto-generated method stub
		this.autor2Repository.insertar(autor2);
		
	}

	@Override
	public void actualizar(Autor2 autor2) {
		// TODO Auto-generated method stub
		this.autor2Repository.actualizar(autor2);
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.autor2Repository.eliminar(id);
		
	}

}
