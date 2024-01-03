package com.uce.edu;

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
import com.uce.edu.service.IHotelService;

import jakarta.persistence.Id;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

	@Autowired
	private IHotelService iHotelService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Hotel hotel = new Hotel();
		hotel.setDireccion("Colon");
		hotel.setNombre("Marriot");
		
		Habitacion habi1 = new Habitacion();
		habi1.setClase("Economica");
		habi1.setNumero("A1");
		habi1.setHotel(hotel);
		
		Habitacion habi2 = new Habitacion();
		habi2.setClase("Presidencial");
		habi2.setNumero("A2");
		habi2.setHotel(hotel);
		
		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(habi1);
		habitaciones.add(habi2);
		
		hotel.setHabitaciones(habitaciones);
		
		this.iHotelService.guardar(hotel);

	}

}
