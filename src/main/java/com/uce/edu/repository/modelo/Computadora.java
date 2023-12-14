package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "computadora")
public class Computadora {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_computadora")
	@SequenceGenerator(name = "seq_computadora", sequenceName = "seq_computadora", allocationSize = 1)
	@Column(name = "computadora_id")
	private Integer id;

	@Column(name = "computadora_marca")
	private String marca;

	@Column(name = "computadora_modelo")
	private String modelo;

	@Column(name = "computadora_procesador")
	private String procesador;

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

}
