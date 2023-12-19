package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {
	
	public void insertar(Ciudadano ciudadano);
	
	public Ciudadano selecionar(Integer id);

}
