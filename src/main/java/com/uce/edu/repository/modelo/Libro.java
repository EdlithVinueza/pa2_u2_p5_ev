package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;
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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
@NamedQuery(name = "Libro.queryBuscarPorTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo")
@NamedQuery(name = "Libro.queryBuscarPorFecha", query = "SELECT l FROM Libro l WHERE l.fechaPublicacion > :fecha")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro")
	@SequenceGenerator(name = "seq_libro", sequenceName = "seq_libro", allocationSize = 1)
	@Column(name = "libr_id")
	private Integer id;
	
	@Column(name = "libr_nombre")
	private String titulo;
	
	@Column(name = "libr_fecha_publicacion")
	private LocalDateTime fechaPublicacion;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "autor_libro",
	joinColumns = @JoinColumn(name="auli_id_libro"), //Aqui ponemos a la tabla que escogimos como secundaria  
	inverseJoinColumns = @JoinColumn(name = "auli_id_autor"))//Aqui ponemos a la tabla que escogimos como principal 
	private Set<Autor> autores;
	
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
	public Set<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion +"]";
	}
	
	
	
}
