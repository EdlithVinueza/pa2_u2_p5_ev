package com.uce.edu.repository.modelo;

import java.util.List;

import javax.management.loading.PrivateClassLoader;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hotel")
	@SequenceGenerator(name = "seq_hotel", sequenceName = "seq_hotel", allocationSize = 1)
	@Column(name = "hote_id")
	private Integer id;
	
	@Column(name = "hote_nombre")
	private String nombre;
	
	@Column(name = "hote_direccion")
	private String direccion;
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL) //Debe copiar exactamente el mismo nombre mapeado en la otra clase, en este caso hotel del atributu private Hotel hotel  
	private List<Habitacion> habitaciones;
	
	@Column(name = "hote_estrellas")
	private String estrellas;
	
	//SET Y GET 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	

}
