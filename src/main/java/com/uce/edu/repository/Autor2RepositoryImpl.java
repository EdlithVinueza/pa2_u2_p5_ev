package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class Autor2RepositoryImpl implements IAutor2Repository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Autor2 seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor2.class, id);
	}

	@Override
	public void insertar(Autor2 autor2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor2);

	}

	@Override
	public void actualizar(Autor2 autor2) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor2);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Autor2 autor2 = this.seleccionar(id);
		this.entityManager.remove(autor2);

	}

}
