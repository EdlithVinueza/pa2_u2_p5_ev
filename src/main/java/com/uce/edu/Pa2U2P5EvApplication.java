package com.uce.edu;

import java.awt.geom.Arc2D;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAlumnoService;
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
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Libro libro = new Libro();
		libro.setTitulo("JAVA");
		libro.setFechaPublicacion(LocalDateTime.now());
		
		Autor au1 = new Autor();
		Autor au2 = new Autor();
		
		au1.setNombre("Pedro Perez ");
		au1.setNacionalidad("Ecuatoriano");
		
		au2.setNombre("Daniel Teran");
		au2.setNacionalidad("Ecuatoriano");
	
		Set <Autor> autores = new HashSet<Autor>();
		autores.add(au1);
		autores.add(au2);
				
		libro.setAutores(autores);
		
		Set <Libro> libros = new HashSet<Libro>();
		libros.add(libro);
		
		au1.setLibros(libros);
		au2.setLibros(libros);
		
		this.iLibroService.guardar(libro);
		

	}
}
