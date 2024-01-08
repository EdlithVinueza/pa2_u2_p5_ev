package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class Libro2RepositoryImpl implements ILibro2Repository {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Libro2 seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro2.class, id);
	}

	@Override
	public void insertar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2);

	}

	@Override
	public void actualizar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro2);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Libro2 libro2 = this.seleccionar(id);
		this.entityManager.remove(libro2);

	}

}
