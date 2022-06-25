package ar.edu.unju.fi.html.entity;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Component
@Entity
@Table(name="ciudadanos")
public class Ciudadano {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long id;
	
	@Column(name="dni")
	//@Min(value=1_000_000, message = "El dni debe ser mayor o igual a 1.000.000")
	private String dni;

	@Column(name="nrotramite")
	//@NotBlank(message = "En nro de tramite no puede estar vacio")
	private int nroTramite;

	@Column(name="email")
	@Email @NotEmpty
	private String email;
    
	@Column(name="estadocivil")
	@NotEmpty(message = "El estado civil no puede estar vacio")
	private String estadoCivil;
  
	@Column(name="provincia")
	@NotEmpty(message = "La provincia no estar vacia")
	private String provincia;
   
	@Column(name="telefono")
	//@NotEmpty(message = "El telefono no puede estar vacio")
	private int telefono;
   
	@Column(name="fechanaci")
	//@NotBlank @Past(message = "La fecha debe ser anterior a la fecha actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
  
	@Column(name="contrasenia")
	@NotBlank(message = "La contraseña no puede estar vacia")
	private String contrasenia;

	@Column(name = "perfil")
	//@NotBlank(message = "Ingrese un valor para perfil")
	private String perfil;
   
	
	@Valid
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usu_id")
	private Usuario usuario;
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getNroTramite() {
		return nroTramite;
	}

	public void setNroTramite(int nroTramite) {
		this.nroTramite = nroTramite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Ciudadano(Long id, String dni, int nroTramite, @Email @NotEmpty String email,
			@NotEmpty(message = "El estado civil no puede estar vacio") String estadoCivil,
			@NotEmpty(message = "La provincia no estar vacia") String provincia, int telefono,
			LocalDate fechaNacimiento, @NotBlank(message = "La contraseña no puede estar vacia") String contrasenia,
			@NotBlank(message = "Ingrese un valor para perfil") String perfil) {
		super();
		this.id = id;
		this.dni = dni;
		this.nroTramite = nroTramite;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasenia = contrasenia;
		this.perfil = perfil;
	}

	public Ciudadano() {
		super();
	}
	
	
  	

	/*
	@Valid
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usu_id")
	private Usuario usuario;
	
	*/
	
	
	
}
