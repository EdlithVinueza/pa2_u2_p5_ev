package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHotelRepository;
import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService{
	@Autowired
	private IHotelRepository iHoteRepository;

	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iHoteRepository.seleccionar(id);
	}

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.iHoteRepository.insertar(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.iHoteRepository.actualizar(hotel);
		
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iHoteRepository.eliminar(id);
		
	}

	@Override
	public Hotel buscarHotelSector(String nombreHotel, String direccion) {
		// TODO Auto-generated method stub
		return this.iHoteRepository.seleccionarHotelSector(nombreHotel, direccion);
	}

	@Override
	public Hotel buscarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		return this.iHoteRepository.seleccionarPorDireccion(direccion);
	}

	@Override
	public Hotel buscarEstrellas(String nombreStringHotel) {
		// TODO Auto-generated method stub
		return this.iHoteRepository.seleccionarEstrella(nombreStringHotel);
	}




	

}
