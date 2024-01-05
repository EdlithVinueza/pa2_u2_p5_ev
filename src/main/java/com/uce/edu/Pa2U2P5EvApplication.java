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

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
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
		
		Hotel hotel1 = new Hotel();
		hotel1.setDireccion("Av. America");
		hotel1.setNombre("Hola Mundo");
		
		Habitacion habi1 = new Habitacion();
		habi1.setClase("Economica");
		habi1.setNumero("A1");
		habi1.setHotel(hotel1);
		
		Habitacion habi2 = new Habitacion();
		habi2.setClase("Presidencial");
		habi2.setNumero("A2");
		habi2.setHotel(hotel1);
		
		List<Habitacion> habitaciones1 = new ArrayList<>();
		habitaciones1.add(habi1);
		habitaciones1.add(habi2);
		
		hotel1.setHabitaciones(habitaciones1);
		
		this.iHotelService.guardar(hotel1);
		
		Hotel hotel2 = new Hotel();
		
		Habitacion habi3 = new Habitacion();
		habi3.setClase("Economica");
		habi3.setNumero("B1");
		habi3.setHotel(hotel2);
		
		Habitacion habi4 = new Habitacion();
		habi4.setClase("Economica");
		habi4.setNumero("A2");
		habi4.setHotel(hotel2);
		
		List<Habitacion> habitaciones2 = new ArrayList<>();
		habitaciones2.add(habi3);
		habitaciones2.add(habi4);
				
		
		hotel2.setDireccion("Av. Florida");
		hotel2.setNombre("Vista del Mar ");
		hotel2.setHabitaciones(habitaciones2);
		
		this.iHotelService.guardar(hotel2);
		
		this.iHabitacionService.buscar(5);
		
		habi4.setNumero("B2");
		this.iHabitacionService.actualizar(habi4);
	

	}

}
