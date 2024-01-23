package com.uce.edu.repository;

import java.util.*;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

public interface IHotelRepository {
	
	// CRUD
		public Hotel seleccionar(Integer id);

		public void insertar(Hotel hotel);

		public void actualizar(Hotel hotel);

		public void eliminar(Integer id);
		
		public Hotel seleccionarHotelSector(String nombreHotel, String direccion);
		
		public Hotel seleccionarPorDireccion(String direccion);
		
		public Hotel seleccionarEstrella(String numeroEstrella);
		
		public List<Habitacion> seleccioanarHabitacionesDeHotel(String nombreHotel); 


}
