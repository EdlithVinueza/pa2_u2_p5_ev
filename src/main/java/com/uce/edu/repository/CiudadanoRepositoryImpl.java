package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciudadano = this.seleccionar(id);
		this.entityManager.remove(ciudadano);

	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado>myQuery=this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula =:cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaCiudadano(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery= this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula = :cedula ", Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano)myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorNacionaliad(String nacionalidad) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano>myQuery= this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.nacionalidad = :nacionalidad ", Ciudadano.class);
		myQuery.setParameter("nacionalidad", nacionalidad);
		return myQuery.getSingleResult();
	}

}
