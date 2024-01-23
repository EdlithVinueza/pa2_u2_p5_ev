package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;

	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionar(id);
	}

	@Override
	public void guardar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.insertar(ciudadano);

	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.actualizar(ciudadano);

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.eliminar(id);

	}

	@Override
	public Empleado buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public Ciudadano buscarPorCedulaCiudadano(String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedulaCiudadano(cedula);
	}

	@Override
	public Ciudadano buscarPorNacionaliad(String nacionalidad) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorNacionaliad(nacionalidad);
	}

	@Override
	public Ciudadano buscarPorApellido(String apellidos) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorApellido(apellidos);
	}

	@Override
	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCriteria(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCriteriaAndOr(nombre, apellido, cedula);
	}
	

}
