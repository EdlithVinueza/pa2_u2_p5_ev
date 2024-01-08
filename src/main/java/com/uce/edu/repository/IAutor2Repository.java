package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Autor2;

public interface IAutor2Repository {

	public Autor2 seleccionar(Integer id);

	public void insertar(Autor2 autor2);

	public void actualizar(Autor2 autor2);

	public void eliminar(Integer id);

}
