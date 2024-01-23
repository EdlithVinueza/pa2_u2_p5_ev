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

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
	Ciudadano ciudadano1 = this.iCiudadanoService.buscarPorApellido("Luna");
	System.out.println(ciudadano1);
	
	Ciudadano ciudadano2 = this.iCiudadanoService.buscarPorCriteria("Juan", "Luna111", "1751674027");
	System.out.println(ciudadano2);

	Ciudadano ciudadano3 = this.iCiudadanoService.buscarPorCriteria("Juan", "Luna", "051674027");
	System.out.println(ciudadano3);
	
	System.out.println("Criteria API Query AND OR");
	
	Ciudadano ciudadano4 = this.iCiudadanoService.buscarPorCriteriaAndOr("Juan", "Luna", "1751674027");
	System.out.println(ciudadano4);
	
	Ciudadano ciudadano5 = this.iCiudadanoService.buscarPorCriteriaAndOr("Juan", "Luna", "0551674027");
	System.out.println(ciudadano5);
	

	}
}
