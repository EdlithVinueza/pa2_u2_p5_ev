package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro2")
public class Libro2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro2")
	@SequenceGenerator(name = "seq_libro2", sequenceName = "seq_libro2", allocationSize = 1)
	@Column(name = "libr_id")
	private Integer id;
	
	@Column(name = "libr_nombre")
	private String titulo;
	
	@Column(name = "libr_fecha_publicacion")
	private LocalDateTime fechaPublicacion;
	
	@OneToMany(mappedBy = "libro2", cascade = CascadeType.ALL) //si quiero que la relaciones se inserten en cascada todos los autoresLibros
	private List<AutorLibro> librosAutores;
	
	//SET y GET 
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
	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public List<AutorLibro> getLibrosAutores() {
		return librosAutores;
	}
	public void setLibrosAutores(List<AutorLibro> librosAutores) {
		this.librosAutores = librosAutores;
	}
	
}
