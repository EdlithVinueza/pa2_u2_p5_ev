package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {

	public Ciudadano seleccionar(Integer id);

	public void insertar(Ciudadano ciudadano);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);

}
