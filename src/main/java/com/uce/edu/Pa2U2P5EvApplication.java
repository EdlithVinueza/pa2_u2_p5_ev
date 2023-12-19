package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

	@Autowired
	private IEmpleadoService iEmpleadoService;

	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Ciudadano ciudadano = new Ciudadano();

		ciudadano.setNombre("Edlith");
		ciudadano.setApellido("Vinueza");

		this.iCiudadanoService.guardar(ciudadano);

		Empleado empleado = new Empleado();

		empleado.setSalario(new BigDecimal(7000));
		empleado.setFehcaIngreso(LocalDateTime.now());

		Ciudadano ciudadano2 = new Ciudadano();

		ciudadano2 = this.iCiudadanoService.buscar(1);
		empleado.setCiudadano(ciudadano2);

	}

}
