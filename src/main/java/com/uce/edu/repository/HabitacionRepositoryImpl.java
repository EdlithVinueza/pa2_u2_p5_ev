package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionesRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion habitacion= this.seleccionar(id);
		this.entityManager.remove(habitacion);

	}

	@Override
	public List<Habitacion> seleccionarPorClase(String tipoClase) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriterianBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Habitacion> myCriteriaQuery  = myCriterianBuilder.createQuery(Habitacion.class);
		Root<Habitacion> myFrom= myCriteriaQuery.from(Habitacion.class);
		Predicate condicionTipo= myCriterianBuilder.equal(myFrom.get("clase"), tipoClase);
		myCriteriaQuery.select(myFrom).where(condicionTipo);
		TypedQuery<Habitacion> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getResultList();
	}

}
