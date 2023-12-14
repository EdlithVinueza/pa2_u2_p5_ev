package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "galaxia")
public class Galaxia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_galaxia")
	@SequenceGenerator(name = "seq_galaxia", sequenceName = "seq_galaxia", allocationSize = 1)
	@Column(name = "galaxia_id")
	private Integer id;

	@Column(name = "galaxia_nombre")
	private String nombre;

	@Column(name = "galaxia_tamaño")
	private Double tamaño;

	@Column(name = "galaxia_numero_planetas")
	private Integer numeroPlanetas;

	// SET Y GET
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

	public Double getTamaño() {
		return tamaño;
	}

	public void setTamaño(Double tamaño) {
		this.tamaño = tamaño;
	}

	public Integer getNumeroPlanetas() {
		return numeroPlanetas;
	}

	public void setNumeroPlanetas(Integer numeroPlanetas) {
		this.numeroPlanetas = numeroPlanetas;
	}

}
