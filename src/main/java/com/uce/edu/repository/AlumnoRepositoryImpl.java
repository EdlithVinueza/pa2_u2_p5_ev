package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlumnoRepositoryImpl implements IAlumnoRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Alumno seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Alumno.class, id);
	}

	@Override
	public void insertar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.persist(alumno);

	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.merge(alumno);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Alumno alumno = this.seleccionar(id);
		this.entityManager.remove(alumno);

	}

	@Override
	public Alumno seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery= this.entityManager.createNativeQuery("SELECT * FROM alumno a WHERE a.alum_nombre = :nombre ", Alumno.class);
		myQuery.setParameter("nombre", nombre);
		return (Alumno)myQuery.getSingleResult();
	}

}
