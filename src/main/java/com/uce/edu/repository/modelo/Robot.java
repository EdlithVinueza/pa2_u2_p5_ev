package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "robot")
public class Robot {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_robot")
	@SequenceGenerator(name = "seq_robot", sequenceName = "seq_robot", allocationSize = 1)
	@Column(name = "robot_id")
	private Integer id;

	@Column(name = "robot_nombre")
	private String nombre;

	@Column(name = "robot_tipo")
	private String tipo;

	@Column(name = "robot_bateria")
	private Integer bateria;

	@Column(name = "robot_material")
	private String material;

	@Column(name = "robot_inteligencia_artificial")
	private Boolean inteligenciaArtificial;

	@Column(name = "robot_habilidades_especiales")
	private String habilidadesEspeciales;

	@Column(name = "robot_fecha_fabricacion")
	private LocalDateTime fechaFabricacion;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getBateria() {
		return bateria;
	}

	public void setBateria(Integer bateria) {
		this.bateria = bateria;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Boolean getInteligenciaArtificial() {
		return inteligenciaArtificial;
	}

	public void setInteligenciaArtificial(Boolean inteligenciaArtificial) {
		this.inteligenciaArtificial = inteligenciaArtificial;
	}

	public String getHabilidadesEspeciales() {
		return habilidadesEspeciales;
	}

	public void setHabilidadesEspeciales(String habilidadesEspeciales) {
		this.habilidadesEspeciales = habilidadesEspeciales;
	}

	public LocalDateTime getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(LocalDateTime fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

}
