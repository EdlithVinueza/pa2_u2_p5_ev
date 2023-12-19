package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoService {
	
	public void guardar(Ciudadano ciudadano);
	
	public Ciudadano selecionar(Integer id);

}
