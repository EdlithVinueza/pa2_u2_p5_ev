package com.uce.edu;

import java.awt.geom.Arc2D;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;

import jakarta.persistence.Id;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

	
	@Autowired
	private IHotelService iHotelService;
	

	@Autowired
	private IHabitacionService iHabitacionService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	    // Crear un hotel
	    Hotel hotel = new Hotel();
	    hotel.setNombre("Hotel Ejemplo");
	    hotel.setDireccion("Dirección del Hotel");

	    // Crear habitaciones y asociarlas al hotel
	    Habitacion habitacion1 = new Habitacion();
	    habitacion1.setNumero("101");
	    habitacion1.setClase("Estandar");
	    habitacion1.setHotel(hotel);

	    Habitacion habitacion2 = new Habitacion();
	    habitacion2.setNumero("102");
	    habitacion2.setClase("Suite");
	    habitacion2.setHotel(hotel);

	    Habitacion habitacion3 = new Habitacion();
	    habitacion3.setNumero("103");
	    habitacion3.setClase("Ejecutiva");
	    habitacion3.setHotel(hotel);

	    // Crear una lista de habitaciones
	    List<Habitacion> habitaciones = new ArrayList<>();
	    habitaciones.add(habitacion1);
	    habitaciones.add(habitacion2);
	    habitaciones.add(habitacion3);

	    // Asignar la lista de habitaciones al hotel
	    hotel.setHabitaciones(habitaciones);

	    // Guardar el hotel y las habitaciones
	    iHotelService.guardar(hotel);
	    
	    Habitacion habitacionParaBorrar = iHabitacionService.buscar(habitacion1.getId());
	    iHabitacionService.borrar(habitacionParaBorrar.getId());
	    

	}

}
