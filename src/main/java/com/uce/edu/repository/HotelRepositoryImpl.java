package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);

	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hotel = this.seleccionar(id);
		this.entityManager.remove(hotel);

	}

	@Override
	public Hotel seleccionarHotelSector(String nombreHotel, String direccion) {
		// TODO Auto-generated method stub
		Query myQuery= this.entityManager.createNativeQuery("SELECT * FROM hotel h WHERE h.hote_nombre = :nombre AND h.hote_direccion =:direccion", Hotel.class);
		myQuery.setParameter("nombre", nombreHotel);
		myQuery.setParameter("direccion", direccion);
		return (Hotel)myQuery.getResultList().get(0);
	}

	@Override
	public Hotel seleccionarPorDireccion(String direccion) {
		// TODO Auto-generated method stub

		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h WHERE h.direccion = :direccion",Hotel.class);
		myQuery.setParameter("direccion", direccion);
		return myQuery.getSingleResult();
	}

	@Override
	public Hotel seleccionarEstrella(String numeroEstrella) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h WHERE h.estrellas = :numeroEstrella",Hotel.class);
		myQuery.setParameter("numeroEstrella", numeroEstrella);
		return myQuery.getSingleResult();
	}


}
