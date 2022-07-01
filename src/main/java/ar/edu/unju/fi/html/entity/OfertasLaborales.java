package ar.edu.unju.fi.html.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="ofertas_laborales")
@Component
public class OfertasLaborales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="of_id")
	private Long id;
	
	@Column(name="cant_vacantes")
	@Min(value=1, message = "debe ser mayor a 1")
	private int cantvacantes;
   
	@NotEmpty(message = "el puesto no puede estar vacio")
	private String puestorequerido;
	
	@NotEmpty(message = "el puesto no puede estar vacio")
	private String resumendelp;
	
	@NotEmpty(message = "la disponibilidad horaria no puede estar vacio")
	private String disponibilidadh;
	
	@NotEmpty(message = "las principales tardes no puede estar vacio")
	private String princ_tareas;
	
	@Column(name="telefono")
	@Min(value=1000000, message = "debe ser mayor a 8 digitos")
	private int contacto;
	
	@Column(name="jornada")
	@NotEmpty(message = "la jornada no puede estar vacio")
	private String jornada;
	
	@Column(name="requisitos")
	@NotEmpty(message = "los requisitos no puede estar vacio")
	private String requisitos;
	
	@Column(name="salario")
	@Min(value=1000, message = "debe ser mayor a 1000")
	private double salario;
	
	@Column(name="beneficios")
	@NotEmpty(message = "los beneficios no puede estar vacio")
	private String beneficios;
	
	@Column(name="disponible")
	private boolean disponible;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Empleador empleador;
	
	@OneToMany(mappedBy = "empleador")
	private List<Empleador> empleadores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantvacantes() {
		return cantvacantes;
	}

	public void setCantvacantes(int cantvacantes) {
		this.cantvacantes = cantvacantes;
	}

	public String getPuestorequerido() {
		return puestorequerido;
	}

	public void setPuestorequerido(String puestorequerido) {
		this.puestorequerido = puestorequerido;
	}

	public String getResumendelp() {
		return resumendelp;
	}

	public void setResumendelp(String resumendelp) {
		this.resumendelp = resumendelp;
	}

	public String getDisponibilidadh() {
		return disponibilidadh;
	}

	public void setDisponibilidadh(String disponibilidadh) {
		this.disponibilidadh = disponibilidadh;
	}

	public String getPrinc_tareas() {
		return princ_tareas;
	}

	public void setPrinc_tareas(String princ_tareas) {
		this.princ_tareas = princ_tareas;
	}

	public int getContacto() {
		return contacto;
	}

	public void setContacto(int contacto) {
		this.contacto = contacto;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public OfertasLaborales() {
		super();
	}

	public OfertasLaborales(Long id, @Min(value = 1, message = "debe ser mayor a 1") int cantvacantes,
			@NotEmpty(message = "el puesto no puede estar vacio") String puestorequerido,
			@NotEmpty(message = "el puesto no puede estar vacio") String resumendelp,
			@NotEmpty(message = "la disponibilidad horaria no puede estar vacio") String disponibilidadh,
			@NotEmpty(message = "las principales tardes no puede estar vacio") String princ_tareas,
			@Min(value = 1000000, message = "debe ser mayor a 8 digitos") int contacto,
			@NotEmpty(message = "la jornada no puede estar vacio") String jornada,
			@NotEmpty(message = "los requisitos no puede estar vacio") String requisitos,
			@Min(value = 1000, message = "debe ser mayor a 1000") double salario,
			@NotEmpty(message = "los beneficios no puede estar vacio") String beneficios, boolean disponible,
			Ciudadano ciudadano, List<Ciudadano> ciudadanos) {
		super();
		this.id = id;
		this.cantvacantes = cantvacantes;
		this.puestorequerido = puestorequerido;
		this.resumendelp = resumendelp;
		this.disponibilidadh = disponibilidadh;
		this.princ_tareas = princ_tareas;
		this.contacto = contacto;
		this.jornada = jornada;
		this.requisitos = requisitos;
		this.salario = salario;
		this.beneficios = beneficios;
		this.disponible = disponible;
		
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	public List<Empleador> getEmpleadores() {
		return empleadores;
	}

	public void setEmpleadores(List<Empleador> empleadores) {
		this.empleadores = empleadores;
	}

	
	
	
	
}
