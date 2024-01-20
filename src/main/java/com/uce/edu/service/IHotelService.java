package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

public interface IHotelService {

	public Hotel buscar(Integer id);

	public void guardar(Hotel hotel);

	public void actualizar(Hotel hotel);

	public void borrar(Integer id);

	public Hotel buscarHotelSector(String nombreHotel, String direccion);
	
	public Hotel buscarPorDireccion(String direccion);
	
	public Hotel buscarEstrellas(String nombreStringHotel);

}
