package com.uce.edu.service;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.modelo.Alumno;
@Service
public class AlumnoServiceImpl implements IAlumnoService{
	@Autowired
	private IAlumnoRepository iAlumnoRepository;

	@Override
	public Alumno buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iAlumnoRepository.seleccionar(id);
	}

	@Override
	public void guardar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.iAlumnoRepository.insertar(alumno);

	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.iAlumnoRepository.actualizar(alumno);

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iAlumnoRepository.eliminar(id);

	}

	@Override
	public Alumno seleccionarPorNombre(String Nombre) {
		// TODO Auto-generated method stub
		return this.iAlumnoRepository.seleccionarPorNombre(Nombre);
	}

}
