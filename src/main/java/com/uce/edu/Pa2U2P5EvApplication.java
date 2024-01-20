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
	private ICiudadanoService iCiudadanoService;
	@Autowired
	private IAlumnoService iAlumnoService;
	@Autowired
	private IAutorService iAutorService;
	@Autowired
	private ILibroService iLibroService;
	@Autowired
	private IHotelService iHotelService;
	


	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
    //TypeQuery	
		this.iCiudadanoService.buscarPorNacionaliad("ecuatoriana");
		this.iHotelService.buscarEstrellas("5");
		this.iHotelService.buscarPorDireccion("Bella Vista");

		 
	//Native Query
		this.iAlumnoService.seleccionarPorNombre("Edlith Vinueza");
		this.iAutorService.buscarPorNacionalidad("Ecuatoriano");
		this.iAutorService.buscarPorNombre("Daniel Teran");
		this.iLibroService.seleccioanrPorTitulo("JAVA");
		this.iHotelService.buscarHotelSector("Quito Sur","Bella Vista");
		
	
	

	}
}
