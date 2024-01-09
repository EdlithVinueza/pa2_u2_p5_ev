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

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Un libro Con un Autor
		Libro2 libro = new Libro2();
		libro.setTitulo("JAVA");
		libro.setFechaPublicacion(LocalDateTime.now());
		
		Autor2 au1 = new Autor2();
		au1.setNombre("Pedro Perez ");
		au1.setNacionalidad("Ecuatoriano");
	
		Autor2 au2 = new Autor2();
		au2.setNombre("Daniel Teran");
		au2.setNacionalidad("Ecuatoriano");
				
		List<Autor2> autores1 = new ArrayList<Autor2>();
		autores1.add(au1);
		autores1.add(au2);
		
		AutorLibro autorLibro1 = new AutorLibro();
		autorLibro1.setLibro2(libro);
		autorLibro1.setAutor2(au1);
		autorLibro1.setFecha(LocalDateTime.now());
		
		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(libro);
		autorLibro2.setAutor2(au2);
		autorLibro2.setFecha(LocalDateTime.now());
		
		List<AutorLibro> lista = new ArrayList<AutorLibro>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);
		
		libro.setLibrosAutores(lista);
		
		//this.iLibroService.guardar(libro);
		
		Libro libro1 = this.iLibroService.buscarPorNombre("JAVA");
		
		System.out.println(libro1);
			
	}
}
