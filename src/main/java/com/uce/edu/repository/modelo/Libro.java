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
@Table(name = "libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro")
	@SequenceGenerator(name = "seq_libro", sequenceName = "seq_libro", allocationSize = 1)
	@Column(name = "libro_id")
	private Integer id;

	@Column(name = "libro_titulo")
	private String titulo;

	@Column(name = "libro_autor")
	private String autor;

	@Column(name = "libro_genero")
	private String genero;

	@Column(name = "libro_sinopsis")
	private String sinopsis;

	@Column(name = "libro_fecha_publicacion")
	private LocalDateTime fechaPublicacion;

	@Column(name = "libro_numero_paginas")
	private Integer numeroPaginas;

	@Column(name = "libro_edicion")
	private String edicion;

	@Column(name = "libro_idioma_original")
	private String idiomaOriginal;

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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getIdiomaOriginal() {
		return idiomaOriginal;
	}

	public void setIdiomaOriginal(String idiomaOriginal) {
		this.idiomaOriginal = idiomaOriginal;
	}

}
