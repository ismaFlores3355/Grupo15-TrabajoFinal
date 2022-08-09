package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="icurso")
@Component
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="of_id")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="fechain")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
	
	@Column(name="fechafin")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaFin;
	
	@Column(name="canthoras")
	private int canthoras;
	
	@Column(name="modalidad")
	private String modalidad;
	@Column(name="categoria")
	private String categoria;
	
	
	@OneToMany(mappedBy = "curso",cascade = CascadeType.ALL)
	private List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getCanthoras() {
		return canthoras;
	}


	public void setCanthoras(int canthoras) {
		this.canthoras = canthoras;
	}


	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}


	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}


	public Curso(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, int canthoras, String modalidad,
			String categoria, List<Ciudadano> ciudadanos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.canthoras = canthoras;
		this.modalidad = modalidad;
		this.categoria = categoria;
		this.ciudadanos = ciudadanos;
	}


	public Curso() {
		super();
	}
	
	
	
	
	
	
}
