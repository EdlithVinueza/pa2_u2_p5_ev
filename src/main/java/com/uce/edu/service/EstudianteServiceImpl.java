package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.modelo.Estudiante;
@Service
public class EstudianteServiceImpl implements IEstudianteService {
	
	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.seleccionar(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.insertar(estudiante);

	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.actualizar(estudiante);

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.eliminar(id);

	}

}
