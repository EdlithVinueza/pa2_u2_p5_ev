package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
@Service
public class ICiudadanoServiceImpl implements ICiudadanoService {
	
	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;

	@Override
	public void guardar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.insertar(ciudadano);

	}

	@Override
	public Ciudadano selecionar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.selecionar(id);
	}

}
