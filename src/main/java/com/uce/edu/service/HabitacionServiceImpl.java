package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacionesRepository;
import com.uce.edu.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private IHabitacionesRepository iHabitacionesRepository;

	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iHabitacionesRepository.seleccionar(id);
	}

	@Override
	public void guardar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.iHabitacionesRepository.insertar(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.iHabitacionesRepository.actualizar(habitacion);

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iHabitacionesRepository.eliminar(id);

	}

	@Override
	public List<Habitacion> buscarPorClase(String tipoClase) {
		// TODO Auto-generated method stub
		return this.iHabitacionesRepository.seleccionarPorClase(tipoClase);
	}

}
