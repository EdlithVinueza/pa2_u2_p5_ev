package com.uce.edu;

import java.awt.geom.Arc2D;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.IAutorRepository;
import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

import jakarta.persistence.Id;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;
	
	@Autowired
	private IAutorService iAutorService;
	
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
		
	//1
	List<Habitacion> habitacion1 = this.iHabitacionService.buscarPorClase("Estandar");
	for (Habitacion h:habitacion1) {
		System.out.println(h);
	}
	//2
	List<Habitacion> habitacion2 = this.iHotelService.buscarHabitacionesDeHotel("Nuevo Nombre del Hotel");
	for (Habitacion h:habitacion2) {
		System.out.println(h);
	}
	//3
	List<Libro> libros1 = this.iAutorService.buscarLibrosPorAutor("Pedro Perez"); 	
	for (Libro l:libros1) {
		System.out.println(l);
	}
	//4
	List<Libro> libros2 = this.iLibroService.buscarLibrosProgramacionPorAño(LocalDateTime.of(2024, 01, 2, 0, 0));
	for (Libro l:libros2) {
		System.out.println(l);
	}
	//5
	List<Libro> libros3 = this.iLibroService.buscarLibroPorPalabraClave("JAVA"); 
	for (Libro l:libros3) {
		System.out.println(l);
	}

	}
}
