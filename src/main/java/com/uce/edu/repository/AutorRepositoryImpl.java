package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository{
	
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
		Autor2 autor = seleccionar(id);
		this.entityManager.remove(autor);
		
	}

	@Override
	public List<Autor> seleccionarPorNacionalidad(String nacionaliad) {
		// TODO Auto-generated method stub
		Query myQuery= this.entityManager.createNativeQuery("SELECT * FROM autor a WHERE a.auto_nacionalidad = :nacionaliad ", Autor.class);
		myQuery.setParameter("nacionaliad", nacionaliad);
		return (List<Autor>) myQuery.getResultList();
		
	}

	@Override
	public Autor seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery= this.entityManager.createNativeQuery("SELECT * FROM autor a WHERE a.auto_nombre = :nombre ", Autor.class);
		myQuery.setParameter("nombre", nombre);
		return (Autor) myQuery.getResultList().get(0);
	}

	@Override
	public List<Libro> seleccionarLibroPorAutor(String nombreAutor) {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE :nombreAutor MEMBER OF l.autores", Libro.class);
        myQuery.setParameter("nombreAutor", nombreAutor);
        return myQuery.getResultList();
		
	}

	@Override
	public List<Libro> seleccionarLibrosPorAutor(String nombreAutor) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriterianBuilder = this.entityManager.getCriteriaBuilder();
	    CriteriaQuery<Libro> myCriteriaQuery = myCriterianBuilder.createQuery(Libro.class);
	    Root<Libro> myFrom = myCriteriaQuery.from(Libro.class);

	    // Obtener la relación de autores
	    Join<Libro, Autor> autoresJoin = myFrom.join("autores");

	    // Crear la condición para el nombre del autor
	    Predicate condicionAutor = myCriterianBuilder.equal(autoresJoin.get("nombre"), nombreAutor);

	    myCriteriaQuery.select(myFrom).where(condicionAutor);

	    TypedQuery<Libro> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

	    return myTypedQuery.getResultList();
	}

}
