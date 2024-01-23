package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);

	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);

	}

	@Override
	public void insertar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2);
	}

	@Override
	public Libro seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		// SQL : SELECT*FROM libro l WHERE l.libr_titulo = ?
		// JPQL : SELECT l FROM Libro l WHERE l.titulo = : variable
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :variable"); // Retorna
																											// un objeto
																											// de tipo
																											// Query
		myQuery.setParameter("variable", nombre);
		return (Libro) myQuery.getSingleResult(); // este metodo me optiene un unico resultado, si tengo mas de algun
													// resultado da un error
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM libro l WHERE l.libr_fecha_publicacion >= ?
		// JPQL: SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha
		Query query = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha");
		query.setParameter("fecha", fechaPublicacion);
		return (List<Libro>) query.getResultList();
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo",
				Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager
				.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion = :fecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccioanrPorTitulo(String titulo) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM libro l WHERE l.libr_nombre = :titulo ",
				Libro.class);
		myQuery.setParameter("titulo", titulo);
		return (Libro) myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarLibroPorPalabraClave(String tituloDeReferencia) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriterianBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Libro> myCriteriaQuery = myCriterianBuilder.createQuery(Libro.class);
		Root<Libro> myFrom = myCriteriaQuery.from(Libro.class);
		Predicate condicionTitulo = null;
		String tituloMinuscula = tituloDeReferencia.toLowerCase();

		
		condicionTitulo = myCriterianBuilder.equal(myFrom.get("titulo"),"%" + tituloDeReferencia+"%");
		

		myCriteriaQuery.select(myFrom).where(condicionTitulo);

		TypedQuery<Libro> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getResultList();
	}

	@Override
	public List<Libro> seleccionarLibrosProgramacionPorAño(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriterianBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Libro> myCriteriaQuery = myCriterianBuilder.createQuery(Libro.class);
		Root<Libro> myFrom = myCriteriaQuery.from(Libro.class);

		Predicate condicionFecha = null;

		if (fecha.getYear() == 2024) {
			condicionFecha = myCriterianBuilder.equal(myFrom.get("fechaPublicacion"), fecha);
		}
		
		myCriteriaQuery.select(myFrom).where(condicionFecha);
		
		TypedQuery<Libro> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getResultList();


	}

}
