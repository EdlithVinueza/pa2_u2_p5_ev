package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {
	
	@Autowired
	private IEstudianteService iEstudianteService;
	
	@Autowired
	private IAlumnoService iAlumnoService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//Creamos el nuevo Estudiante 
		Estudiante estudiante = new Estudiante();
		estudiante.setApellido("Vinueza");
		estudiante.setCedula("1751674027");
		estudiante.setFechaNacimiento(LocalDateTime.of(2000, 01, 12, 3, 0));
		estudiante.setNombre("Edlith");
		
		//Guardar Estudiante 
		//this.iEstudianteService.guardar(estudiante);
		
		//Buscar Estudiante 
		Estudiante estudiante2 = this.iEstudianteService.buscar(2);
		System.out.println(estudiante2);
		
		estudiante2.setNombre("Actualizado");
		//Actualizar Estudiante 
		this.iEstudianteService.actualizar(estudiante2);
		
		//Eliminar Estudiante 
		this.iEstudianteService.borrar(5);
		
		
		
		//Creamos el nuevo Alummno 
		
		Alumno alumno = new Alumno();
		alumno.setNombre("Alumno 1 ");
		
		//Guardamos Alumno 
		this.iAlumnoService.guardar(alumno);
		
		//Buscar Alumno 
		Alumno alumno2 = this.iAlumnoService.buscar(2);
		//Actualizar Alumno
		
		alumno2.setNombre("Alumno Actualizado");
		this.iAlumnoService.actualizar(alumno2);
		
		//Eliminar Alumno 
		 
		this.iAlumnoService.borrar(2);
		
	
		
	
	}

}
