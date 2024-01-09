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


import com.uce.edu.repository.IEmpleadoRepository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

import jakarta.persistence.Id;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {


	
	@Autowired 
	private ICiudadanoService iCiudadanoService;
	
	@Autowired 
	private IEmpleadoService iEmpleadoService;
	


	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Ciudadano c1 = new Ciudadano();
		Empleado em1= new Empleado();
		
		c1.setNombre("Juan");
		c1.setApellido("Casas");
		
		c1.setEmpleado(em1);
			
		em1.setFehcaIngreso(LocalDateTime.now());
		em1.setSalario(new BigDecimal(2000));
		
		em1.setCiudadano(c1);
		
		this.iCiudadanoService.guardar(c1);
		
		c1.setNombre("Camilo");
		this.iCiudadanoService.actualizar(c1);
		
		this.iEmpleadoService.borrar(9);
		
		
		Ciudadano c2 = new Ciudadano();
		Empleado em2= new Empleado();
		
		em2.setFehcaIngreso(LocalDateTime.now());
		em2.setSalario(new BigDecimal(450));
		
		em2.setCiudadano(c2);
		
		c2.setNombre("Maria");
		c2.setApellido("Cueva");
		
		c2.setEmpleado(em2);
		
		this.iEmpleadoService.guardar(em2);
		
		this.iEmpleadoService.buscar(2);
		
		em2.setSalario(new BigDecimal(4500));
		
		this.iEmpleadoService.actualizar(em2);
		
		
		
		
					

	}

}
