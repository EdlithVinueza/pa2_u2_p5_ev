package com.uce.edu.service;

import com.uce.edu.repository.modelo.Autor2;

public interface IAutor2Service {
	
	public Autor2 buscar(Integer id);
	public void guardar(Autor2 autor2);
	public void actualizar(Autor2 autor2);
	public void borrar(Integer id);

}
