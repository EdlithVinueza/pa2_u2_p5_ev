package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "videojuego")
public class VideoJuego {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_videojuego")
	@SequenceGenerator(name = "seq_videojuego", sequenceName = "seq_videojuego", allocationSize = 1)
	@Column(name = "videojuego_id")
	private Integer id;

	@Column(name = "videojuego_titulo")
	private String titulo;

	@Column(name = "videojuego_genero")
	private String genero;

	@Column(name = "videojuego_plataforma")
	private String plataforma;

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

}
