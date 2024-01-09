package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHotelRepository;
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


	

}
