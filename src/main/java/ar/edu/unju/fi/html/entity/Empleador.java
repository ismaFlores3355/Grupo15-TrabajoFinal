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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="empleadores")
@Component
public class Empleador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long id;
	
	@Column(name="cant_vacantes")
	//@Min(value=8, message = "debe ser mayor a 8 digitos")
	private int cuit;
	
	@Column(name="contrasenia")
	//@NotEmpty(message = "la contrasenia no puede estar vacio")
	private String contrasenia;
	
	@Column(name="razon_social")
	//@NotEmpty(message = "la razon social no puede estar vacio")
	private String razons;
	
	@Column(name="nombre_comercial")
	//@NotEmpty(message = "el nombre comercial no puede estar vacio")
	private String nombrec;
	
	@Column(name="email")
	//@Email @NotEmpty
	private String email;
	
	@Column(name="fechain")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicioa;
	
	@Column(name="telefono")
	//@Min(value=1000000, message = "debe ser mayor a 8 digitos")
	private int telefono;
	
	@Column(name="domicilio")
	//@NotEmpty(message = "el domicilio no puede estar vacio")
	private String domicilio;
	
	@Column(name="provincia")
	//@NotEmpty(message = "la provincia no puede estar vacio")
	private String provincia;
	
	@Column(name="pagina_Web")
	//@NotEmpty(message = "la pagina web no puede estar vacio")
	private String paginaw;
	
	@Column(name="descripcion")
	//@NotEmpty(message = "la descripcion no puede estar vacio")
	private String descripcion;

	
	
	@Valid
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usu_id")
	private Usuario usuario;
	
	
	
	
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="of_id")
	private OfertasLaborales empleador;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="suc_id")
	private Ciudadano empleadorr;
	
	public Ciudadano getEmpleadorr() {
		return empleadorr;
	}

	public void setEmpleadorr(Ciudadano empleadorr) {
		this.empleadorr = empleadorr;
	}

	public OfertasLaborales getEmpleador() {
		return empleador;
	}

	public void setEmpleador(OfertasLaborales empleador) {
		this.empleador = empleador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getRazons() {
		return razons;
	}

	public void setRazons(String razons) {
		this.razons = razons;
	}

	public String getNombrec() {
		return nombrec;
	}

	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaInicioa() {
		return fechaInicioa;
	}

	public void setFechaInicioa(LocalDate fechaInicioa) {
		this.fechaInicioa = fechaInicioa;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPaginaw() {
		return paginaw;
	}

	public void setPaginaw(String paginaw) {
		this.paginaw = paginaw;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Empleador() {
		super();
	}

	public Empleador(Long id, @Min(value = 8, message = "debe ser mayor a 8 digitos") int cuit,
			@NotEmpty(message = "la contrasenia no puede estar vacio") String contrasenia,
			@NotEmpty(message = "la razon social no puede estar vacio") String razons,
			@NotEmpty(message = "el nombre comercial no puede estar vacio") String nombrec,
			@Email @NotEmpty String email, LocalDate fechaInicioa,
			@Min(value = 1000000, message = "debe ser mayor a 8 digitos") int telefono,
			@NotEmpty(message = "el domicilio no puede estar vacio") String domicilio,
			@NotEmpty(message = "la provincia no puede estar vacio") String provincia,
			@NotEmpty(message = "la pagina web no puede estar vacio") String paginaw,
			@NotEmpty(message = "la descripcion no puede estar vacio") String descripcion) {
		super();
		this.id = id;
		this.cuit = cuit;
		this.contrasenia = contrasenia;
		this.razons = razons;
		this.nombrec = nombrec;
		this.email = email;
		this.fechaInicioa = fechaInicioa;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.provincia = provincia;
		this.paginaw = paginaw;
		this.descripcion = descripcion;
	}
	
	
	
	
	
	

}
